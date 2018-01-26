package hacker_rank_Thirty;

import java.util.Arrays;
import java.util.Scanner;

/*The absolute difference between two integers, a and b, is written as |a-b|. The
maximum absolute difference between two integers in a set of positive integers, elements,
is the largest absolute difference between any two integers in elements. The Difference
class is started for you in the editor. It has a private integer array (elements)
for storing N non-negative integers, and a public integer (MaxmuimDifference) for
storing the maximum absolute difference. Complete the Difference class by writing
the following: A class constructor that takes an array of integers as a parameter
and saves it to the  instance variable. A computeDifference method that finds the
maximum absolute difference between any  numbers in  and stores it in the  instance
variable															*/

class Difference {
	private int[] elements;
	public int maximumDifference;

	public Difference(int[] a) {
		elements = a;
	}

	public void computeDifference() {
		Arrays.sort(elements);
		this.maximumDifference = Math.abs(elements[elements.length - 1] - elements[0]);
	}
}

public class DayFourteen {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		scanner.close();

		Difference difference = new Difference(a);

		difference.computeDifference();

		System.out.print(difference.maximumDifference);
	}
}

/*Sample Input:
3
1 2 5
Sample Output: 4

The scope of the elements array and maximumDifference integer is the entire class
instance. The class constructor saves the argument passed to the constructor as
the elements instance variable (where the computeDifference method can access it).
To find the maximum difference, computeDifference checks each element in the array
and finds the maximum difference between any 2 elements:  |1-2| = 1
|1-5| = 4
|2-5| = 3
The maximum of these differences is 4, so it saves the value 4 as the maximumDifference
instance variable. The locked stub code in the editor then prints the value stored
as maximumDifference, which is 4										*/