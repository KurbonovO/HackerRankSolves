package implementationChallenges;

import java.util.Scanner;

/*Given the value of d for m apples and n oranges, can you determine how many apples and oranges will fall
on Sam's house (i.e., in the inclusive range [s,t])? Print the number of apples that fall on Sam's house as
your first line of output, then print the number of oranges that fall on Sam's house as your second line of output.
Input Format:
The first line contains two space-separated integers denoting the respective values of s and t. 
The second line contains two space-separated integers denoting the respective values of a and b. 
The third line contains two space-separated integers denoting the respective values of m and n. 
The fourth line contains m space-separated integers denoting the respective distances that each apple falls from point a. 
The fifth line contains n space-separated integers denoting the respective distances that each orange falls from point b*/

public class AppleAndOrange {
	
	public static void main(String[] args) {
		
	  //Read and save input
		Scanner scan = new Scanner(System.in);
		int s = scan.nextInt();
		int t = scan.nextInt();
		int a = scan.nextInt();
		int b = scan.nextInt();
		int m = scan.nextInt();
		int n = scan.nextInt();

	  //Calculate # of apples that fall on house
		int applesOnHouse = 0;
		for (int i = 0; i < m; i++) {
			
			int applePosition = a + scan.nextInt();
			if (applePosition >= s && applePosition <= t) {
				applesOnHouse++;
			}
		}
		System.out.println(applesOnHouse);

		/* Calculate # of oranges that fall on house */
		int orangesOnHouse = 0;
		for (int i = 0; i < n; i++) {
			int orangePosition = b + scan.nextInt();
			if (orangePosition >= s && orangePosition <= t) {
				orangesOnHouse++;
			}
		}
		System.out.println(orangesOnHouse);

		scan.close();
	}
}

/*Sample Input:
7 11
5 15
3 2
-2 2 1
5 -6
Sample Output:
1
1
Explanation:
The first apple falls at position 5-2=3. 
The second apple falls at position 5+2=7. 
The third apple falls at position 5+1=6. 
The first orange falls at position 15+5=20. 
The second orange falls at position 15-6=9. 
Only one fruit (the second apple) falls within the region between 7 and 11, so we print 1 as our first line of output. 
Only the second orange falls within the region between 7 and 11, so we print 1 as our second line of output*/