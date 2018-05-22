package leetcode_Medium;

import java.util.ArrayList;
import java.util.List;

/*216 Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be
a unique set of numbers.
Input: k = 3, n = 7		Output: [[1,2,4]]
Input: k = 3, n = 9		Output: [[1,2,6], [1,3,5], [2,3,4]]					 */

public class CombinationSumIII {

	public List<List<Integer>> combinationSum3(int intK, int intN) {
		List<List<Integer>> listListIntegerAnswear = new ArrayList<>();
		combination(listListIntegerAnswear, new ArrayList<Integer>(), intK, 1, intN);
		return listListIntegerAnswear;
	}

	private static void combination(List<List<Integer>> listListIntAnswear, 
			List<Integer> listIntCombination, int intK, int intStart, int intN) {

		if (listIntCombination.size() > intK) {
			return;
		}

		if (listIntCombination.size() == intK && intN == 0) {
			List<Integer> listInt = new ArrayList<Integer>(listIntCombination);
			listListIntAnswear.add(listInt);
			return;
		}

		for (int i = intStart; i <= 9; i++) {

			if (intN - i >= 0) {
				listIntCombination.add(i);
				combination(listListIntAnswear, listIntCombination, intK, i + 1, intN - i);
				listIntCombination.remove(listIntCombination.size() - 1);
			}
		}
	}
}
