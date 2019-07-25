package leetcodeEasy;

import java.util.HashSet;
import java.util.stream.IntStream;

public class FairCandySwapLeetCode {

	public int[] fairCandySwapLeetCode(int[] A, int[] B) {

		int dif = (IntStream.of(A).sum() - IntStream.of(B).sum()) / 2;

		HashSet<Integer> mapString = new HashSet<>();

		for (int a : A) {
			
			mapString.add(a);
		}
		for (int b : B) {
			
			if (mapString.contains(b + dif)) {
				
				return new int[] { b + dif, b };
			}
		}
		return new int[0];
	}
}
