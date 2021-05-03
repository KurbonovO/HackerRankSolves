package leetcodeMedium;

public class MaximumXORforEachQueryD {

	public int[] getMaximumXor(int[] n, int maximumBit) {
		int[] res = new int[n.length];
		int val = (1 << maximumBit) - 1;
		for (int i = 0; i < n.length; ++i)
			res[n.length - i - 1] = val ^= n[i];
		return res;
	}

}
