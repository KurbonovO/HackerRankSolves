package leetcode_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*90 Given a collection of integers that might contain duplicates, nums, return
all possible subsets (the power set). The solution set must not contain
duplicate subsets.
Input: [1,2,2]	Output:	[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []	]																	 */

public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> empty = new ArrayList<Integer>();
		result.add(empty);
		Arrays.sort(num);

		for (int i = 0; i < num.length; i++) {
			
			int dupCount = 0;
			
			while (((i + 1) < num.length) && num[i + 1] == num[i]) {
				
				dupCount++;
				i++;
			}
			
			int prevNum = result.size();
			
			for (int j = 0; j < prevNum; j++) {
				
				List<Integer> element = new ArrayList<Integer>(result.get(j));
				
				for (int t = 0; t <= dupCount; t++) {
					
					element.add(num[i]);
					result.add(new ArrayList<Integer>(element));
				}
			}
		}
		return result;
	}
}
