package leetcode_Hard;

public class SudokuSolver {

	public void solveSudoku(char[][] board) {
		
		doSolve(board, 0, 0);
	}

	private boolean doSolve(char[][] board, int row, int col) {
		// note: must reset col here!
		for (int i = row; i < 9; i++, col = 0) {

			for (int j = col; j < 9; j++) {

				if (board[i][j] != '.') {

					continue;
				}
				for (char num = '1'; num <= '9'; num++) {

					if (isValid(board, i, j, num)) {

						board[i][j] = num;

						if (doSolve(board, i, j + 1)) {
							return true;
						}
						board[i][j] = '.';
					}
				}
				return false;
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int row, int col, char num) {

		// Block no. is i/3, first element is i/3*3
		int blkrow = (row / 3) * 3;
		int blkcol = (col / 3) * 3;

		for (int i = 0; i < 9; i++) {
			if (board[i][col] == num 
					|| board[row][i] == num 
					|| board[blkrow + i / 3][blkcol + i % 3] == num) {
				return false;
			}
		}
		return true;
	}
}
