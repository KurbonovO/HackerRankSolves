package leetcodeMedium;

public class SubrectangleQueriesD {

	int[][] mat; // array to store rectangle

	public SubrectangleQueriesD(int[][] rectangle) {
		mat = rectangle;
	}

	public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
		for (int r = row1; r <= row2; r++) {
			for (int c = col1; c <= col2; c++) {
				mat[r][c] = newValue; // update sub-rectangle with newValue
			}
		}
	}

	public int getValue(int row, int col) {
		return mat[row][col];
	}
}
