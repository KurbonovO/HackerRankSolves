package util;

public class Printer {
	public < E > void printArray( E[] inputArray ){    
	     
		for ( E element : inputArray ){        
	        System.out.printf( "%s\n", element );
	     }
	} 
}
