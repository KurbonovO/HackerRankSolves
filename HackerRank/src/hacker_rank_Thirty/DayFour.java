package hacker_rank_Thirty;

public class DayFour {
	
	private int age;

	public DayFour (int initialAge) {
		
		 //initial age is invalid
	        if(initialAge < 0){ 
	            System.out.println("Age is not valid, setting age to 0.");
	            this.age = 0;
	        }
	      //set age to valid initial age
	        else{ 
	            this.age = initialAge;
	        }
	    }

	public void amIOld() {
	  //Set correct statement to print
		String result = "";
		if (age >= 18) {
			result = "You are old.";
		} else if (age >= 13) {
			result = "You are a teenager.";
		} else {
			result = "You are young.";
		}
		System.out.println(result);
	}

	public void yearPasses() {
	  //Increment this person's age.
		this.age++;
	}
}