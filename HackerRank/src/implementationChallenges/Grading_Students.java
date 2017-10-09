package implementationChallenges;
import java.util.Scanner;

/*
 * Every student receives a grade in the inclusive range from 0 to 100.
 * Any grade less than 40 is a failing grade.
 * If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5.
 * For example, grade 84 will be rounded to 85 but grade 29 will not be rounded because the rounding would result in a number that is less than 40.
 * Sample Input:  4 73 67 38 33
 * Sample Output:   75 67 40 33
 */

public class Grading_Students {
	
	public static int getRoundedGrade(int grade) {
		if (grade >= 38) {
			int modifierOf5 = grade % 5;
			if (modifierOf5 > 2) {
				grade += 5 - modifierOf5;
			}
		}
		return grade;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		for (int a0 = 0; a0 < n; a0++) {
			int grade = in.nextInt();
			System.out.println(getRoundedGrade(grade));
		}
		in.close();
	}
}