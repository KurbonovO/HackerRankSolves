package leetcodeMedium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationsBeck {

	// Was not able to solve but did do debugging. So come back to this.
	public static List<List<Integer>> permuteLeetCode(int[] input) {

		List<List<Integer>> output = new LinkedList<>();

		backTrack(output, new ArrayList<>(), input);

		return output;
	}

	private static void backTrack(List<List<Integer>> output, List<Integer> temporaryList, int[] input) {

		// Once the temporaryList gets filled up from bottom loop we added it to output.
		if (temporaryList.size() == input.length) {

			output.add(new ArrayList<>(temporaryList));

		} else {

			for (int i = 0; i < input.length; i++) {

				if (temporaryList.contains(input[i])) {

					// this will make the loop move forward from the existing number that is in
					continue;
				}
				temporaryList.add(input[i]);
				backTrack(output, temporaryList, input);
				temporaryList.remove(temporaryList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {

		int[] input = { 1, 2, 3 };
		System.out.println(PermutationsBeck.permuteLeetCode(input));
	}

}
