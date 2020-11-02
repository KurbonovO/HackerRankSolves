package leetcodeEasy;

public class NRepeatedElementInSize2NArrayD {

	public int repeatedNTimes(int[] A) {
		int[] count = new int[10000];
		for (int a : A)
			if (count[a]++ == 1)
				return a;
		return -1;
	}

}
