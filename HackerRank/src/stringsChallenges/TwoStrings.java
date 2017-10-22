package stringsChallenges;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*Given two strings, a and b, determine if they share a common substring.
There are two concepts involved in solving this challenge: Understanding that a single character is a valid substring.
Deducing that we only need to know that the two strings have a common substring — we don't need to know what that substring is*/

public class TwoStrings {
    
	static Set<Character> a;
    static Set<Character> b;

    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for(int i = 0; i < n; i++) {
            a = new HashSet<Character>();
            b = new HashSet<Character>();
            
            for(char c : scan.next().toCharArray()) {
                a.add(c);
            }
            
            for(char c : scan.next().toCharArray()) {
                b.add(c);
            }
            
          //store the set intersection in set 'a'
            a.retainAll(b);
            
            System.out.println( (a.isEmpty()) ? "NO" : "YES" );
        }
        scan.close();
    }
}

/*Sample Input:
2
hello
world
hi
world
Sample Output:
YES
NO
Explanation: We have c=2 pairs to check:
1) a="hello", b="world". The substrings "o" and "1" are common to both a and b, so we print YES on a new line.
2) a="hi", b="world". Because a and b have no common substrings, we print NO on a new line.*/