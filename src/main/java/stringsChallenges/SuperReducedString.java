package stringsChallenges;

import java.util.Scanner;

/*Steve wants to reduce s as much as possible. To do this, he will repeat the above operation as many times as
it can be performed. Help Steve out by finding and printing s's non-reducible form!
Note: If the final string is empty, print Empty String .
Input Format: A single string, s*/

public class SuperReducedString {

    public static void main(String[] args) {
    	
        Scanner scan = new Scanner(System.in);
        String string = scan.next();
        scan.close();
        
        while (true) {
            // Used for loop termination
            int len = string.length();
            
            // "(.)" is a capturing group that captures any character
            // "\\1" is a backreference that will match the character captured by the first capturing group (i.e. the one captured by "(.)")
            string = string.replaceAll("(.)\\1", "");
            
            // If no changes were made to string, break loop
            if( string.length() == len ){
                break;
            }
        }
        System.out.println( (string.isEmpty()) ? "Empty String" : string);
    }
}

/*Sample Input:
aaabccddd
Sample Output:
abd
Explanation: Steve can perform the following sequence of operations to get the final string:
aaabccddd -> abccddd
abccddd -> abddd
abddd -> abd
Thus, we print abd.
---------------------------------------------------------------------------------------------
Sample Input:
baab
Sample Output:
Empty String
Explanation: Steve can perform the following sequence of operations to get the final string:
baab -> bb
bb -> Empty String
Thus, we print Empty String.
---------------------------------------------------------------------------------------------
Sample Input:
aa
Sample Output:
Empty String
Explanation: Steve can perform the following sequence of operations to get the final string:
aa -> Empty String
Thus, we print Empty String.*/