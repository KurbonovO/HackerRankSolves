package leetcodeMedium;

import java.util.LinkedList;

public class AsteroidCollisionLeetCode {

	public int[] asteroidCollision(int[] a) {

		LinkedList<Integer> outpulLinkedList = new LinkedList<>();

		for (int i = 0; i < a.length; i++) {

			if (a[i] > 0 || outpulLinkedList.isEmpty() || outpulLinkedList.getLast() < 0) {
				
				outpulLinkedList.add(a[i]);
			
			} else if (outpulLinkedList.getLast() <= -a[i]) {
				
				if (outpulLinkedList.pollLast() < -a[i]) {
					
					i--;
				}
			}
		}
		return outpulLinkedList.stream().mapToInt(i -> i).toArray();
	}
}
