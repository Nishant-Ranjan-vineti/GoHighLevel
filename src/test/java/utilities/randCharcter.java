package utilities;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class randCharcter {

	public static String randChar() {
		int length = 1;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

		System.out.println(generatedString);
		return generatedString;
	}
	
	public static void main(String[] args) {
		randChar();
	}



}
