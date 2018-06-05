package leetcode_Medium;

import java.util.List;
import java.util.Stack;

/*636 Given the running logs of n functions that are executed in a nonpreemptive
single threaded CPU, find the exclusive time of these functions. Each function
has a unique id, start from 0 to n-1. A function may be called recursively or by
another function. A log is a string has this 
format: function_id:start_or_end:timestamp. For example, "0:start:0" means
function 0 starts from the very beginning of time 0. "0:end:0" means function 0
ends to the very end of time 0. Exclusive time of a function is defined as the
time spent within this function, the time spent by calling other functions should
not be considered as this function's exclusive time. You should return the
exclusive time of each function sorted by their function id					 */

public class ExclusiveTimeOfFunctions {
	public int[] exclusiveTime(int intN, List<String> listStringLogs) {

		/* separate time to several intervals, add interval to their function */
		int[] result = new int[intN];
		Stack<Integer> stackInteger = new Stack<>();
		
		/* pre means the start of the interval */
		int pre = 0;
		
		for (String log : listStringLogs) {
			String[] arr = log.split(":");
			
			if (arr[1].equals("start")) {
				
				if (!stackInteger.isEmpty())
					
					/* arr[2] is the start of next interval, doesn't belong to current interval. */
					result[stackInteger.peek()] += Integer.parseInt(arr[2]) - pre;
				
				stackInteger.push(Integer.parseInt(arr[0]));
				pre = Integer.parseInt(arr[2]);
			
			} else {
				/* arr[2] is end of current interval, belong to current interval. That's why we
				   have +1 here */
				result[stackInteger.pop()] += Integer.parseInt(arr[2]) - pre + 1;
				
				/* pre means the start of next interval, so we need to +1 */
				pre = Integer.parseInt(arr[2]) + 1;
			}
		}
		return result;
	}
}

/*Input:
n = 2
logs = 
["0:start:0",
 "1:start:2",
 "1:end:5",
 "0:end:6"]		Output:[3, 4]
Function 0 starts at time 0, then it executes 2 units of time and reaches the
end of time 1. Now function 0 calls function 1, function 1 starts at time 2,
executes 4 units of time and end at time 5. Function 0 is running again at time
6, and also end at the time 6, thus executes 1 unit of time. So function 0
totally execute 2 + 1 = 3 units of time, and function 1 totally execute 4 units
of time																		 */
