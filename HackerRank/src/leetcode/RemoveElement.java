package leetcode;

/*27 Given an array and a value, remove all instances of that value in-place and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
Given nums = [3,2,2,3], val = 3, Your function should return length = 2, with the first two elements of nums being 2*/

public class RemoveElement {

	int removeElement(int A[], int n, int elem) {
		int i = 0;
		
		while (i < n) {
			if (A[i] == elem) {
				A[i] = A[n - 1];
				n--;
			} else
				i++;
		}
		return n;
	}
}

/*It scans numbers from the left to the right, one by one.
Once it finds a number that equals to elem, it swaps current element with the last element in the array and then dispose the last.
The swapping can be optimized as overwrite current element by the last one and dispose the last.
Now, we have removed the current number, and the length of the array is reduced by 1.
To ensure we do not make wrong choices, we will continue scanning from the (new) current element.
So it won't fail if the same number is swapped to the current position.*/