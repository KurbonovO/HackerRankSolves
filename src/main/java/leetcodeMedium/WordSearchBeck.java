package leetcodeMedium;

public class WordSearchBeck {

	public static boolean existLeetCode(char[][] board, String word) {

		char[] wordToCharArr = word.toCharArray();

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {

				if (helper(board, i, j, wordToCharArr, 0))
					return true;
			}
		}
		return false;
	}

	private static boolean helper(char[][] board, int i, int j, char[] word, int k) {

		if (k == word.length) {

			return true;
		}
		if (i < 0 || j < 0 || i == board.length || j == board[i].length) {

			return false;
		}
		if (board[i][j] != word[k]) {

			return false;

		}
		board[i][j] ^= 256;

		boolean exist = 
				   helper(board, i, j + 1, word, k + 1) 
				|| helper(board, i, j - 1, word, k + 1)
				|| helper(board, i + 1, j, word, k + 1) 
				|| helper(board, i - 1, j, word, k + 1);

		board[i][j] ^= 256;

		return exist;
	}

	public static void main(String[] args) {

		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		System.out.println(WordSearchBeck.existLeetCode(board, "ABCCED"));
	}

}
