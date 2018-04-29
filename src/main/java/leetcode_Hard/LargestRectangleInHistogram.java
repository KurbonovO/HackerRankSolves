package leetcode_Hard;

import java.util.Stack;

/*84 Given n non-negative integers representing the histogram's bar height
where the width of each bar is 1, find the area of largest rectangle in the
histogram. Above is a histogram where width of each bar is 1, given 
height = [2,1,5,6,2,3]. The largest rectangle is shown in the shaded area,
which has area = 10 unit.
Input: [2,1,5,6,2,3]		Output: 10										 */

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {

		int lenght = height.length;
		Stack<Integer> strackInteger = new Stack<Integer>();
		int maxArea = 0;

		for (int i = 0; i <= lenght; i++) {
			int h = (i == lenght ? 0 : height[i]);

			if (strackInteger.isEmpty() || h >= height[strackInteger.peek()]) {
				strackInteger.push(i);
			} else {
				int top = strackInteger.pop();
				maxArea = Math.max(maxArea, height[top] * 
						(strackInteger.isEmpty() ? i : i - 1 - strackInteger.peek()));
				i--;
			}
		}
		return maxArea;
	}
}