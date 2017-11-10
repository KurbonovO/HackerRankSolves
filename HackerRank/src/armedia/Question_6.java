package armedia;

public class Question_6 {
	public static void main(String[] args) {

		String name = new String();
		int i;
		boolean startWorld;
		
		name = "Richard M. Nixon";
		startWorld = true;
		for(i=0; i<name.length();i++) {
			if(startWorld) {
				System.out.println(name.charAt(i));
			}
			//if(name.charAt(i) == '') {
			//	startWorld = true;
			//}
			else {
				startWorld = false;
			}
		}

	}
}
