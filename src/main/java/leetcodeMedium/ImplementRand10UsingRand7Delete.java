package leetcodeMedium;

public class ImplementRand10UsingRand7Delete {

	public double rand10() {
		double result = 40;
		while (result >= 40) {
			result = 7 * (Math.random() - 1) + (Math.random() - 1);
		}
		return result % 10 + 1;
	}
}
