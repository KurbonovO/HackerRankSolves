package leetcode_Medium;

/*831 
Input: "LeetCode@LeetCode.com"		Output: "l*****e@leetcode.com"
All names are converted to lowercase, and the letters between the first and
last letter of the first name is replaced by 5 asterisks. Therefore, "leetcode"
-> "l*****e".
Input: "AB@qq.com"					Output: "a*****b@qq.com"
There must be 5 asterisks between the first and last letter of the first name
"ab". Therefore, "ab" -> "a*****b".
Input: "1(234)567-890"				Output: "***-***-7890"
Explanation: 10 digits in the phone number, which means all digits make up the
local number.
Input: "86-(10)12345678"			Output: "+**-***-***-5678"
12 digits, 2 digits for country code and 10 digits for local number			 */

public class MaskingPersonalInformation {

	String[] country = { "", "+*-", "+**-", "+***-" };

	public String maskPII(String S) {
		
		int at = S.indexOf("@");
		
		if (at > 0) {
			S = S.toLowerCase();
			return (S.charAt(0) + "*****" + S.substring(at - 1)).toLowerCase();
		}
		S = S.replaceAll("[^0-9]", "");
		return country[S.length() - 10] + "***-***-" + S.substring(S.length() - 4);
	}
}
