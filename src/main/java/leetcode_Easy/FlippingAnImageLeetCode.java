package leetcode_Easy;

public class FlippingAnImageLeetCode {
	public int[][] flippingAnImage(int[][]image) {
		
		for(int[] row : image) {
			
			for(int i = 0; i < row.length; i++) {
				
				if(row[i] == row[i + 1]) {
					
					continue;
				} else {
					row[i] = row[i + 1];
				}
				
			}
		}
		
		
		
		return image;
	}

}
