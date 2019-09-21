package leetcodeEasy;

import java.util.stream.IntStream;

public class MinimumMovesToEqualArrayElementsLeetCode {

	public int minMoves(int[] nums) {
		return IntStream.of(nums).sum() - nums.length * IntStream.of(nums).min().getAsInt();
	}
}
