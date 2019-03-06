package leetcode_Easy;

import java.util.Arrays;

public class AssignCookiesBeck {
	public int assignCookiesBeck(int[] children, int[] cookies) {

		// goes from least to most
		Arrays.sort(children);
		Arrays.sort(cookies);

		int child = 0;
		
        for (int cookie = 0; child < children.length && cookie < cookies.length; cookie++) {
            
        	if (cookies[cookie] >= children[child]) {
               
        		child ++;
            }
        }
        return child;
	}
}
