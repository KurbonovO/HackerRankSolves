package leetcode_Medium;

/*456 Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that 
i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether
there is a 132 pattern in the list. Note: n will be less than 15,000.
Input: [1, 2, 3, 4]		Output: False
There is no 132 pattern in the sequence.
Input: [3, 1, 4, 2]		Output: True
There is a 132 pattern in the sequence: [1, 4, 2].
Input: [-1, 3, 2, 0]		Output: True
There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0]	*/

public class OneThreeTwoPattern {
	public boolean find132pattern(int[] nums) {
		
		for (int n = nums.length, i = n - 1, top = n, third = Integer.MIN_VALUE; i >= 0; i--) {
			
			if (nums[i] < third)
				return true;
			
			while (top < n && nums[i] > nums[top])
				third = nums[top++];
			nums[--top] = nums[i];
		}
		return false;
	}
}

/*The idea is to do backward traversal of the input array and keep track of the maximum value (denoted as 
third) of all possible third numbers obtained so far (an element can be a candidate for the third number
if and only if there is another element coming before and greater than it). This is because for two
candidate third numbers a and b, if a <= b and there is no 132 pattern for b, then there must be no 132
pattern for a either. The idea is elaborated as follows. For the current element being examined, we first
check if it can be the first number by comparing it with third. If this is the case, a 132 pattern has been
found. Otherwise, it will be treated as the second number to qualify scanned elements so far as candidate third
numbers (note we are doing backward scan so the current element will always come before scanned elements). Of
course we cannot do this for all scanned elements, as it will lead to an O(n^2) solution. Fortunately it suffices
only to process scanned elements that are greater than third. This is because after an element is qualified to be
the third number, it will only be used to update third. For those elements smaller than third, even if they are
qualified to be the third number, they won't make third any larger and therefore can be ignored. So we need to
maintain a collection (stack, to be exact) for scanned elements that are greater than third. After the current
element is done, it will be added to this collection for future processing. It can be shown by mathematical
induction that elements in the collection will be sorted automatically, similar to that in part III. At the
beginning the collection is empty so the base case is true. Assume the collection is sorted immediately before
processing the current element, which is presumed to be >= third (otherwise a 132 pattern is found). We will
scan the collection and pop all elements smaller than the current element to find all qualified third numbers
and update third accordingly. At the end, all remaining elements in the collection are no less than the current
element, therefore adding it to the collection won't break the sorted property. So our induction assumption is
also true.Here is the one-pass O(n) solution. We can also optimize the space cost to O(1) if the input array can
act as the collection by taking advantage of the fact that size of the collection will never exceed the number
of elements scanned so far.*/