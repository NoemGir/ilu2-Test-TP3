package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder message = new StringBuilder("Hello, ");
		if(input == null || input.trim().equals("")) {
			return message.append("my friend").toString();
		}
		return message.append("Bob").toString();
	}

}
