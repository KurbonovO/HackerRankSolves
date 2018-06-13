package leetcode_Medium;

/*79 Given a 2D board and a word, find if the word exists in the grid. The word
can be constructed from letters of sequentially adjacent cell, where "adjacent"
cells are those horizontally or vertically neighboring. The same letter cell
may not be used more than once.
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
Given word = "ABCCED", return true. Given word = "SEE", return true.
Given word = "ABCB", return false											 */

public class WordSearch {
	public boolean exist(char[][] charDoubleArrayBoard, String stringWord) {

		for (int i = 0; i < charDoubleArrayBoard.length; i++)

			for (int j = 0; j < charDoubleArrayBoard[0].length; j++) {

				if (exist(charDoubleArrayBoard, i, j, stringWord, 0))

					return true;
			}
		return false;
	}

	private boolean exist(char[][] charDoubleArrayBoard, int intI, int intJ, 
			String word, int ind) {

		if (ind == word.length()) {
			return true;
		}

		if (intI > charDoubleArrayBoard.length - 1 
				|| intI < 0 
				|| intJ < 0 
				|| intJ > charDoubleArrayBoard[0].length - 1
				|| charDoubleArrayBoard[intI][intJ] != word.charAt(ind)) {

			return false;
		}

		charDoubleArrayBoard[intI][intJ] = '*';
		boolean booleanResult = exist(charDoubleArrayBoard, intI - 1, intJ, word, ind + 1)
				|| exist(charDoubleArrayBoard, intI, intJ - 1, word, ind + 1)
				|| exist(charDoubleArrayBoard, intI, intJ + 1, word, ind + 1)
				|| exist(charDoubleArrayBoard, intI + 1, intJ, word, ind + 1);

		charDoubleArrayBoard[intI][intJ] = word.charAt(ind);
		return booleanResult;
	}
}
