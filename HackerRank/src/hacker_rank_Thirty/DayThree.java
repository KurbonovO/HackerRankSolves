package hacker_rank_Thirty;

import java.util.Scanner;

/*Given the meal price (base cost of a meal), tip percent (the percentage of the
meal price being added as tip), and tax percent (the percentage of the meal price
being added as tax) for a meal, find and print the meal's total cost          */

public class DayThree {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// original meal price
		double mealCost = scan.nextDouble();
		// tip percentage
		int tipPercent = scan.nextInt();
		// tax percentage
		int taxPercent = scan.nextInt();

		scan.close();

		// Write your calculation code here.
		double tip = mealCost * tipPercent / 100;
		double tax = mealCost * taxPercent / 100;

		// cast the result of the rounding operation to an int and save it as totalCost
		int totalCost = (int) Math.round(tip + tax);

		// Print your result
		System.out.println(totalCost);
	}
}

/*Sample Input: 
12.00
20
8
Sample Output: The total meal cost is 15 dollars.
Explanation: Given: mealCost = 12, tipPercent = 20, taxPercent = 8 Calculations: 
tip = 12 * (20/100) = 2.4 
tax = 12 * (8/100)  = .96 We round  to the nearest dollar (integer) and then 
print our result															  */
