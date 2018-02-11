package leetcode_Medium;

import java.util.ArrayList;
import java.util.List;

/*722 Given a C++ program, remove comments from it. The program source is an array where source[i] is the
i-th line of the source code. This represents the result of splitting the original source code string by
the newline character \n. In C++, there are two types of comments, line comments, and block comments. // and /*
After removing the comments from the source code, return the source code in the same format*/

public class RemoveComments {
	
	public List<String> removeComments(String[] source) {
		
        boolean inBlock = false;
        StringBuilder newline = new StringBuilder();
        List<String> answear = new ArrayList<>();
        
        for (String line: source) {
            int i = 0;
            char[] chars = line.toCharArray();
            
            if (!inBlock) newline = new StringBuilder();
            
            while (i < line.length()) {
                
            	if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    inBlock = true;
                    i++;
                } 
            	else if (inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    inBlock = false;
                    i++;
                }
            	else if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                    break;
                }
            	else if (!inBlock) {
                    newline.append(chars[i]);
                }
            	
                i++;
                
            }
            if (!inBlock && newline.length() > 0) {
                answear.add(new String(newline));
            }
        }
        return answear;
    }
}

//Input: source = ["a/*comment", "line", "more_comment*/b"]
//Output: ["ab"]
//Explanation: The original source string is "a/*comment\nline\nmore_comment*/b", where we have bolded the newline
//characters.  After deletion, the implicit newline characters are deleted, leaving the string "ab", which when
//delimited by newline characters becomes ["ab"].