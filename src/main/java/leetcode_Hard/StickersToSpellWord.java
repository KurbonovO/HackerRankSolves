package leetcode_Hard;

/*691 We are given N different types of stickers. Each sticker has a lowercase
English word on it. You would like to spell out the given target string by
cutting individual letters from your collection of stickers and rearranging them
You can use each sticker more than once if you want, and you have infinite
quantities of each sticker. What is the minimum number of stickers that you need
to spell out the target? If the task is impossible, return -1				 */

public class StickersToSpellWord {
	public int minStickers(String[] stickers, String target) {
		
		/* if target has n chars, there will be m=2^n-1 subset of characters in
		   target */
		int n = target.length(), m = 1 << n; 
		int[] dp = new int[m];
		for (int i = 0; i < m; i++)
			
			/* use index 0 - 2^n-1 as bitmaps to represent each subset of all chars in
			   target */
			dp[i] = Integer.MAX_VALUE; 
		
		/* first thing we know is : dp[empty set] requires 0 stickers, */
		dp[0] = 0; 
		
		/* for every subset i, start from 000...000 */
		for (int i = 0; i < m; i++) { 
			if (dp[i] == Integer.MAX_VALUE)
				continue;
			
			/* try use each sticker as an char provider to populate 1 of its superset,
			   to do that: */
			for (String s : stickers) { 
				int sup = i;
				
				/* for each char in the sticker, try apply it on a missing char in the
				   subset of target */
				for (char c : s.toCharArray()) {
					for (int r = 0; r < n; r++) {
						if (target.charAt(r) == c && ((sup >> r) & 1) == 0) {
							sup |= 1 << r;
							break;
						}
					}
				}
				/* after you apply all possible chars in a sticker, you get an superset that
				 take 1 extra sticker than subset
				 would take, so you can try to update the superset's minsticker number with
				 dp[sub]+1; */
				dp[sup] = Math.min(dp[sup], dp[i] + 1);
			}
		}
		return dp[m - 1] != Integer.MAX_VALUE ? dp[m - 1] : -1;
	}
}

/*Input: ["with", "example", "science"], "thehat"		Output:3
We can use 2 "with" stickers, and 1 "example" sticker.
After cutting and rearrange the letters of those stickers, we can form the
target "thehat". Also, this is the minimum number of stickers necessary to form
the target string.
Input: ["notice", "possible"], "basicbasic"				Output: -1
We can't form the target "basicbasic" from cutting letters from the given
stickers																	 */
