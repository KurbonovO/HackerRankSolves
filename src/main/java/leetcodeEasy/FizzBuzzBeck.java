package leetcodeEasy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzBeck {

	public static List<String> fizzBuzzBeck(int input) {

		List<String> output = new ArrayList<String>();

		for (int i = 1; i < input; i++) {

			if (i % 3 == 0 && i % 5 == 0) {

				output.add("FizzBuzz");

			} else if (i % 3 == 0) {

				output.add("Fizz");

			} else if (i % 5 == 0) {

				output.add("Buzz");

			} else {

				output.add(String.valueOf(i));
			}
		}
		return output;
	}

	public static void main(String[] args) {

		System.out.println(FizzBuzzBeck.fizzBuzzBeck(20));

	}

}
