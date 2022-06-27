package utilities;

public class randomInt {
	
	public static void main(String[] args) {
		
		randInt(2);
       
    }
	
	public static int randInt(int randNum) {
		 // Math.random() generates random number from 0.0 to 0.999
        // Hence, Math.random()*5 will be from 0.0 to 4.999
        double doubleRandomNumber = Math.random() * 5;
        System.out.println("doubleRandomNumber = " + doubleRandomNumber);
        // cast the double to whole number
        int randomNumber = (int)doubleRandomNumber;
        System.out.println("randomNumber = " + randomNumber);
		return randomNumber;
	}

}
