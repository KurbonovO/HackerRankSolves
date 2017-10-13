package searchChallenges;

import java.util.Scanner;

/*Given the value of m and the cost of each flavor for t trips to the Ice Cream Parlor, help Sunny and Johnny choose
two flavors such that they spend their entire pool of money (m) during each visit. For each trip to the parlor, print
the ID numbers for the two types of ice cream that Sunny and Johnny purchase as two space-separated integers on a new line.
You must print the smaller ID first and the larger ID second.
Note: Two ice creams having unique IDs i and j may have the same cost (i.e., ci = cj)*/

public class IceCreamParlor {

    public static void main(String[] args) {
    	
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();
        
        while(t-- > 0) {
            int m = scan.nextInt();
            int n = scan.nextInt();
            
            int[] menu = new int[n];
            
            for(int i = 0; i < n; i++) {
            	
                menu[i] = scan.nextInt();
            }
            
            for(int i = 0; i < n; i++) {
            	
                for(int j = i + 1; j < n; j++) {
                	
                    if(menu[i] + menu[j] == m) {
                    	
                        System.out.println( (i + 1) + " " + (j + 1) );
                        break;
                    }
                }
            }
        }
        scan.close();
    }
}
/*Sample Input:
2
4
5
1 4 5 3 2
4
4
2 2 4 3
Sample Output:
1 4
1 2
Explanation: Sunny and Johnny make the following two trips to the parlor:
The first time, they pool together m=4 dollars. There are five flavors available that day and flavors 1 and 4 have a total
cost of 1+3=4. Thus, we print 1 4 on a new line.
The second time, they pool together m=4 dollars. There are four flavors available that day and flavors 1 and 2 have a total
cost of 2+2=4. Thus, we print 1 2 on a new line.*/
