package leetcodeMedium;

import java.util.Arrays;

public class PutBoxesIntoTheWarehouseIID {

	private int sln1(int[] bx, int[] wh) {
		int p1 = 0;
		int p2 = wh.length - 1;
		Arrays.sort(bx);
		int res = 0;
		for (int i = bx.length - 1; i >= 0 && p1 <= p2; i--) {
			if (bx[i] <= wh[p1]) {
				p1++;
				res++;
			} else if (bx[i] <= wh[p2]) {
				p2--;
				res++;
			}
		}
		return res;
	}

}
