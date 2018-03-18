package leetcode_Easy;

/*You have a total of n coins that you want to form in a staircase shape, where
every k-th row must have exactly k coins. Given n, find the total number of full
staircase rows that can be formed											  */

public class ArrangingCoins {
	 public int arrangeCoins(int n) {
		 
	        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
	    }
	}

/*n = 5
The coins can form the following rows:
¤
¤ ¤
¤ ¤
Because the 3rd row is incomplete, we return 2.
n = 8
The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤
Because the 4th row is incomplete, we return 3								  */
