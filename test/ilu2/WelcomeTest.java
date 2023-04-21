package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WelcomeTest {
	
	/*
	 * EX_1 : Hello, Bob
La fonction prend en paramètre un nom (une chaîne de caractère) et retourne la chaîne
“Hello, <nom>”.
Par exemple, si on lui passe “bob”, elle retourne “Hello, Bob” (à noter, la majuscule sur le
nom).

	 *  
	 *  */

	@Test
	void test() {
		assertEquals(Welcome.welcome("bob"), "Hello, Bob");
	}

}
