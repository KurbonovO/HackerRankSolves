package hacker_rank_Thirty;

import java.util.Scanner;

/*You are given two classes, Person and Student, where Person is the base class
and Student is the derived class. Completed code for Person and a declaration for
Student are provided for you in the editor. Observe that Student inherits all the
properties of Person. Complete the Student class by writing the following:
A Student class constructor, which has 4 parameters:
A string, firstName. A string, lastName. An integer, id. An integer array (or vector)
of test scores, scores. A char calculate() method that calculates a Student object's
average and returns the grade character representative of their calculated average:
"some grading scale"  														  */

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;

  //Constructor
	Person(String firstName, String lastName, int identification) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}

  //Print person data
	public void printPerson() {
		System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + idNumber);
	}
}

class DayTwelve extends Person {

	private int[] testScores;

	DayTwelve(String firstName, String lastName, int identification, int[] scores) {
		super(firstName, lastName, identification);
		this.testScores = scores;
	}

	public char calculate() {
		
		int average = 0;
		
		for (int i = 0; i < testScores.length; i++) {
			average += testScores[i];
		}
		
		average = average / testScores.length;

		if (average >= 90) {
			return 'O'; // Outstanding
		} else if (average >= 80) {
			return 'E'; // Exceeds Expectations
		} else if (average >= 70) {
			return 'A'; // Acceptable
		} else if (average >= 55) {
			return 'P'; // Poor
		} else if (average >= 40) {
			return 'D'; // Dreadful
		} else {
			return 'T'; // Troll
		}
	}
}

class Solution {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		
		for (int i = 0; i < numScores; i++) {
			testScores[i] = scan.nextInt();
		}
		scan.close();

		DayTwelve s = new DayTwelve(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate());
	}
}

/*Heraldo Memelli 8135627
2
100 80
Sample Output:
Name: Memelli, Heraldo
ID: 8135627
Grade: O
Explanation: 
This student had 2 scores to average: 100 and 80. The student's average grade is
(100 + 80 ) / 2 = 90. An average grade of 90 corresponds to the letter grade O,
so our calculate() method should return the character'O'					  */
