package leetcode_Medium;

/*621 Given a char array representing tasks CPU need to do. It contains capital
letters A to Z where different letters represent different tasks.Tasks could be
done without original order. Each task could be done in one interval. For each
interval, CPU could finish one task or just be idle. However, there is a
non-negative cooling interval n that means between two same tasks, there must
be at least n intervals that CPU are doing different tasks or just be idle.
You need to return the least number of intervals the CPU will take to finish all
the given tasks.
Input: tasks = ["A","A","A","B","B","B"], n = 2				Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B						 */

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		
		int length = tasks.length;
		int[] count = new int[26];
		int max = 0; 
		int maxNum = 0;
		
		for (char character : tasks) {
			count[character - 'A']++;
			
			if (count[character - 'A'] > max) {
				max = count[character - 'A'];
				maxNum = 1;
			} 
			else if (count[character - 'A'] == max) {
				maxNum++;
			}
		}
		return Math.max(length, (max - 1) * (n + 1) + maxNum);
	}
}
