package leetcode;

/*242 Given two strings s and t, write a function to determine if t is an anagram of s. For example,
s = "anagram", t = "nagaram", return true.			"remove this message"	"remove this message"	"remove this message"
s = "rat", t = "car", return false*/

public class ValidAnagram {
	
	public boolean isAnagram(String s, String t) {
		
        int[] alphabet = new int[26];
        
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        
        for (int i : alphabet) if (i != 0) return false;
        
        return true;
    }
}