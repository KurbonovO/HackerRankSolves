package leetcode_Medium;

/*750 Given a grid where each entry is only 0 or 1, find the number of corner rectangles. A corner rectangle is 4
distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1.
Also, all four 1s used must be distinct.
Input: grid = 
[[1, 0, 0, 1, 0],
 [0, 0, 1, 0, 1],
 [0, 0, 0, 1, 0],
 [1, 0, 1, 0, 1]]
Output: 1 ;There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
Input: grid = 
[[1, 1, 1],
 [1, 1, 1],
 [1, 1, 1]]
Output: 9 ;There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.
Input: grid = 
[[1, 1, 1, 1]]
Output: 0 ;Rectangles must have four distinct corners				*/

public class NumberOfCornerRectangles {
	public int countCornerRectangles(int[][] grid) {
		
		int ans = 0;
		
		for (int i = 0; i < grid.length - 1; i++) {
			
			for (int j = i + 1; j < grid.length; j++) {
				int counter = 0;
				
				for (int k = 0; k < grid[0].length; k++) {
					
					if (grid[i][k] == 1 && grid[j][k] == 1)
						counter++;
				}
				if (counter > 0)
					ans += counter * (counter - 1) / 2;
			}
		}
		return ans;
	}
}

/*To find an axis-aligned rectangle, my idea is to fix two rows (or two columns) first, then check column 
by column to find "1" on both rows. Say you find n pairs, then just pick any 2 of those to form an 
axis-aligned rectangle (calculating how many in total is just high school math, hint: combination)      */