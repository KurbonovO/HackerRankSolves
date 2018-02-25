package leetcode_Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of integers that might contain duplicates, nums, return all
possible subsets (the power set). The solution set must not contain duplicate
subsets.
If nums = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]																			  */

public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] intArrayNum) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> empty = new ArrayList<Integer>();
		
		result.add(empty);
		Arrays.sort(intArrayNum);

		for (int i = 0; i < intArrayNum.length; i++) {
			int duplicateCount = 0;
			
			while (((i + 1) < intArrayNum.length) && intArrayNum[i + 1] == intArrayNum[i]) {
				duplicateCount++;
				i++;
			}
			
			int previousNumber = result.size();
			
			for (int j = 0; j < previousNumber; j++) {
				List<Integer> element = new ArrayList<Integer>(result.get(j));
				
				for (int t = 0; t <= duplicateCount; t++) {
					element.add(intArrayNum[i]);
					result.add(new ArrayList<Integer>(element));
				}
			}
		}
		return result;
	}
}