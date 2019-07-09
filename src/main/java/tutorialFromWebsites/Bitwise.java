package tutorialFromWebsites;

public class Bitwise {

	public static int orOperator() {

		int a = 6;
		int b = 1;
		return a | b;
	}

	public static int andOperator() {

		int a = 6;
		int b = 5;
		return a & b;
	}
	
	public static int xorOperator() {
		
		int a = 6;
		int b = 5;
		return a ^ b;
	}
	
	public static int complement() {
		
		int a = 6;
		return ~a; 
	}

	public static void main(String[] args) {

		System.out.println(Bitwise.orOperator());
		System.out.println(Bitwise.andOperator());
	}

}
