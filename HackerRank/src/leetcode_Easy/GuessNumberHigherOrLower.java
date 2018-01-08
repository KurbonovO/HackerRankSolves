package leetcode_Easy;

/*374 We are playing the Guess Game I pick a number from 1 to n. You have to guess
which number I picked. Every time you guess wrong, I'll tell you whether the number
is higher or lower. You call a pre-defined API guess(int num) which returns 3
possible results (-1, 1, or 0):
-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
n = 10, I pick 6.			                                   Return 6       */

/* The guess API is defined in the parent class GuessGame.
@param num, your guess
@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   int guess(int num); */

//public class GuessNumberHigherOrLower extends GuessGame {
//	
//	public int guessNumber(int n) {
//		return bsearch(1, n);
//	}
//	
//	private int bsearch(int start, int end) {
//		
//		if (start > end)
//			return -1;// R u kidding me?
//		
//		if (guess(start) == 0)
//			return start;
//		
//		if (guess(end) == 0)
//			return end;
//		
//		int mid = start + (end - start) / 2;
//		
//		if (guess(mid) == 0)
//			return mid;
//		
//		else if (guess(mid) == -1)
//			return bsearch(start + 1, mid - 1);
//		
//		else
//			return bsearch(mid + 1, end - 1);
//	}
//}