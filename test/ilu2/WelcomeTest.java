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
		assertEquals("Hello, M", Welcome.welcome("M") );
	}
	
	
}
