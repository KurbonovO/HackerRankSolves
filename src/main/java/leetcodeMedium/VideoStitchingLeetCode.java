package leetcodeMedium;

import java.util.Arrays;

public class VideoStitchingLeetCode {

	public int videoStitching(int[][] clips, int T) {
		int res = 0;
		Arrays.sort(clips, (a, b) -> a[0] - b[0]);
		for (int i = 0, st = 0, end = 0; st < T; st = end, ++res) {
			for (; i < clips.length && clips[i][0] <= st; ++i)
				end = Math.max(end, clips[i][1]);
			if (st == end)
				return -1;
		}
		return res;
	}

}
