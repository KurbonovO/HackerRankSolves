package leetcode_Medium;

import java.util.Set;

/*139 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented
into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
given:
s = "leetcode",
dict = ["leet", "code"].
Return true because "leetcode" can be segmented as "leet code"*/

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {

		boolean[] f = new boolean[s.length() + 1];

		f[0] = true;

	  /*First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/

		// Second DP
		for (int i = 1; i <= s.length(); i++) {
			
			for (int j = 0; j < i; j++) {
				
				if (f[j] && dict.contains(s.substring(j, i))) {
					f[i] = true;
					
					break;
				}
			}
		}
		return f[s.length()];
	}
}