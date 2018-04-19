package leetcode_Hard;

import java.util.ArrayList;
import java.util.List;

/*282 Given a string that contains only digits 0-9 and a target value, return
all possibilities to add binary operators (not unary) +, -, or * between the
digits so they evaluate to the target value.
"123", 6 				-> ["1+2+3", "1*2*3"] 
"232", 8 				-> ["2*3+2", "2+3*2"]
"105", 5 				-> ["1*0+5","10-5"]
"00", 0 				-> ["0+0", "0-0", "0*0"]
"3456237490", 9191 		-> []									             */

public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {

		List<String> listString = new ArrayList<>();
		StringBuilder stringBuilder = new StringBuilder();
		dfs(listString, stringBuilder, num, 0, target, 0, 0);

		return listString;
	}

	public void dfs(List<String> listString, StringBuilder stringBuilder, String num,
			int pos, int target, long prev,
			long multi) {

		if (pos == num.length()) {

			if (target == prev)
				listString.add(stringBuilder.toString());
			return;
		}

		for (int i = pos; i < num.length(); i++) {

			if (num.charAt(pos) == '0' && i != pos)
				break;

			long curr = Long.parseLong(num.substring(pos, i + 1));

			int len = stringBuilder.length();

			if (pos == 0) {
				dfs(listString, stringBuilder.append(curr), num, i + 1, target, curr, curr);
				stringBuilder.setLength(len);
			} else {
				dfs(listString, stringBuilder.append("+").append(curr), num, i + 1,
						target, prev + curr, curr);
				stringBuilder.setLength(len);
				dfs(listString, stringBuilder.append("-").append(curr), num, i + 1,
						target, prev - curr, -curr);
				stringBuilder.setLength(len);
				dfs(listString, stringBuilder.append("*").append(curr), num, i + 1,
						target, prev - multi + multi * curr,
						multi * curr);
				stringBuilder.setLength(len);
			}
		}
	}
}
