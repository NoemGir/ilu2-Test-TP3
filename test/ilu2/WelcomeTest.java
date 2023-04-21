package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WelcomeTest {
	
	/* EX_1 : Hello, Bob
La fonction prend en param�tre un nom (une cha�ne de caract�re) et retourne la cha�ne
�Hello, <nom>�.
Par exemple, si on lui passe �bob�, elle retourne �Hello, Bob� (� noter, la majuscule sur le
nom). */

	@Test
	void test_EX_1() {
		assertEquals("Hello, Bob", Welcome.welcome("Bob") );
		assertEquals("Hello, Bob", Welcome.welcome("bob") );
		assertEquals("Hello, M", Welcome.welcome("m") );
	}
	
	/*EX_2 : Gestion des null et des cha�nes vides
Si on passe en param�tre une cha�ne de caract�re vide, nulle ou blanche (que des
espaces), alors retourner �Hello, my friend�.
Par exemple, si on lui passe � �, elle retourne �Hello, my friend�.
Indice : la m�thode �trim()� de la classe String peut vous simplifier la vie */
	
	@Test
	void test_EX_2() {
		assertEquals("Hello, my friend",Welcome.welcome("   "));
		assertEquals("Hello, my friend",Welcome.welcome(""));
		assertEquals("Hello, my friend",Welcome.welcome(null));
	}
	
	/* EX_3 : Gestion des cris
Si on donne une cha�ne de caract�res en majuscule, alors r�pondre en majuscule, et
terminer par un point d�exclamation.
Par exemple, si on donne �JERRY�, alors retourner �HELLO, JERRY !�
indice : la m�thode �toUpperCase()� de la classe String peut vous simplifier la vie. On
rappelle que deux cha�nes de caract�res peuvent �tre compar�es en utilisant equals.
*/
	@Test
	void test_EX_3() {
		assertEquals("HELLO, JERRY", Welcome.welcome("JERRY"));
		assertEquals("HELLO, BOB", Welcome.welcome("BOB"));
		assertEquals("HELLO, M", Welcome.welcome("M"));
	}
	
	/*EX_4 : Gestion deux noms en input.
Si on donne en entr�e une cha�ne compos�e de 2 noms s�par�s par des virgules, alors
r�pondre �Hello, <Nom1>, <Nom2>�.
Par exemple, si on donne en entr�e �amy,bob�, alors retourner �Hello, Amy, Bob�
indice : la m�thode split() de la classe String peut vous simplifier la vie. */
	@Test
	
	void test_EX_4() {
		assertEquals("Hello, Tom, Jerry", Welcome.welcome("tom,jerry"));
		assertEquals("Hello, my friend", Welcome.welcome("BOB"));
		assertEquals("Hello, my friend", Welcome.welcome("BOB"));
	}
	
}











