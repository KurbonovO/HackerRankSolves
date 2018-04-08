package leetcode_Medium;

/*678 Given a string containing only three types of characters: '(', ')' and
'*', write a function to check whether this string is valid. We define the
validity of a string by these rules:
Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left 
parenthesis '(' or an empty string. An empty string is also valid.
Input: "()"		Output: True
Input: "(*)"	Output: True
Input: "(*))"	Output: True											     */

public class ValidParenthesisString {
	public boolean checkValidString(String s) {
		
		int n = s.length();
		
		if (n == 0) {
			return true;
		}
			
		boolean[][] dp = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			
			if (s.charAt(i) == '*')
				dp[i][i] = true;
			
			if (i < n - 1 && (s.charAt(i) == '(' || s.charAt(i) == '*')
					&& (s.charAt(i + 1) == ')' || s.charAt(i + 1) == '*')) {
				dp[i][i + 1] = true;
			}
		}

		for (int size = 2; size < n; size++) {
			
			for (int i = 0; i + size < n; i++) {
				
				if (s.charAt(i) == '*' && dp[i + 1][i + size] == true) {
					dp[i][i + size] = true;
				} 
				else if (s.charAt(i) == '(' || s.charAt(i) == '*') {
					
					for (int k = i + 1; k <= i + size; k++) {
						
						if ((s.charAt(k) == ')' || s.charAt(k) == '*') 
								&& (k == i + 1 || dp[i + 1][k - 1])
								&& (k == i + size || dp[k + 1][i + size])) {
							dp[i][i + size] = true;
						}
					}
				}
			}
		}
		return dp[0][n - 1];
	}
}
