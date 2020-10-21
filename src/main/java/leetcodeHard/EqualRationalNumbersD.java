package leetcodeHard;

public class EqualRationalNumbersD {

	public boolean isRationalEqual(String S, String T) {
		return f(S) == f(T);
	}

	public double f(String S) {
		int i = S.indexOf('(');
		if (i > 0) {
			String base = S.substring(0, i);
			String rep = S.substring(i + 1, S.length() - 1);
			for (int j = 0; j < 20; ++j)
				base += rep;
			return Double.valueOf(base);
		}
		return Double.valueOf(S);
	}

}
