package leetcode_Easy;

import java.util.Arrays;
import java.util.List;

/*119 Given an index k, return the k^th row of the Pascal's triangle
given k = 3,							            Return [1,3,3,1]         */

public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		
		Integer[] result = new Integer[rowIndex + 1];
		Arrays.fill(result, 0);
		result[0] = 1;
		
		for (int i = 1; i < rowIndex + 1; i++)
			
			for (int j = i; j >= 1; j--)
				
				result[j] += result[j - 1];
		
		return Arrays.asList(result);
	}
}
