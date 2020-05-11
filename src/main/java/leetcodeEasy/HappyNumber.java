package leetcodeEasy;

public class HappyNumber {
	
	// Time Complexity: O(log n)
	// Space Complexity: O(1)

	public boolean happyNumber(int n) {

		int slowRunner = n;
		int fastRunner = getNext(n);
		while (fastRunner != 1 && slowRunner != fastRunner) {

			slowRunner = getNext(slowRunner);
			fastRunner = getNext(getNext(fastRunner));
		}
		return fastRunner == 1;
	}

	public int getNext(int n) {

		int totalSum = 0;
		while (n > 0) {

			int d = n % 10; // grabs second number
			n = n / 10;		// grabs first number
			totalSum += d * d;
		}
		return totalSum;
	}

	public static void main(String[] args) {

		HappyNumber happyNumber = new HappyNumber();
		System.out.println(happyNumber.happyNumber(19));
	}
}
