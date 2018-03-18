package crackingTheCodingInterviewHackerRank;

import java.util.Scanner;
import java.util.Stack;

/*
A bracket is considered to be any one of the following characters: (, ), {, }, [, or ]
Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket
(i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().
A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])}
Given n strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, print YES on a new line; 
otherwise, print NO on a new line.
*/

public class DATASTRUCTURES_Stacks_BalancedBrackets {
	
	public static boolean isBalanced(String s) {
		// Stack of opening brackets:
		Stack<Character> stack = new Stack<Character>();
		// Flag denoting whether or not the string is balanced:
		boolean balanced = true;

		// Iterate through each char 'ch' in the string and check if brackets are balanced:
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			// If 'ch' is an opening bracket:
			if ('(' == ch || '[' == ch || '{' == ch) {
				stack.push(ch);
			}
			// Else, 'ch' is a closing bracket:
			else {
				// If there's no opening brace to balance, then the string cannot be balanced.
				if (stack.empty()) {
					balanced = false;
					break;
				}
				// Check if 'ch' closes the opening bracket at the top of the stack.			
				else {
					char top = stack.pop();

					// If the char popped off the 'top' of the stack doesn't match ch:					
					if ((top == '(' && ch != ')') || (top == '[' && ch != ']')
							|| (top == '{' && ch != '}')) {
						balanced = false;
						break;
					}
				}
			}
		}
		return (balanced && stack.empty()) ? true : false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		for (int i = 0; i < n; i++) {
			String s = scanner.next();
			System.out.println((isBalanced(s)) ? "YES" : "NO");
		}
		scanner.close();
	}
}
/*
 * Sample Input: 
 * 3 
 * {[()]} 
 * {[(])} 
 * {{[[(())]]}}
 * Sample Output: YES NO YES
 */
