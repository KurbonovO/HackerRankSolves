package leetcode_Medium;

/*81 Suppose an array sorted in ascending order is rotated at some pivot unknown
to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Write a
function to determine if a given target is in the array. The array may contain
duplicates																      */

public class SearchInRotatedSortedArrayII {

	public boolean search(int[] nums, int target) {
	    
		int start = 0, end = nums.length - 1;
	    
	    /*check each num so we will check start == end We always get a sorted part
	      and a half part we can check sorted part to decide where to go next */
	    while(start <= end){
	       
	    	int middle = start + (end - start)/2;
	        
	        if(nums[middle] == target) return true;
	        
	        /* if left part is sorted */
	        if(nums[start] < nums[middle]){
	            
	        	if(target < nums[start] || target > nums[middle]){
	               
	        		//target is in rotated part
	                start = middle + 1;
	            }
	        	else{
	                end = middle - 1;
	            }
	        	//right part is rotated
	        }else if(nums[start] > nums[middle]){
	            
	            //target is in rotated part
	            if(target < nums[middle] || target > nums[end]){
	                end = middle -1;
	            }else{
	                start = middle + 1;
	            }
	        }else{
	            /*duplicates, we know nums[mid] != target, so nums[start] != target
	              based on current information, we can only move left pointer to
	              skip one cell thus in the worest case, we would have target: 2,
	              and array like 11111111, then the running time would be O(n)*/
	            start ++;
	        }
	    }
	    return false;
	}
}
