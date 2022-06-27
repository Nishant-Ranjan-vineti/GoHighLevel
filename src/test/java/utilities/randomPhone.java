package utilities;

import java.util.Random;

public class randomPhone {
	
	public static void main(String[] args) {
		randPhone();
	}
	
	public static CharSequence[] randPhone() {
Random rd = new Random();
		
		int rdNum;
		
		String m[] = new String[10];
		
		for(int i=0; i<10; i++) { 
			rdNum = rd.nextInt(10);
			
			m[i] = Integer.toString(rdNum);
		}
		
		System.out.println(m[0] + m[1] + m[2] + m[3] + m[4] + m[5] + m[6] + m[7] + m[8] + m[9]);
		return m;
	}

}
