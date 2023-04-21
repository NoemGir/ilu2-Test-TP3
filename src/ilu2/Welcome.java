package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder message = new StringBuilder("Hello, ");
		StringBuilder messageUpperCase = new StringBuilder(message.toString().toUpperCase());

		if (input == null || input.trim().equals("")) {
			return message.append("my friend").toString();
		}
		String[] names = input.split(",");
		boolean hasUpperCase = false;
		for (int i = 0; i < names.length; i++) {
			if (names[i].toUpperCase().equals(names[i])) {
				messageUpperCase.append(names[i]);
				messageUpperCase.append(", ");
				hasUpperCase = true;
			} else {
				message.append(mettrePremiereLettreMaj(names[i]));
				message.append(", ");
			}
		}
		retirerDerniereVirgule(message);

		if (hasUpperCase) {
			retirerDerniereVirgule(messageUpperCase);
			messageUpperCase.append(" !");
			if (!input.contains(",")) {
				return messageUpperCase.toString();
			}
			message.append(". AND ");
			return message.append(messageUpperCase).toString();
		}
		return message.toString();
	}
	
	private static String EmptyNullCase() {
		
	}
	
	private static void retirerDerniereVirgule(StringBuilder str) {
		int length = str.length();
		str.delete(length-2, length);
	}
	
	private static String mettrePremiereLettreMaj(String nom) {
		String firstLetter = nom.substring(0, 1);
		String restOfWord = nom.substring(1, nom.length());
		StringBuilder resultat = new StringBuilder(firstLetter.toUpperCase());
		return resultat.append(restOfWord).toString();
	}
}
