package leetcode_Easy;

import java.util.Scanner;

public class RobotReturnToOriginRun {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();

		int x = 0;
		int y = 0;

		for (char c : input.toCharArray()) {

			if (c == 'L') {

				x--;
			} else if (c == 'R') {

				x++;
			} else if (c == 'U') {

				y++;
			} else if (c == 'D') {

				y--;
			}
		}
		if (x == 0 && y == 0) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

}
