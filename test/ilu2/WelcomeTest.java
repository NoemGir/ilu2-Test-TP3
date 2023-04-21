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
		assertEquals("Hello, M", Welcome.welcome("M") );
	}
	
	
}
