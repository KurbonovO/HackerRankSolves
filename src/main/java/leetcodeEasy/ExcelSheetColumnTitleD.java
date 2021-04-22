package leetcodeEasy;

public class ExcelSheetColumnTitleD {

	public String convertToTitle(int columnNumber) {

		return columnNumber == 0 ? "" : convertToTitle(--columnNumber / 26) + (char) ('A' + (columnNumber % 26));

	}

}
