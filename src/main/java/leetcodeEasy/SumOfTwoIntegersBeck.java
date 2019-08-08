package leetcodeEasy;

public class SumOfTwoIntegersBeck {

	public static int getSum(int a, int b) {

		if (b == 0) {
			return a;
		
		} else {

			return getSum(a ^ b, (a & b) << 1);
		}
	}

	public static void main(String[] args) {

		System.out.println(SumOfTwoIntegersBeck.getSum(1, 2));

		System.out.println(SumOfTwoIntegersBeck.getSum(-2, 3));
	}
}
