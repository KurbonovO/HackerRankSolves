package hacker_rank_Thirty;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*Given n names and phone numbers, assemble a phone book that maps friends' names
to their respective phone numbers. You will then be given an unknown number of names
to query your phone book for. For each named queried, print the associated entry from
your phone book on a new line in the form name = phoneNumber; if an entry for name
is not found, print Not found instead										  */

public class DayEight {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Map<String, Integer> phoneBook = new HashMap<String, Integer>();
		
		
		int n = scan.nextInt();
		
		for (int i = 0; i < n; i++) {
			String name = scan.next();
			int phone = scan.nextInt();
			phoneBook.put(name, phone);
		}
		
		while (scan.hasNext()) {
			String s = scan.next();
			Integer phoneNumber = phoneBook.get(s);
			System.out.println((phoneNumber != null) ? s + "=" + phoneNumber : "Not found");
		}
		scan.close();
	}
}

/*sample Input:
3
sam 99912222
tom 11122222
harry 12299933
sam
edward
harry
Sample Output:
sam=99912222
Not found
harry=12299933
We add the following n = 3 (Key,Value) pairs to our map so it looks like this:
phoneBook = {(sam,99912222), (tom 11122222), (harry 12299933)}
We then process each query and print key = value if the queried key is found in
the map; otherwise, we print Not found.
Query 0: sam 
Sam is one of the keys in our dictionary, so we print sam = 99912222
Query 1: edward 
Edward is not one of the keys in our dictionary, so we print Not found
Query 2: harry 
Harry is one of the keys in our dictionary, so we print harry = 12299933	  */