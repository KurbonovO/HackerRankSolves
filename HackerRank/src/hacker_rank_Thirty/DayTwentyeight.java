package hacker_rank_Thirty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/*Consider a database table Emails, which has the attributes First Name and Email
ID. Given N rows of data simulating the Emails table, print an alphabetically-ordered
list of people whose email address ends in @gmail.com						  */

class Email {

	public String name;
	public String email;

	public Email(String name, String email) {
		this.name = name;
		this.email = email;
	}
}

public class DayTwentyeight {
	
	// Simulate the Email's table
	static List<Email> emailList;

	public static List<String> getGmailUsers() {
		
		List<String> names = new ArrayList<String>();
		Pattern p = Pattern.compile(".*@gmail.com");

		for (Email email : emailList) {
			
			if (p.matcher(email.email).matches()) {
				names.add(email.name);
			}
		}
		
		Collections.sort(names);
		return names;
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		emailList = new ArrayList<Email>();
		int intN = scanner.nextInt();
		
		for (int i = 0; i < intN; i++) {
			emailList.add(new Email(scanner.next(), scanner.next()));
		}
		
		scanner.close();

		for (String name : getGmailUsers()) {
			System.out.println(name);
		}
	}
}

/*Sample Input: 6
riya riya@gmail.com
julia julia@julia.me
julia sjulia@gmail.com
julia julia@gmail.com
samantha samantha@gmail.com
tanya tanya@gmail.com
Sample Output:
julia
julia
riya
samantha
tanya																		  */
