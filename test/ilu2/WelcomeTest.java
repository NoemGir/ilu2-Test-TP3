package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WelcomeTest {
	
	/* EX_1 : Hello, Bob
La fonction prend en paramètre un nom (une chaîne de caractère) et retourne la chaîne
“Hello, <nom>”.
Par exemple, si on lui passe “bob”, elle retourne “Hello, Bob” (à noter, la majuscule sur le
nom). */

	@Test
	void test_EX_1() {
		assertEquals("Hello, Bob", Welcome.welcome("Bob") );
		assertEquals("Hello, Bob", Welcome.welcome("bob") );
		assertEquals("Hello, M", Welcome.welcome("m") );
	}
	
	/*EX_2 : Gestion des null et des chaînes vides
Si on passe en paramètre une chaîne de caractère vide, nulle ou blanche (que des
espaces), alors retourner “Hello, my friend”.
Par exemple, si on lui passe “ “, elle retourne “Hello, my friend”.
Indice : la méthode “trim()” de la classe String peut vous simplifier la vie */
	
	@Test
	void test_EX_2() {
		assertEquals("Hello, my friend",Welcome.welcome("   "));
		assertEquals("Hello, my friend",Welcome.welcome(""));
		assertEquals("Hello, my friend",Welcome.welcome(null));
	}
	
	/* EX_3 : Gestion des cris
Si on donne une chaîne de caractères en majuscule, alors répondre en majuscule, et
terminer par un point d’exclamation.
Par exemple, si on donne “JERRY”, alors retourner “HELLO, JERRY !”
indice : la méthode “toUpperCase()” de la classe String peut vous simplifier la vie. On
rappelle que deux chaînes de caractères peuvent être comparées en utilisant equals.
*/
	@Test
	void test_EX_3() {
		assertEquals("HELLO, JERRY", Welcome.welcome("JERRY"));
		assertEquals("HELLO, BOB", Welcome.welcome("BOB"));
		assertEquals("HELLO, M", Welcome.welcome("M"));
	}
	
	/*EX_4 : Gestion deux noms en input.
Si on donne en entrée une chaîne composée de 2 noms séparés par des virgules, alors
répondre “Hello, <Nom1>, <Nom2>”.
Par exemple, si on donne en entrée “amy,bob”, alors retourner “Hello, Amy, Bob”
indice : la méthode split() de la classe String peut vous simplifier la vie. */
	@Test
	
	void test_EX_4() {
		assertEquals("Hello, Tom, Jerry", Welcome.welcome("tom,jerry"));
		assertEquals("Hello, my friend", Welcome.welcome("BOB"));
		assertEquals("Hello, my friend", Welcome.welcome("BOB"));
	}
	
}











