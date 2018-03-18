package sortingChallenges;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*Consider an array of numeric strings, unsorted, where each string is a positive number with anywhere from 1 to 10^6 digits.
Sort the array's elements in non-decreasing (i.e., ascending) order of their real-world integer values and print each element
of the sorted array on a new line.
Input Format: The first line contains an integer, n, denoting the number of strings in unsorted. Each of the n subsequent lines
contains a string of integers describing an element of the array*/

public class BigSorting {
	void solve(Scanner in, PrintWriter out) {
		
		String a[] = new String[in.nextInt()];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = in.next();
		}
		
		Arrays.sort(a, (left, right) -> {
			if (left.length() != right.length()) {
				return left.length() - right.length();
			} else {
				return left.compareTo(right);
			}
		});
		
		for (String s : a) {
			out.println(s);
		}
	}

	void run() {
		try (Scanner in = new Scanner(System.in);
				PrintWriter out = new PrintWriter(System.out);) {
			solve(in, out);
		}
	}

	public static void main(String args[]) {
		new BigSorting().run();
	}
}

/*Sample Input:
6
31415926535897932384626433832795
1
3
10
3
5
Sample Output:
1
3
3
5
10
31415926535897932384626433832795
Explanation: The initial array of strings is unsorted = [31415926535897932384626433832795, 1, 3, 10, 3, 5]. When we order each string
by the real-world integer value it represents, we get:
1 <_ 3 <_ 3 <_ 5 <_ 10 <_ 31415926535897932384626433832795 We then print each value on a new line, from smallest to largest*/
