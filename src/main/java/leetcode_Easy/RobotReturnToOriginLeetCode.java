package leetcode_Easy;

public class RobotReturnToOriginLeetCode {
	boolean robotReturnToOrigin(String input) {

		int x = 0;
		int y = 0;

		for (char c : input.toCharArray()) {

			switch (c) {

			case 'U':
				y++;
				break;

			case 'D':
				y--;
				break;

			case 'L':
				x--;
				break;

			case 'R':
				x++;
				break;
			}
		}
		if (x == 0 && y == 0) {
			return true;
		}
		return false;
	}
}
