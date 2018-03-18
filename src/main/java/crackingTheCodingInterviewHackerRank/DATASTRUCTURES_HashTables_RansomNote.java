package crackingTheCodingInterviewHackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
The words in his note are case-sensitive and he must use whole words available in the magazine, meaning he cannot use substrings or concatenation
to create the words he needs.
Given the words in the magazine and the words in the ransom note, 
print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
*/

public class DATASTRUCTURES_HashTables_RansomNote {

	Map<String, Integer> magazineMap;
	Map<String, Integer> noteMap;

	public DATASTRUCTURES_HashTables_RansomNote(String magazine, String note) {
		
		this.noteMap = new HashMap<String, Integer>();
		this.magazineMap = new HashMap<String, Integer>();

		// Must use an object instead of a primitive because it may be assigned
		// a null reference.
		Integer occurrences;

		for (String s : magazine.split("[^a-zA-Z]+")) {
			occurrences = magazineMap.get(s);

			if (occurrences == null) {
				magazineMap.put(s, 1);
			} else {
				magazineMap.put(s, occurrences + 1);
			}
		}

		for (String s : note.split("[^a-zA-Z]+")) {
			occurrences = noteMap.get(s);

			if (occurrences == null) {
				noteMap.put(s, 1);
			} else {
				noteMap.put(s, occurrences + 1);
			}
		}
	}

	public void solve() {
		boolean canReplicate = true;
		for (String s : noteMap.keySet()) {
			if (!magazineMap.containsKey(s) || (magazineMap.get(s) < noteMap.get(s))) {
				canReplicate = false;
				break;
			}
		}
		System.out.println((canReplicate) ? "Yes" : "No");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		scanner.nextLine();// Eat whitespace to beginning of next line

		DATASTRUCTURES_HashTables_RansomNote s = new DATASTRUCTURES_HashTables_RansomNote(
				scanner.nextLine(), scanner.nextLine());

		scanner.close();
		s.solve();
	}
}