package leetcode_Easy;

public class CountAndSayLeetCode {
	public String countAndSayLeetCode(int input) {

		StringBuilder current = new StringBuilder("1");
		StringBuilder previous;
		int count;
		char say;

		for (int i = 1; i < input; i++) {

			previous = current;
			current = new StringBuilder();
			count = 1;
			say = previous.charAt(0);

			for (int j = 1, len = previous.length(); j < len; j++) {

				if (previous.charAt(j) != say) {

					current.append(count).append(say);
					count = 1;
					say = previous.charAt(j);
				} else
					count++;
			}
			current.append(count).append(say);
		}
		return current.toString();
	}

	public static void main(String[] args) {

		CountAndSayLeetCode countAndSayLeetCode = new CountAndSayLeetCode();
		System.out.println(countAndSayLeetCode.countAndSayLeetCode(5));
		System.out.println(countAndSayLeetCode.countAndSayLeetCode(11));
		System.out.println(countAndSayLeetCode.countAndSayLeetCode(21));
	}
}
