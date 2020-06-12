package leetcodeEasy;

public class ConvertIntegerToTheSumOfTwoNoZeroIntegersd {

	public int[] getNoZeroIntegers(int n) {

		int a = 0, b = 0, step = 1;

		while (n > 0) {
			int d = n % 10; // digit
			n /= 10;

			if ((d == 0 || d == 1) && n > 0) { // n>0 evades the case when 1 is the most significant digit
				a += step * (1 + d);
				b += step * 9;
				n--; // handle carry
			} else {
				a += step * 1;
				b += step * (d - 1);
			}
			step *= 10;
		}

		return new int[] { a, b };
	}

}
