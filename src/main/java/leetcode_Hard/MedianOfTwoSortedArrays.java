package leetcode_Hard;

/*4 There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity
should be O(log (m+n)).
nums1 = [1, 3]		nums2 = [2]
The median is 2.0
nums1 = [1, 2]		nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5												 */

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int m = nums1.length;
		int n = nums2.length;

		if (m > n) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int intI = 0, intJ = 0, intIMin = 0, intIMax = m, half = (m + n + 1) / 2;
		double maxLeft = 0, minRight = 0;
		
		while (intIMin <= intIMax) {
			
			intI = (intIMin + intIMax) / 2;
			intJ = half - intI;
			
			if (intJ > 0 && intI < m && nums2[intJ - 1] > nums1[intI]) {
				intIMin = intI + 1;
			} 
			else if (intI > 0 && intJ < n && nums1[intI - 1] > nums2[intJ]) {
				intIMax = intI - 1;
			} 
			else {
				
				if (intI == 0) {
					maxLeft = (double) nums2[intJ - 1];
				} 
				else if (intJ == 0) {
					maxLeft = (double) nums1[intI - 1];
				} 
				else {
					maxLeft = (double) Math.max(nums1[intI - 1], nums2[intJ - 1]);
				}
				break;
			}
		}
		
		if ((m + n) % 2 == 1) {
			return maxLeft;
		}
		
		if (intI == m) {
			minRight = (double) nums2[intJ];
		} 
		else if (intJ == n) {
			minRight = (double) nums1[intI];
		} 
		else {
			minRight = (double) Math.min(nums1[intI], nums2[intJ]);
		}
		return (double) (maxLeft + minRight) / 2;
	}
}
