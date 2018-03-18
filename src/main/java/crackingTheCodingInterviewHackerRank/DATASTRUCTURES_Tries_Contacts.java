package crackingTheCodingInterviewHackerRank;

import java.util.Arrays;
import java.util.Scanner;
/*We're going to make our own Contacts application!
add name, where name is a string denoting a contact name. This must store name as a new contact in the application.
find partial, where partial is a string denoting a partial name to search the application for.
It must count the number of contacts starting with partial and print the count on a new line.
Given n sequential add and find operations, perform each operation in order.*/
class Node {
	int count;
	Node[] children;

	Node() {
		this.count = 0;
		this.children = new Node[26];
		Arrays.fill(children, null);
	}

	public void insert(Node current, String value) {

		for (char c : value.toCharArray()) {
			int index = c - 'a';

			if (current.children[index] == null) {
				current.children[index] = new Node();
			}
			current.children[index].count++;
			current = current.children[index];
		}
	}
}

public class DATASTRUCTURES_Tries_Contacts {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Node trie = new Node();
		int n = scan.nextInt();

		while (n-- > 0) {
			String operation = scan.next();
			String value = scan.next();

		 // Insertion Operation
			if (operation.equals("add")) {
				trie.insert(trie, value);
		   // Search Operation  	
			} else {
				Node currentNode = trie;

			 // Traverse through each level
				for (char c : value.toCharArray()) {
					// Maintain a reference to the Node matching the char for that level 
					currentNode = currentNode.children[c - 'a'];
					if (currentNode == null) {
						break;
					}
				}

				// Print the number of results
				System.out.println((currentNode != null) ? currentNode.count : 0);
			}
		}
		scan.close();
	}
}
/*Sample Input:
4
add hack
add hackerrank
find hac
find hak
Sample Output:
2
0
Explanation:
Add a contact named hack.
Add a contact named hackerrank.
Find and print the number of contact names beginning with hac. There are currently two contact names in the application and
both of them start with hac, so we print  on a new line.
Find and print the number of contact names beginning with hak. There are currently two contact names in the application but
neither of them start with hak, so we print  on a new line.*/