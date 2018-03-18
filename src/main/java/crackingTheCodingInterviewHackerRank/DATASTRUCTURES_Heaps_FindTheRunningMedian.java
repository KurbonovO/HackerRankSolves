package crackingTheCodingInterviewHackerRank;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*To find the median, you must first sort your dataset of integers in non-decreasing order then:
If your dataset contains an odd number of elements, the median is the middle element of the sorted sample. 
In the sorted dataset {1,2,3}, 2 is the median.
If your dataset contains an even number of elements, the median is the average of the two middle elements
of the sorted sample. In the sorted dataset {1,2,3,4}, (2+3)/2 = 2.5 is the median.  
*/

public class DATASTRUCTURES_Heaps_FindTheRunningMedian {
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	DATASTRUCTURES_Heaps_FindTheRunningMedian() {
		this.minHeap = new PriorityQueue<Integer>();
		this.maxHeap = new PriorityQueue<Integer>(10, new MedianComparator());
	}

	private void addToList(int sizeOfCurrentList, int value) {
		maxHeap.add(value);

		// If size of list is even:
		if ((sizeOfCurrentList & 1) == 0) {

			if ((minHeap.isEmpty() == false) && (maxHeap.peek() > minHeap.peek())){

				Integer maxHeapRoot = maxHeap.poll();
				Integer minHeapRoot = minHeap.poll();
				minHeap.add(maxHeapRoot);
				maxHeap.add(minHeapRoot);
			}
		}
		// Else the size of the list is odd:
		else {
			minHeap.add(maxHeap.poll());
		}
	}

	private double findMedian(int sizeOfCurrentList) {
		double maxHeapRoot = maxHeap.peek();

		if ((sizeOfCurrentList & 1) == 0) {

			double minHeapRoot = minHeap.peek();
			return ((maxHeapRoot + minHeapRoot) / 2.0);
		} else {
			return maxHeapRoot;
		}
	}

	private static class MedianComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		DATASTRUCTURES_Heaps_FindTheRunningMedian solution = new DATASTRUCTURES_Heaps_FindTheRunningMedian();

		for (int i = 1; i <= n; i++) {
			int value = scanner.nextInt();
			solution.addToList(i - 1, value);
			System.out.println(solution.findMedian(i));
		}
		scanner.close();
	}
}
/*Sample Input:
6
12
4
5
3
8
7
Sample Output:
12.0
8.0
5.0
4.5
5.0
6.0
Explanation:
There are n=6 integers, so we must print the new median on a new line as each integer is added to the list:
list = {12} median = 12.0 
list = {12,4} -> {4,12} median = (12+4)/2 = 8.0
list = {12,4,5} -> {4,5,12} median = 5.0 
list = {12,4,5,3} -> {3,4,5,12} median = (4+5)/2 = 4.5 
list = {12,4,5,3,8} -> {3,4,5,8,12} median = 5.0 
list = {12,4,5,3,8,7} -> {3,4,5,7,8,12} median = (5+7)/2 = 6.0 */ 