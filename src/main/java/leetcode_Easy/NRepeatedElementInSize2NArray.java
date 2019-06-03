package leetcode_Easy;

public class NRepeatedElementInSize2NArray {

	public int repeatedNTimes(int[] A) {

		int[] count = new int[10000];

		for (int a : A) {
			
			if (count[a]++ == 1) {
				
				return a;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int[] arr = { 5, 1, 5, 2, 5, 3, 5, 4 };

		NRepeatedElementInSize2NArray nRepeatedElementInSize2NArray = new NRepeatedElementInSize2NArray();

		System.out.println(nRepeatedElementInSize2NArray.repeatedNTimes(arr));
	}
}
