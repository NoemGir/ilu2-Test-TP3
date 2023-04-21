package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder message = new StringBuilder("Hello, ");
		if(input == null || input.trim().equals("")) {
			return message.append("my friend").toString();
		}
		if (input.toUpperCase().equals(input)) {
			return message.append(input).toString().toUpperCase();
		}
			String firstLetter = input.substring(0, 1);
			String restOfWord = input.substring(1, input.length());
			return message.append(firstLetter.toUpperCase() + restOfWord).toString();
	}

}
