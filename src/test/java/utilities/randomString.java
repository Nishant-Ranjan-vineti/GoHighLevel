package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class randomString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		randString();

	}

	public static String randString() {
		int length = 10;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

		System.out.println(generatedString);
		return generatedString;
	}

}