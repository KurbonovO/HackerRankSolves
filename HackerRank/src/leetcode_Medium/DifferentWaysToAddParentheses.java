package leetcode_Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*241 Given a string of numbers and operators, return all possible results from computing all
the different possible ways to group numbers and operators. The valid operators are +, - and *.

Input: "2-1-1".
((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]
--------------------
Input: "2*3-4*5"
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]	*/

public class DifferentWaysToAddParentheses {
	
	Map<String, List<Integer>> map = new HashMap<>();

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			
			if (c == '+' || c == '-' || c == '*') {
				String p1 = input.substring(0, i);
				String p2 = input.substring(i + 1);
				
				List<Integer> l1 = map.getOrDefault(p1, diffWaysToCompute(p1));
				List<Integer> l2 = map.getOrDefault(p2, diffWaysToCompute(p2));
				
				for (Integer i1 : l1) {
					
					for (Integer i2 : l2) {
						
						int r = 0;
						
						switch (c) {
						case '+':
							r = i1 + i2;
							break;
						case '-':
							r = i1 - i2;
							break;
						case '*':
							r = i1 * i2;
							break;
						default:
			                System.out.println("Invalid!");
			                break; 	
						}
						res.add(r);
					}
				}
			}
		}
		if (res.size() == 0) {
			res.add(Integer.valueOf(input));
		}
		map.put(input, res);
		return res;
	}
}