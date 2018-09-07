package leetcode_Easy;

/*69 Implement int sqrt(int x). Compute and return the square root of x, where
x is guaranteed to be a non-negative integer. Since the return type is an
integer, the decimal digits are truncated and only the integer part of the
result is returned.
Input: 4		Output: 2
Input: 8		Output: 2
The square root of 8 is 2.82842..., and since the decimal part is truncated, 2
is returned																	 */

public class SqrtX {
	public int mySqrt(int x) {

		int left = 1, right = x;

		while (left <= right) {

			int mid = left + (right - left) / 2;

			if (mid == x / mid) {
				return mid;
			} else if (mid < x / mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}
}
