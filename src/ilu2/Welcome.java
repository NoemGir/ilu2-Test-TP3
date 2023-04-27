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
		triDesPrenoms(names, message, messageUpperCase);
		// RetirerDernierVirgule/ ModeYoda / ajouter le And
		mettreANiveauMessages(message,messageUpperCase );
		//retirer le message non majuscule si il n'y a pas de prénom a l'interieur
		if(message.length() < 8) {
			message.setLength(0);
		}
		// ajouter le potentiel message en majuscule
		message.append(ajoutCasMajuscule(message, messageUpperCase,input));
		return message.toString();
	}
	
	private static void mettreANiveauMessages(StringBuilder message, StringBuilder messageUpperCase){
		modifYoda(message);
		modifYoda(messageUpperCase);
		
		retirerDerniereVirgule(messageUpperCase);
		retirerDerniereVirgule(message);

		ajouterAnd(messageUpperCase, "AND");
		ajouterAnd(message, "and");
	}
	
	/* la fonction triDesPrenoms met les prenoms dans le StringBuilder associé ( en fonction des majuscule ) 
	 * et return true si au moins un prenom est écrit en majuscule*/ 
	private static boolean triDesPrenoms(String[] names, StringBuilder message, StringBuilder messageUpperCase) {
		boolean hasUpperCase = false;
		for (int i = 0; i < names.length; i++) {
			names[i] = names[i].trim();
			if (names[i].toUpperCase().equals(names[i])) {
				ajoutPrenom(messageUpperCase,names[i]);
				hasUpperCase = true;
			} else {
				ajoutPrenom(message, names[i]);
			}
		}
		return hasUpperCase;
	}
	
	private static void modifYoda(StringBuilder message) {
		if(message.toString().toUpperCase().contains(" YODA,") || 
				message.toString().toUpperCase().contains(" YODA(") || 
				message.toString().toUpperCase().contains(" YODA ")) {
			
			String[] elements = message.toString().split(" ");

			//reassambler message en mettant hello a la fin
			message.setLength(0);
			for(int i = 1; i < elements.length; i++) {
				message.append(elements[i]);	
				message.append(" ");
		}
			message.append(elements[0]);
		}
	}
	
	public static void and(StringBuilder avantDernierNom, String and) {
		//retirer la virgule
		int length = avantDernierNom.length();
		avantDernierNom.delete(length-1, length);
		//ajouter and
		avantDernierNom.append(" ");
		avantDernierNom.append(and);
	}
	
	private static void ajouterAnd(StringBuilder message, String and) {
		String[] separation = message.toString().split("(?<=,)");
		
		if(separation.length > 2) {
			// cas ou il y a un Yoda
			if(separation[separation.length-1].toUpperCase().equals(" HELLO")) {
				StringBuilder avantDernierNom = new StringBuilder(separation[separation.length-3]);
				and(avantDernierNom, and);
				separation[separation.length-3]=avantDernierNom.toString();
			}
			else {
				StringBuilder avantDernierNom = new StringBuilder(separation[separation.length-2]);
				and(avantDernierNom, and);
				separation[separation.length-2]=avantDernierNom.toString();
			}
			//reassambler message
				message.setLength(0);
				for(int i = 0; i < separation.length; i++) {
					message.append(separation[i]);	
			}
		}
	}

	private static void ajoutPrenom(StringBuilder message, String nom) {
		nom = mettrePremiereLettreMaj(nom);
		StringBuilder aReproduire = new StringBuilder(" ");
		aReproduire.append(nom);
		// verifier si e prenom est déja présent dans la liste
		if(message.toString().contains(aReproduire)) {
			casPrenomDejaPresent(message, aReproduire);
		}
		// si le prenom n'est pas présent, on l'ajoute
		else {
			message.append(nom);
			message.append(", ");
		}
	}
	
	private static void casPrenomDejaPresent(StringBuilder message, StringBuilder aReproduire) {
		int index = message.indexOf(aReproduire.toString())+aReproduire.length()-1;
		StringBuilder debutMessage = new StringBuilder(message.toString().substring(0, index+1));
	
		StringBuilder finMessage;
		int debutFinMessage = index+1;
		
		// on vérifie si le prénom est a déja un nombre d'occurence associé 
		if(message.charAt(index+1) == '(') {
			StringBuilder nouvelleValeur = donnerNouvelleValeurParentheses(message, index);
			debutMessage.append(nouvelleValeur);
			debutFinMessage += nouvelleValeur.length();
		}
		// si il n'a pas de nombre d'occurence associé alors il suffit d'initaliser son nombre d'occurence a 2
		else {
			debutMessage.append("(x2)");
		}
		finMessage = new StringBuilder(message.toString().substring(debutFinMessage, message.length()));
		
		message.setLength(0);
		message.append(debutMessage);
		message.append(finMessage);
	}
	
	// donnerNouvelleValeurParentheses retourne un StringBuilder qui correspond 
	//aux parentheses avec le nouveau nombre d'occurence a l'interieur
	private static StringBuilder donnerNouvelleValeurParentheses(StringBuilder message, int index) {
		StringBuilder resteMessage = new StringBuilder(message.toString().substring(index+1, message.length()));
		StringBuilder strNum = new StringBuilder(resteMessage.toString().substring(2, resteMessage.indexOf(")")));
		
		int numero = Integer.parseInt(String.valueOf(strNum));
		numero++;
		
		StringBuilder parentheses = new StringBuilder("(x");
		parentheses.append(numero);
		parentheses.append(")");
		
		return parentheses;
	}
	
	private static StringBuilder ajoutCasMajuscule(StringBuilder message, StringBuilder messageUpperCase, String input) {
		// cas ou il n'y a pas de prénom en majuscule
		if(messageUpperCase.length() < 8) {
			messageUpperCase.setLength(0);
		}
		else {
			messageUpperCase.append(" !");
			// cas ou plusieurs nom son donnés dont l'un est une majuscule
			if (input.contains(",") && message.length() > 0) {
				StringBuilder upperCaseMessage = new StringBuilder(". AND ");
				upperCaseMessage.append(messageUpperCase);
				messageUpperCase = upperCaseMessage;
			}
		}
		// cas ou juste un nom a été donné
		return messageUpperCase;
	}
	
	private static void retirerDerniereVirgule(StringBuilder str) {
		int length = str.length();
		if(str.lastIndexOf(",") == length-2) {
			str.delete(length-2, length);
		}
		else {
			str.delete(length-1, length);
		}
	}
	
	private static String mettrePremiereLettreMaj(String nom) {
		//  sb.setCharAt(pos, ch);
		String firstLetter = nom.substring(0, 1);
		String restOfWord = nom.substring(1, nom.length());
		StringBuilder resultat = new StringBuilder(firstLetter.toUpperCase());
		return resultat.append(restOfWord).toString();
	}
}
