package crackingTheCodingInterviewHackerRank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*Comparators are used to compare two objects. In this challenge, you'll create a comparator and use it to sort an array:
A string name, and An integer score
Given an array of n Player objects, write a comparator that sorts them in order of decreasing score; 
if 2 or more players have the same score, sort those players alphabetically by name.
To do this, you must create a Checker class that implements the Comparator interface,
then write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) method.*/

class Checker implements Comparator<Player> {

	public int compare(Player a, Player b) {
		// If 2 Players have the same score
		if (a.score == b.score) {
			// Order alphabetically by name
			if (a.name.compareTo (b.name) < 0) {
				return -1;
			} else if (a.name.compareTo (b.name) > 0) {
				return 1;
			}
			return 0;
		}

		// Otherwise, order higher score first
		else if (a.score > b.score) {
			return -1;
		} else if (a.score < b.score) {
			return 1;
		}
		return 0;
	}
}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

public class ALGORITHMS_Sorting_Comparator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for (int i = 0; i < n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		
		scan.close();

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}
}
/*Sample Input:
5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150
Sample Output:
aleksa 150
amy 100
david 100
aakansha 75
heraldo 50 */