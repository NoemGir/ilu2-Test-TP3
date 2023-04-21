package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder message = new StringBuilder("Hello, ");
		if(input == null || input.trim().equals("")) {
			return message.append("my friend").toString();
		}
		if(input.contains(",")) {
			String[] names = input.split(",");
			for( int i = 0; i < names.length; i++) {
				message.append(mettrePremiereLettreMaj(names[i]));
				message.append(", ");
			}
			int messageLength = message.length();
			message.delete(messageLength-2, messageLength);
			return message.toString();
		}
		if (input.toUpperCase().equals(input)) {
			message.append(input);
			return message.append(" !").toString().toUpperCase();
		}
		return message.append(mettrePremiereLettreMaj(input)).toString();
	}

	private static String mettrePremiereLettreMaj(String nom) {
		String firstLetter = nom.substring(0, 1);
		String restOfWord = nom.substring(1, nom.length());
		StringBuilder resultat = new StringBuilder(firstLetter.toUpperCase());
		return resultat.append(restOfWord).toString();
	}
}
