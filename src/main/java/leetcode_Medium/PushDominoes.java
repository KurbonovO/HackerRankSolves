package leetcode_Medium;

/*838 There are N dominoes in a line, and we place each domino vertically
upright. In the beginning, we simultaneously push some of the dominoes either
to the left or to the right. After each second, each domino that is falling to
the left pushes the adjacent domino on the left. Similarly, the dominoes
falling to the right push their adjacent dominoes standing on the right. When a
vertical domino has dominoes falling on it from both sides, it stays still due
to the balance of the forces. For the purposes of this question, we will
consider that a falling domino expends no additional force to a falling or
already fallen domino. Given a string "S" representing the initial state.
S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the
i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has
not been pushed. Return a string representing the final state				 */

public class PushDominoes {
	public String pushDominoes(String d) {

		d = 'L' + d + 'R';
		StringBuilder resultStringBuilder = new StringBuilder();

		for (int i = 0, j = 1; j < d.length(); ++j) {

			if (d.charAt(j) == '.') {
				continue;
			}
			int middle = j - i - 1;

			if (i > 0) {
				resultStringBuilder.append(d.charAt(i));
			}	

			if (d.charAt(i) == d.charAt(j)) {

				for (int k = 0; k < middle; k++)
					resultStringBuilder.append(d.charAt(i));
			}

			else if (d.charAt(i) == 'L' && d.charAt(j) == 'R')

				for (int k = 0; k < middle; k++) {
					resultStringBuilder.append('.');
				}
			else {

				for (int k = 0; k < middle / 2; k++) {
					resultStringBuilder.append('R');
				}

				if (middle % 2 == 1) {
					resultStringBuilder.append('.');
				}

				for (int k = 0; k < middle / 2; k++) {
					resultStringBuilder.append('L');
				}
			}
			i = j;
		}
		return resultStringBuilder.toString();
	}
}

/*Input: ".L.R...LR..L.." 		Output: "LL.RR.LLRRLL.."
Input: "RR.L"					Output: "RR.L"
The first domino expends no additional force on the second domino			 */

