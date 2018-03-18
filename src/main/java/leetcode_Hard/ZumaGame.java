package leetcode_Hard;

/*488 Think about Zuma Game. You have a row of balls on the table, colored red(R),
yellow(Y), blue(B), green(G), and white(W). You also have several balls in your hand.
Each time, you may choose a ball in your hand, and insert it into the row 
(including the leftmost place and rightmost place). Then, if there is a group of
3 or more balls in the same color touching, remove these balls. Keep doing this until
no more balls can be removed. Find the minimal balls you have to insert to remove
all the balls on the table. If you cannot remove all the balls, output -1.	*/

public class ZumaGame {

  //the max balls you need will not exceed 6 since "The number of balls in your hand won't exceed 5"
	int MAXCOUNT = 6;   

	public int findMinStep(String board, String hand) {
	    int[] handCount = new int[26];
	    
	    for (int i = 0; i < hand.length(); ++i) ++handCount[hand.charAt(i) - 'A'];
	    
	  //append a "#" to avoid special process while j==board.length, make the code shorter.
	    int rs = helper(board + "#", handCount);  
	    return rs == MAXCOUNT ? -1 : rs;
	}
	
	private int helper(String s, int[] h) {
		s = removeConsecutive(s);
		
		if (s.equals("#"))
			return 0;
		int rs = MAXCOUNT, need = 0;
		
		for (int i = 0, j = 0; j < s.length(); ++j) {
			
			if (s.charAt(j) == s.charAt(i))
				continue;
			
			need = 3 - (j - i); // balls need to remove current consecutive balls.
			
			if (h[s.charAt(i) - 'A'] >= need) {
				h[s.charAt(i) - 'A'] -= need;
				rs = Math.min(rs, need + helper(s.substring(0, i) + s.substring(j), h));
				h[s.charAt(i) - 'A'] += need;
			}
			i = j;
		}
		return rs;
	}
	
	// remove consecutive balls longer than 3
	private String removeConsecutive(String board) {
		
		for (int i = 0, j = 0; j < board.length(); ++j) {
			
			if (board.charAt(j) == board.charAt(i))
				continue;
			
			if (j - i >= 3)
				return removeConsecutive(board.substring(0, i) + board.substring(j));
			else
				i = j;
		}
		return board;
	}
}

/*
Input: "WRRBBW", "RB"											Output: -1
Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW
Input: "WWRRBBWW", "WRBRW"										Output: 2
Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
Input:"G", "GGGGG"												Output: 2
Explanation: G -> G[G] -> GG[G] -> empty 
Input: "RBYYBBRRB", "YRBGB"										Output: 3
Explanation: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] 
-> empty 			*/
