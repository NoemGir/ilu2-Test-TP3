package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder message = new StringBuilder("Hello, ");
		if(input == null || input.trim().equals("")) {
			return message.append("my friend").toString();
		}
		if(input.contains(",")) {
			String[] names = input.split(",");
			String firstName = mettrePremiereLettreMaj(names[0]);
			String secondName = mettrePremiereLettreMaj(names[1]);
			return message.append(firstName + ", " + secondName).toString();
		}
		if (input.toUpperCase().equals(input)) {
			return message.append(input).toString().toUpperCase();
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
