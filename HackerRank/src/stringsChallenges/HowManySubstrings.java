package stringsChallenges;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.Writer;
import java.io.BufferedReader;

/*Consider a string of n characters, s, of where each character is indexed from  to n-1.
You are given q queries in the form of two integer indices: left and right. For each query, count and print
the number of different substrings of s in the inclusive range between left and right.
Note: Two substrings are different if their sequence of characters differs by at least one. For example, given the string s=aab,
substrings s[0,0]=a and s[1,1]=a are the same but substrings s[0,1]=aa and  s[1,2]ab are different.
Input Format: The first line contains two space-separated integers describing the respective values of n and q. 
The second line contains a single string denoting s. 
Each of the q subsequent lines contains two space-separated integers describing the respective values of left and right for a query.
Subtasks: For 30% of the test cases 1<_ n,q <_100, 
For 50% of the test cases 1<_ n,q <_3000,
For 100% of the test cases 1<_ n,q <_10^5*/

public class HowManySubstrings {

	public static void main(String[] args) {

		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;

		FastScanner fastScanner = new FastScanner(inputStream);
		FastPrinter fastPrinter = new FastPrinter(outputStream);

		NumberOfSubstrings2 solver = new NumberOfSubstrings2();

		solver.solve(1, fastScanner, fastPrinter);
		fastPrinter.close();
	}

	static class NumberOfSubstrings2 {
		public void solve(int testNumber, FastScanner fastScanner,
				FastPrinter fastPrinter) {

			int n = fastScanner.nextInt();

			int q = fastScanner.nextInt();

			String s = fastScanner.next();

			int[] a = new int[s.length() + 1];
			
			for (int i = 0; i < s.length(); i++)
				a[i] = s.charAt(i);
			
			int[] sa = SuffixArray.buildSuffixArray(a);
			int[] lcp = SuffixArray.getLCP(sa, a);
			NumberOfSubstrings2.Query[] qs = new NumberOfSubstrings2.Query[q];
			
			for (int i = 0; i < q; i++) {
				qs[i] = new NumberOfSubstrings2.Query(fastScanner.nextInt() - 1,
						fastScanner.nextInt() - 1);
			}
			
			List<NumberOfSubstrings2.Query>[] queries = new List[n];
			
			for (int i = 0; i < n; i++)
				queries[i] = new ArrayList<>();
			
			for (NumberOfSubstrings2.Query e : qs)
				queries[e.left].add(e);
			
			MinSegmentTree minTree = new MinSegmentTree(n + 1);
			
			int[] where = new int[sa.length];
			
			for (int i = 0; i < sa.length; i++)
				where[sa[i]] = i;
			
			SparseTableMin stable = new SparseTableMin(lcp);
			FenwickMultiSum fSum = new FenwickMultiSum(n);
			
			for (int i = n - 1; i >= 0; i--) {
				int suffix = where[i];
				int curLen = 0;
				
				while (true) {
					int left = -1;
					int right = suffix;
					
					while (left < right - 1) {
						int mid = (left + right) >> 1;
						
					if (stable.getMin(mid, suffix) <= curLen) {
							left = mid;
						} 
					else {
							right = mid;
						}
					}
					
					int first = right;
					left = suffix - 1;
					right = n + 1;
					
					while (left < right - 1) {
						int mid = (left + right) >> 1;
						
					if (stable.getMin(suffix, mid + 1) <= curLen) {
							right = mid;
						} 
					else {
							left = mid;
						}
					}
					
					int last = right;
					int j = minTree.getMin(first, last + 1);
					
					if (j == Integer.MAX_VALUE)
						break;
					
					int nextSuffix = where[j];
					int curLCP = nextSuffix < suffix ? stable.getMin(nextSuffix, suffix)
							: stable.getMin(suffix, nextSuffix);
					
					fSum.add(j + curLen, j + curLCP, -1);
					curLen = curLCP;
				}
				
				minTree.set(suffix, i);
				fSum.add(i, n, 1);
				
				for (NumberOfSubstrings2.Query e : queries[i]) {
					e.answer = fSum.getSum(e.left, e.right + 1);
				}
			}
			
			for (NumberOfSubstrings2.Query e : qs)
				fastPrinter.println(e.answer);
		}

		static class Query {
			int left;
			int right;
			long answer;

			public Query(int left, int right) {
				this.left = left;
				this.right = right;
			}

		}

	}

	static class FenwickMultiSum {
		
		FenwickLong fX;
		FenwickLong f;

		public FenwickMultiSum(int n) {
			fX = new FenwickLong(n);
			f = new FenwickLong(n);
		}

		public void add(int x, long d) {
			fX.add(x, d);
			f.add(x, d * (1 - x));
		}

		public void add(int left, int right, long d) {
			add(left, d);
			add(right, -d);
		}

		public long getSum(int x) {
			return f.getSum(x) + fX.getSum(x) * x;
		}

		public long getSum(int left, int right) {
			return getSum(right - 1) - getSum(left - 1);
		}

	}

	static class MinSegmentTree {
		
		int[] min;
		int[] minId;
		int n;

		public MinSegmentTree(int n) {
			
			this.n = Integer.highestOneBit(n) << 1;
			min = new int[this.n * 2];
			minId = new int[this.n * 2];
			
			for (int i = 0; i < n; i++) {
				minId[i + this.n] = i;
			}
			
			for (int i = 0; i < n; i++) {
				set(i, Integer.MAX_VALUE);
			}
		}

		public void set(int x, int y) {
			
			x += n;
			min[x] = y;
			
			while (x > 1) {
				x >>= 1;
				int left = min[x << 1];
				int right = min[(x << 1) | 1];
				
				if (left <= right) {
					min[x] = left;
					minId[x] = minId[x << 1];
				} 
				else {
					min[x] = right;
					minId[x] = minId[(x << 1) | 1];
				}
			}
		}

		public int getMin(int left, int right) {
			
			--right;
			left += n;
			right += n;
			int ret = Integer.MAX_VALUE;
			
			while (left <= right) {
				
				if ((left & 1) == 1) {
					ret = Math.min(ret, min[left]);
					left++;
				}
				
				if ((right & 1) == 0) {
					ret = Math.min(ret, min[right]);
					right--;
				}
				left >>= 1;
				right >>= 1;
			}
			return ret;
		}

	}

	static class FenwickLong {
		long[] a;

		public FenwickLong(int n) {
			a = new long[n];
		}

		public void add(int x, long y) {
			
			for (int i = x; i < a.length; i |= i + 1) {
				a[i] += y;
			}
		}

		public long getSum(int x) {
			
			if (x >= a.length)
				x = a.length - 1;
			long ret = 0;
			
			for (int i = x; i >= 0; i = (i & (i + 1)) - 1) {
				ret += a[i];
			}
			return ret;
		}

	}

	static class FastScanner extends BufferedReader {
		public FastScanner(InputStream is) {
			super(new InputStreamReader(is));
		}

		public int read() {
			
			try {
				int ret = super.read();
				// if (isEOF && ret < 0) {
				// throw new InputMismatchException();
				// }
				// isEOF = ret == -1;
				return ret;
			} 
			catch (IOException e) {
				throw new InputMismatchException();
			}
		}

		public String next() {
			
			StringBuilder sb = new StringBuilder();
			int c = read();
			
			while (isWhiteSpace(c)) {
				c = read();
			}
			
			if (c < 0) {
				return null;
			}
			
			while (c >= 0 && !isWhiteSpace(c)) {
				sb.appendCodePoint(c);
				c = read();
			}
			return sb.toString();
		}

		static boolean isWhiteSpace(int c) {
			return c >= 0 && c <= 32;
		}

		public int nextInt() {
			
			int c = read();
			while (isWhiteSpace(c)) {
				c = read();
			}
			int sgn = 1;
			
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int ret = 0;
			
			while (c >= 0 && !isWhiteSpace(c)) {
				if (c < '0' || c > '9') {
					throw new NumberFormatException(
							"digit expected " + (char) c + " found");
				}
				ret = ret * 10 + c - '0';
				c = read();
			}
			return ret * sgn;
		}

		public String readLine() {
			try {
				return super.readLine();
			} catch (IOException e) {
				return null;
			}
		}

	}

	static class FastPrinter extends PrintWriter {
		public FastPrinter(OutputStream out) {
			super(out);
		}

		public FastPrinter(Writer out) {
			super(out);
		}

	}

	static class SparseTableMin {
		
		int[][] min;
		int[] h;

		public SparseTableMin(int[] a) {
			
			h = new int[a.length + 1];
			h[1] = 0;
			
			for (int i = 2; i < h.length; i++) {
				h[i] = h[i >> 1] + 1;
			}
			
			min = new int[h[h.length - 1] + 1][a.length];
			
			for (int i = 0; i < a.length; i++) {
				min[0][i] = a[i];
			}
			
			for (int i = 1; i < min.length; i++) {
				int[] prev = min[i - 1];
				int[] mini = min[i];
				
				for (int v = 0; v < a.length; v++) {
					
					if (v + (1 << (i - 1)) < a.length) {
						mini[v] = Math.min(prev[v], prev[v + (1 << (i - 1))]);
					} 
					else {
						mini[v] = prev[v];
					}
				}
			}
		}

		public int getMin(int left, int right) {
			
			if (right <= left) {
				return Integer.MAX_VALUE;
			}
			int k = h[right - left];
			int[] mink = min[k];
			return Math.min(mink[left], mink[right - (1 << k)]);
		}

	}

	static class SuffixArray {
		public static int[] buildSuffixArray(int[] s) {
			
			int n = s.length;
			int alphabet = 0;
			
			for (int i : s) {
				alphabet = Math.max(alphabet, i);
			}
			
			++alphabet;
			int[] h = new int[Math.max(n, alphabet)];
			int[] c = new int[n];
			int[] d = new int[n];
			int[] count = new int[alphabet];
			
			for (int i = 0; i < n; i++) {
				c[i] = s[i];
				count[c[i]]++;
			}
			
			for (int i = 1; i < alphabet; i++) {
				h[i] = h[i - 1] + count[i - 1];
			}
			
			int[] a = new int[n];
			int[] b = new int[n];
			
			{
				int[] g = h.clone();
				for (int i = 0; i < n; i++) {
					a[g[c[i]]++] = i;
				}
			}
			
			for (int w = 1; w < n; w <<= 1) {
				
				for (int i = 0; i < n; i++) {
					int j = good(a[i] - w + n, n);
					b[h[c[j]]++] = j;
				}
				
				int nc = 0;
				h[nc++] = 0;
				d[b[0]] = 0;
				
				for (int i = 1; i < n; i++) {
					
					if (c[b[i]] != c[b[i - 1]] || c[good(b[i] + w, n)] != c[good(b[i - 1] + w, n)]) {
						h[nc++] = i;
					}
					d[b[i]] = nc - 1;
				}
				int[] t = a;
				a = b;
				b = t;
				t = c;
				c = d;
				d = t;
			}
			return a;
		}

		static int good(int x, int n) {
			
			if (x >= n) {
				x -= n;
			}
			return x;
		}

		public static int[] getLCP(int[] sa, int[] a) {
			
			int k = 0;
			int n = a.length;
			int[] rev = new int[n];
			
			for (int i = 0; i < n; i++) {
				rev[sa[i]] = i;
			}
			
			int[] lcp = new int[n];
			
			for (int i = 0; i < n; i++) {
				
				k = Math.max(k - 1, 0);
				int j = rev[i] + 1;
				
				if (j >= n)
					continue;
				j = sa[j];
				
				while (i + k < n && j + k < n && a[i + k] == a[j + k])
					++k;
				lcp[rev[i]] = k;
			}
			return lcp;
		}

	}
}

/*Sample Input:
5 5
aabaa
1 1
1 4
1 1
1 4
0 2
Sample Output:
1
8
1
8
5
Explanation: Given  s=aabaa, we perform the following q=5 queries:
1) 1 1: The only substring of a is itself, so we print 1 on a new line.
2) 1 4: The substrings of abaa are a, b, ab, ba, aa, aba, baa, and abaa, so we print 8 on a new line.
3) 1 1: The only substring of a is itself, so we print 1 on a new line.
4) 1 4: The substrings of abaa are a, b, ab, ba, aa, aba, baa, and abaa, so we print 8 on a new line.
5) 0 2: The substrings of aab are a, b, aa, ab, and aab, so we print 5 on a new line*/
