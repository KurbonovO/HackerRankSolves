package leetcode_Easy;

public class RobotReturnToOriginBeck {
	public boolean robotReturnToOrigin(String input) {

		int x = 0;
		int y = 0;

		if (input != null && !input.isEmpty()) {

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
		}
		if (x == 0 && y == 0) {
			return true;
		}
		return false;
	}
}
