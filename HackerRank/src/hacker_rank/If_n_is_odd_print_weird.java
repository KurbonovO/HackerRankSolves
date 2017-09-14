package hacker_rank;

import java.util.Scanner;

public class If_n_is_odd_print_weird {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int i = scan.nextInt();
		
		scan.close();

		String answear = "";

		if (i % 2 == 1 || (i >= 6 && i <= 20)) {
			answear = "Weird";
		} else {
			answear = "Not Weird";
		}
		System.out.println(answear);
		
	}
}
