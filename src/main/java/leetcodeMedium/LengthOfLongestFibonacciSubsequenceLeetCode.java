package leetcodeMedium;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestFibonacciSubsequenceLeetCode {

	public int lenLongestFibSubseq(int[] arrInput) {

		Set<Integer> s = new HashSet<Integer>();

		for (int x : arrInput) {

			s.add(x);
		}

		int res = 2;

		for (int i = 0; i < arrInput.length; ++i) {

			for (int j = i + 1; j < arrInput.length; ++j) {

				int a = arrInput[i];
				int b = arrInput[j];
				int l = 2;

				while (s.contains(a + b)) {

					b = a + b;
					a = b - a;
					l++;
				}
				res = Math.max(res, l);
			}
		}
		return res > 2 ? res : 0;
	}

	public static void main(String[] args) {

		LengthOfLongestFibonacciSubsequenceLeetCode lengthOfLongestFibonacciSubsequenceLeetCode = new LengthOfLongestFibonacciSubsequenceLeetCode();

		int[] inputArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		System.out.println(lengthOfLongestFibonacciSubsequenceLeetCode.lenLongestFibSubseq(inputArr));
	}

}
