package hacker_rank_Thirty;

import java.util.Scanner;

/*Given a Book class and a Solution class, write a MyBook class that does the following:
Inherits from Book, Has a parameterized constructor taking these  parameters:
string title, string author, int price
Implements the Book class' abstract display() method so it prints these 3 lines:
Title, a space, and then the current instance's .
Author, a space, and then the current instance's .
Price, a space, and then the current instance's 							*/


abstract class Book {
	
	String title;
	String author;

	Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	abstract void display();
}

class MyBook extends Book {
	int price;

  //Class Constructor
	MyBook(String title, String author, int price) {
		super(title, author);
		this.price = price;
	}
 
  //Print the title, author, and price in the specified format.
	public void display() {
		System.out.println("Title: " + this.title + "\n" + "Author: "+ this.author
				+ "\n" + "Price: " + this.price);
	}
}

public class DayThirteen {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String title = scanner.nextLine();
		String author = scanner.nextLine();
		int price = scanner.nextInt();
		scanner.close();

		Book book = new MyBook(title, author, price);
		book.display();
	}
}

/*The following input from stdin is handled by the locked stub code in your editor:
The Alchemist
Paulo Coelho
248
Sample Output: The following output is printed by your display() method:
Title: The Alchemist
Author: Paulo Coelho
Price: 248																	*/
