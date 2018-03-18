package leetcode_Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*15 Given an array S of n integers, are there elements a, b, c in S such that 
a + b + c = 0? Find all unique triplets in the array which gives the sum of zero
Note: The solution set must not contain duplicate triplets.
given array S = [-1, 0, 1, 2, -1, -4],
A solution set is:
  [-1,  0, 1],
  [-1, -1, 2]								*/

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
	    
		Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    
	    for (int i = 0; i < num.length-2; i++) {
	        
	    	if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	            int low = i+1, high = num.length-1, sum = 0 - num[i];
	            
	            while (low < high) {
	                
	            	if (num[low] + num[high] == sum) {
	                    res.add(Arrays.asList(num[i], num[low], num[high]));
	                   
	                    while (low < high && num[low] == num[low+1]) low++;
	                    
	                    while (low < high && num[high] == num[high-1]) high--;
	                    low++; high--;
	                } 
	            	else if (num[low] + num[high] < sum) {
	                    
	            	  //improve: skip duplicates	
	            		while (low < high && num[low] == num[low+1]) low++;
	                    low++;
	                } 
	            	else {
	                    
	            	  //improve: skip duplicates
	                    while (low < high && num[high] == num[high-1]) high--;
	                    high--;
	                }
	            }
	        }
	    }
	    return res;
	}
}