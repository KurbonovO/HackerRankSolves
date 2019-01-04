package leetcode_Easy;

import java.util.Scanner;

public class JewelsAndStonesRun {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Input the jewels: ");
		String jewels = scanner.nextLine();

		System.out.println("Input for the Stones: ");
		String stones = scanner.nextLine();

		stones = stones.replaceAll("[^" + jewels + "]", "");
		System.out.println("Stones after replaceAll: " + stones);

		System.out.println("lenght of stones");
		System.out.println(stones.length());

		scanner.close();
	}
}
