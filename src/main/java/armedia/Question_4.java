package armedia;

public class Question_4 {
	//public static void main(String[] args) {
		
		public static int getMax(int[] list) {
			   
			   int max = list[0];  // This is the largest item seen so far.
			   
			   for (int i = 1; i < list.length; i++) {
			         // Look at each item in the array.  If the item is
			         // bigger than max, then set max equal to the item.
			       if (list[i] > max)
			          max = list[i];
			   }
			   
			   // At this point, max is the largest item in the whole array.
			   
			   return max;
			   
			} // end subroutine getMax	
	//}
}
