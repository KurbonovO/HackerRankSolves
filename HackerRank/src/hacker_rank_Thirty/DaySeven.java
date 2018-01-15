package hacker_rank_Thirty;

import java.util.Scanner;

/*Given an array, A, of N integers, print A's elements in reverse order as a single
line of space-separated numbers.
Sample Input:
4 																			   O
1 4 3 2
Sample Output:
2 3 4 1 																	  */

public class DaySeven {
	public static void main(String[] args) {

	  //Get the input
		Scanner scanner = new Scanner(System.in);

	  //input how size of our array will be in this case 4 	            
		int length = scanner.nextInt();

		int[] array = new int[length];

		for (int i = 0; i < length; i++) {
			array[i] = scanner.nextInt();
		}

		scanner.close();

	  //Var holding our new string
		String result = "";

		for (int i = array.length - 1; i >= 0; i--) {

			result = result + array[i] + " ";
		}
		System.out.println(result);
	}
}