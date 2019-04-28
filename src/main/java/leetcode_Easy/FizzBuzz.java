package leetcode_Easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
		
		List<String> outcomeList = new ArrayList<String>(n);
		
		for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
			
			fizz++;
			buzz++;
			
			if (fizz == 3 && buzz == 5) {
				outcomeList.add("FizzBuzz");
				fizz = 0;
				buzz = 0;
			} else if (fizz == 3) {
				outcomeList.add("Fizz");
				fizz = 0;
			} else if (buzz == 5) {
				outcomeList.add("Buzz");
				buzz = 0;
			} else {
				outcomeList.add(String.valueOf(i));
			}
		}
		return outcomeList;
	}
}
