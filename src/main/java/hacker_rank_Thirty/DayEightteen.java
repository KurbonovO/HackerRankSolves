package hacker_rank_Thirty;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*Can you determine if a given string, s, is a palindrome? To solve this challenge,
we must first take each character in s, enqueue it in a queue, and also push that
same character onto a stack. Once that's done, we must dequeue the first character
from the queue and pop the top character off the stack, then compare the two characters
to see if they are the same; as long as the characters match, we continue dequeueing,
popping, and comparing each character until our containers are empty (a non-match
means s isn't a palindrome)												      */

public class DayEightteen {

	Queue<Character> queue;
	Stack<Character> stack;

	DayEightteen() {
		this.queue = new LinkedList<Character>();
		this.stack = new Stack<Character>();
	}

	void pushCharacter(char ch) {
		this.stack.push(ch);
	}

	void enqueueCharacter(char ch) {
		this.queue.add(ch);
	}

	char popCharacter() {
		return this.stack.pop();
	}

	char dequeueCharacter() {
		return this.queue.remove();
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		scanner.close();

	  //Convert input String to an array of characters:
		char[] s = input.toCharArray();

	  //Create a Solution object:
		DayEightteen dayEightteen = new DayEightteen();

	  //Enqueue/Push all chars to their respective data structures:
		for (char c : s) {
			dayEightteen.pushCharacter(c);
			dayEightteen.enqueueCharacter(c);
		}

	  //Pop/Dequeue the chars at the head of both data structures and compare them:
		boolean isPalindrome = true;
		
		for (int i = 0; i < s.length / 2; i++) {
			
			if (dayEightteen.popCharacter() != dayEightteen.dequeueCharacter()) {
				isPalindrome = false;
				break;
			}
		}

	  //Finally, print whether string s is palindrome or not.
		System.out.println("The word, " + input + ", is " + ((!isPalindrome) ?
									    "not a palindrome." : "a palindrome."));
	}
}

/*Sample Input: racecar
Sample Output: The word, racecar, is a palindrome						      */
