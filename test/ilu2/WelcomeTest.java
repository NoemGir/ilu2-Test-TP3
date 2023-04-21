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
		assertEquals(Welcome.welcome("bob"), "Hello, Bob");
		assertEquals(Welcome.welcome("Bob"), "Hello, Bob");
	}
	
	/*EX_2 : Gestion des null et des cha�nes vides
Si on passe en param�tre une cha�ne de caract�re vide, nulle ou blanche (que des
espaces), alors retourner �Hello, my friend�.
Par exemple, si on lui passe � �, elle retourne �Hello, my friend�.
Indice : la m�thode �trim()� de la classe String peut vous simplifier la vie */
	
	@Test
	void test_EX_2() {
		assertEquals(Welcome.welcome("   "), "Hello, my friend");
		assertEquals(Welcome.welcome(""), "Hello, my friend");
		assertEquals(Welcome.welcome(null), "Hello, my friend");
	}
}
