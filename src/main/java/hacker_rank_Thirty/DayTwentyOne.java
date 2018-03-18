package hacker_rank_Thirty;

import java.util.Scanner;

import util.Printer;

/*Write a single generic function named printArray; this function must take an
array of generic elements as a parameter (the exception to this is C++, which takes
a vector). The locked Solution class in your editor tests your function       */

public class DayTwentyOne {
	public static void main(String args[]){
        
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] intArray = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            intArray[i] = scanner.nextInt();
        }

        n = scanner.nextInt();
        String[] stringArray = new String[n];
        
        for (int i = 0; i < n; i++) {
            stringArray[i] = scanner.next();
        }
        
        scanner.close();
        
        Printer intPrinter = new Printer();
        Printer stringPrinter = new Printer();
        intPrinter.printArray( intArray  );
        stringPrinter.printArray( stringArray );
        if(Printer.class.getDeclaredMethods().length > 1){
            System.out.println("The Printer class should only have 1 method named printArray.");
        }
    } 
}
