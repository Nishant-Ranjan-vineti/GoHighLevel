package utilities;

import java.util.UUID;

public class randomEmail {
	
	public static String randomEmailGenerator() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }

}
