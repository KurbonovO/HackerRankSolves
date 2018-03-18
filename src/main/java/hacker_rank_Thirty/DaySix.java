package hacker_rank_Thirty;

import java.util.Scanner;

/*Given a string, S, of length N that is indexed from 0 to N-1, print its even-indexed
and odd-indexed characters as 2 space-separated strings on a single line.
Sample Input:
2
Hacker
Rank
Sample Output:
Hce akr
Rn ak																		  */

public class DaySix {
	public static void main(String[] args) {

	  //Enter your code here. Read input from STDIN. Print output to STDOUT
		Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        
        for(int i = 0; i < testCases; i++){
            char[] inputString = scan.next().toCharArray();
			
          //Print even chars
            for(int j = 0; j < inputString.length; j += 2){
                System.out.print(inputString[j]);
            }
            System.out.print(" ");
            
          //Print odd chars
            for(int j = 1; j < inputString.length; j += 2){
                System.out.print(inputString[j]);
            }
            System.out.println();
        }
        scan.close();
    }
}

/*Test Case 0: S = "Hacker"  
S[0] = "H"  
S[1] = "a"
S[2] = "c"
S[3] = "k"
S[4] = "e"
S[5] = "r"
The even indices are 0, 2, and 4, and the odd indices are 1, 3, and 5. We then
print a single line of 2 space-separated strings; the first string contains the
ordered characters from S's even indices (Hce), and the second string contains the
ordered characters from S's odd indices (akr).
Test Case 1: S = "Rank"  
S[0] = "R"  
S[1] = "a"
S[2] = "n"
S[3] = "k" 
The even indices are 0 and 2, and the odd indices are 1 and 3. We then print a
single line of 2 space-separated strings; the first string contains the ordered
characters from S's even indices (Rn), and the second string contains the ordered
characters from S's odd indices (ak)										  */