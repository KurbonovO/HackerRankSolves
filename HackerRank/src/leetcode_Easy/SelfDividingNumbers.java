package leetcode_Easy;

import java.util.ArrayList;
import java.util.List;

/*728 A self-dividing number is a number that is divisible by every digit it contains. For example: 
128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
Also, a self-dividing number is not allowed to contain the digit zero.
Given a lower and upper number bound, output a list of every possible self dividing number, including the
bounds if possible.
Input: left = 1, right = 22 		Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]*/

public class SelfDividingNumbers {

	public List<Integer> selfDividingNumbers(int left, int right) {
		
		List <Integer> list = new ArrayList <> ();
		
		for (int i = left; i <= right; i++) {
			int j = i;
			
			for (; j > 0; j /= 10) {
				
				if ((j % 10 == 0) || (i % (j % 10) != 0))
					break;
			}
			if (j == 0)
				list.add(i);
		}
		return list;
	}
}

/*The idea is to traverse each integer sequence from left to right incrementing by one
(left, left + 1, left + 2,..., left + n, right). Each time check if the the current number i is self-divided.
Self-division check is done by using '%' operator(we check each digit of i moving from right to left)
E.g. if i = 128 number: 128 % 10 = 8, check 8 != 0 and 128 /8 != 0; remove 8 from next step j = 128 / 10 = 12
repeat 1 and 2 until j == 0*/