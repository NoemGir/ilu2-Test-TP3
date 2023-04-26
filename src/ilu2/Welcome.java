package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder message = new StringBuilder("Hello, ");

		if (input == null || input.trim().equals("")) {
			return message.append("my friend").toString();
		}
		StringBuilder messageUpperCase = new StringBuilder(message.toString().toUpperCase());
		String[] names = input.split(",");
		
		//ajout des prenoms aux messages;
		if (triDesPrenoms(names, message, messageUpperCase)) {
			//cas ou il y au moins un nom en majuscule
			return casMajuscule(message,messageUpperCase,input).toString();
		}
		return message.toString();
	}
	/* la fonction triDesPrenoms met les prenoms dans le StringBuilder associé ( en fonction des majuscule ) 
	 * et return true si au moins un prenom est écrit en majuscule*/ 
	private static boolean triDesPrenoms(String[] names, StringBuilder message, StringBuilder messageUpperCase) {
		boolean hasUpperCase = false;
		for (int i = 0; i < names.length; i++) {
			if (names[i].toUpperCase().equals(names[i])) {
				ajoutPrenom(messageUpperCase,names[i]);
				hasUpperCase = true;
			} else {
				ajoutPrenom(message, names[i]);
			}
		}
		retirerDerniereVirgule(message);
		return hasUpperCase;
	}

	private static void ajoutPrenom(StringBuilder message, String nom) {
		message.append(mettrePremiereLettreMaj(nom));
		message.append(", ");
	}
	
	private static StringBuilder casMajuscule(StringBuilder message,StringBuilder messageUpperCase, String input) {
		retirerDerniereVirgule(messageUpperCase);
		messageUpperCase.append(" !");
		// cas ou plusieurs nom son donnés dont l'un est une majuscule
		if (input.contains(",")) {
			message.append(". AND ");
			return message.append(messageUpperCase);
		}
		// cas ou juste un nom a été donné
		return messageUpperCase;
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
