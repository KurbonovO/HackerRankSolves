package leetcode_Medium;

import java.util.HashSet;

/*822 On a table are N cards, with a positive integer printed on the front and
back of each card (possibly different). We flip any number of cards, and after
we choose one card. If the number X on the back of the chosen card is not on
the front of any card, then this number X is good. What is the smallest number
that is good?  If no number is good, output 0. Here, fronts[i] and backs[i]
represent the number on the front and back of card i.  A flip swaps the front
and back numbers, so the value on the front is now on the back and vice versa*/

public class CardFlippingGame {
	public int flipgame(int[] intArrayFronts, int[] intArrayBacks) {
		
		HashSet<Integer> same = new HashSet<>();
		
		for (int i = 0; i < intArrayFronts.length; ++i)
			
			if (intArrayFronts[i] == intArrayBacks[i])
				same.add(intArrayFronts[i]);
		
		int res = 3000;
		
		for (int i : intArrayFronts)
			
			if (!same.contains(i))
				res = Math.min(res, i);
		
		for (int i : intArrayBacks)
			
			if (!same.contains(i))
				res = Math.min(res, i);
		
		return res % 3000;
	}
}

/*Input: fronts = [1,2,4,4,7], backs = [1,3,4,1,3]
Output: 2
If we flip the second card, the fronts are [1,3,4,4,7] and the backs are
[1,2,4,1,3]. We choose the second card, which has number 2 on the back, and it
isn't on the front of any card, so 2 is good					 			 */
