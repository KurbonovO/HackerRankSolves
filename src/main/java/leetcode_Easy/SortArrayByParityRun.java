package leetcode_Easy;

import java.util.Arrays;
import java.util.Scanner;

public class SortArrayByParityRun {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int sizeOfArray = scanner.nextInt();

		int[] array = new int[sizeOfArray];

		for (int i = 0; i < array.length; i++) {

			array[i] = scanner.nextInt();
		}

		scanner.close();

		int i = 0;

		for (int n = 0; n < array.length; n++) {

			if ((array[n] % 2) == 0) {

				//take the first value of the array and assing to tmp
				int tmp = array[i];
				
				array[i++] = array[n];
				
				//take the value of tmp and put it to array nth index
				array[n] = tmp;
			}
		}
		System.out.println(Arrays.toString(array));
	}

}
