package crackingTheCodingInterviewHackerRank;

import java.util.Scanner;

/*Given the respective heights for each of the s staircases in his house, find and print
the number of ways he can climb each staircase on a new line.*/


public class TECHNIQUESANDCONCEPTS_Recursion_DavisStaircase {
   
	final static long _MOD = 1000000007;
    
    public static long countPathsMemoized(int numberOfSteps) {
    	
        long[] memo = new long[numberOfSteps + 1];
        long numberOfWays = 1;
        for(int i = 1; i < numberOfSteps; i++) {
            numberOfWays += countPathsMemoized (i, memo);
        }
        return numberOfWays % _MOD;
    }
    
    public static long countPathsMemoized(int numberOfSteps, long[] memo) {
        
    	if(numberOfSteps < 3) {
            return (numberOfSteps > 0) ? numberOfSteps : 0;
        }
    	
        if(memo[numberOfSteps] == 0) {
            memo[numberOfSteps] = (
                                  countPathsMemoized(numberOfSteps - 1, memo)
                                + countPathsMemoized(numberOfSteps - 2, memo)
                                + countPathsMemoized(numberOfSteps - 3, memo)
                                ) % _MOD;      
        }
        return memo[numberOfSteps];
    }  
    
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        int numberOfStaircases = scanner.nextInt();
        while(numberOfStaircases-- > 0) {
            int numberOfSteps = scanner.nextInt();
            System.out.println(countPathsMemoized(numberOfSteps));
        }
        scanner.close();
    }
}
/*Sample Input:
3
1
3
7
Sample Output:
1
4
44
Explanation: Let's calculate the number of ways of climbing the first two of the Davis' s=3 staircases:
The first staircase only has n=1 step, so there is only one way for him to climb it (i.e., by jumping 1 step). Thus, we print 1 on a new line.
The second staircase has n=3 steps and he can climb it in any of the four following ways: 
1 -> 1 -> 1
1 -> 2
2 -> 1
3
Thus, we print 4 on a new line*/
