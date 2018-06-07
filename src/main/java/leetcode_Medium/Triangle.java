package leetcode_Medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*120 Given a triangle, find the minimum path sum from top to bottom. Each step
you may move to adjacent numbers on the row below. given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11)	 */

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {

		Deque<Integer> queue = new LinkedList<Integer>();
		int count = triangle.size();
		queue.add(triangle.get(0).get(0));

		for (int i = 1; i < count; i++) {
			List<Integer> list = triangle.get(i);

			for (int j = 0; j <= i; j++) {
				int min = 0;

				if (j == 0)
					min = list.get(0) + queue.peekFirst();
				
				else if (j == i)
					min = list.get(j) + queue.pollFirst();
				
				else
					min = Math.min(queue.pollFirst(), queue.peekFirst()) + list.get(j);
				
				queue.addLast(min);
			}
		}

		int result = Integer.MAX_VALUE;

		for (int i = 0; i < count; i++)
			result = Math.min(result, queue.pollFirst());
		return result;
	}
}
