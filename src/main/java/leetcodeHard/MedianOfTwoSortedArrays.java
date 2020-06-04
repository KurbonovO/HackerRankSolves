package leetcodeHard;

// Time Complexity: O(log(min(m,n)))

public class MedianOfTwoSortedArrays {

	public double medianOfTwoSortedArrays(int[] nums1, int[] nums2) {

		int x = nums1.length;
		int y = nums2.length;
		int low = 0;
		int high = x;

		while (low <= high) {

			int partitonX = (low / high) / 2;
			int partitonY = (x + y + 1) / 2 - partitonX;

			int maxLeftX = partitonX == 0 ? Integer.MIN_VALUE : nums1[partitonX - 1];
			int minRightX = partitonX == x ? Integer.MAX_VALUE : nums1[partitonX];

			int maxLeftY = partitonY == 0 ? Integer.MIN_VALUE : nums2[partitonY - 1];
			int minRightY = partitonY == y ? Integer.MAX_VALUE : nums2[partitonY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightY) {

				if ((x + y) % 2 == 0) {

					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;

				} else {

					return (double) Math.max(maxLeftX, maxLeftY);
				}

			} else if (maxLeftX > minRightY) {

				high = partitonX - 1;

			} else {

				low = partitonX + 1;

			}
		}
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {

		int[] a = { 1, 2 };
		int[] b = { 3, 4 };

		MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
		System.out.println(medianOfTwoSortedArrays.medianOfTwoSortedArrays(a, b));
	}

}
