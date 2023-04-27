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
		assertEquals("HELLO, JERRY !", Welcome.welcome("JERRY"));
		assertEquals("HELLO, BOB !", Welcome.welcome("BOB"));
		assertEquals("HELLO, M !", Welcome.welcome("M"));
	}
	
	/*EX_4 : Gestion deux noms en input.
Si on donne en entr�e une cha�ne compos�e de 2 noms s�par�s par des virgules, alors
r�pondre �Hello, <Nom1>, <Nom2>�.
Par exemple, si on donne en entr�e �amy,bob�, alors retourner �Hello, Amy, Bob�
indice : la m�thode split() de la classe String peut vous simplifier la vie. */

	@Test
	void test_EX_4() {
		assertEquals("Hello, Tom and Jerry", Welcome.welcome("tom, jerry"));
		assertEquals("Hello, Jerry and Tom", Welcome.welcome("jerry, Tom"));
		assertEquals("Hello, Bob and JeanRene", Welcome.welcome("Bob, JeanRene"));
	}
	
	/*EX_5 : Gestion de plusieurs noms en input.
L’exigence est identique que EX_4, mais avec un nombre arbitraire supérieur à 2.
Par exemple, si on donne en entrée “Amy, bob,jerry”, alors retourner
“Hello, Amy, Bob, Jerry”
 */
	
	@Test
	void test_EX_5() {
		assertEquals("Hello, Tom, Jerry and Benoit", Welcome.welcome("tom, jerry, benoit"));
		assertEquals("Hello, Jerry, Tom, Bob and Benoit", Welcome.welcome("jerry, Tom, bob, Benoit"));
		assertEquals("Hello, Bob, JeanRene and A", Welcome.welcome("Bob, JeanRene, a"));
	}

	/*EX_6 : Gestion des cris lorsqu’il y a plusieurs noms.
Si un nom est écrit en majuscule, alors séparer le texte en 2 : une partie en minuscule (au
début du message) et une partie en majuscule (à la fin, se terminant par un point
d’exclamation), séparés par un “.”.
Par exemple, si on a “Amy, BOB, Jerry” en entrée, alors retourner “Hello, Amy, Jerry. AND
HELLO, BOB !”.
 */
	
	@Test
	void test_EX_6() {
		assertEquals("Hello, Jerry and Benoit. AND HELLO, TOM !", Welcome.welcome("TOM, jerry, benoit"));
		assertEquals("Hello, Jerry and Benoit. AND HELLO, TOM AND BOB !", Welcome.welcome("jerry, TOM, BOB, Benoit"));
		assertEquals("Hello, E, L and O. AND HELLO, H AND L !", Welcome.welcome("H, e, L, l, o"));
		assertEquals("Hello, E. AND HELLO, M !", Welcome.welcome("M, e"));
		assertEquals("HELLO, ETHAN, RENE AND JEANLUC !", Welcome.welcome("ETHAN, RENE, JEANLUC"));
	}
	
/*EX_7 : Gestion des listes de noms en ajoutant un “and” pour le dernier nom.
Le dernier nom d’une liste doit être précédé d’un “and” dans le message :
Par exemple, si on donne “bob, amy, jerry” alors retourner “Hello, Bob, Amy and Jerry”.
Autre exemple, si on donne “bob, AMY, jerry, JACK” alors retourner “Hello, Bob and Jerry.
AND HELLO, AMY AND JACK !”*/
	
	@Test
	void test_EX_7() {
		assertEquals("Hello, Bob, Amy and Jerry", Welcome.welcome("bob, amy, jerry"));
		assertEquals("Hello, Bob and Jerry. AND HELLO, AMY AND JACK !", Welcome.welcome("bob, AMY, jerry, JACK"));
		assertEquals("Hello, E, L and O. AND HELLO, H AND L !", Welcome.welcome("H,e,L,l,o"));
	}
	
	/*EX_8 : Supprimer les espaces inutiles.
Les espaces inutiles dans la chaîne passée en paramètre doivent être ignorés.
Par exemple, si on donne en entrée “bob , amy ”, alors répondre “Hello, Bob and Amy”*/
	
	@Test
	void test_EX_8() {
		assertEquals("Hello, Bob, Amy and Jerry", Welcome.welcome("   bob,   amy,  jerry"));
		assertEquals("Hello, Bob and Jerry. AND HELLO, AMY AND JACK !", Welcome.welcome(" bob  , AMY,  jerry, JACK "));
	}
	
	/*EX_9 : Indiquer le nombre de fois qu’un nom apparaît dans la chaîne de caractères.
Si un nom est présent plusieurs fois dans la chaîne passée en paramètre, il n’est salué
qu’une seule fois, mais le nombre de fois qu’il est présent doit être précisé dans la réponse.
Par exemple, si on donne “bob, JERRY, amy, bob, JERRY, bob”, alors répondre “Hello, Bob
(x3), and Amy. AND HELLO JERRY (x2)”.
indice : Vous pouvez utiliser deux tableaux, le premier contenant la liste des noms (distincts)
passés en paramètre, et le second contenant le nombre de fois que le nom correspondant
apparaît. Ces deux tableaux sont ensuite passés en paramètre à une nouvelle méthode
privée qui fait l’affichage proprement dit.
	  */

	@Test
	void test_EX_9() {
		assertEquals("Hello, Bob(x3) and Amy. AND HELLO, JERRY(x2) !", Welcome.welcome("bob, JERRY, amy, bob, JERRY, bob"));
		assertEquals("Hello, Bob(x2), Jerry(x3) and Jack(x2). AND HELLO, AMY(x2), JACK AND BOB !", Welcome.welcome(" bob, AMY, jerry, JACK, BOB, jack, jack, bob, jerry, AMY, jerry"));
		assertEquals("Hello, Bob(x15)", Welcome.welcome(" bob, bob, bob, bob, Bob, Bob, bob, Bob, Bob, bob, bob ,bob, bob, bob, bob"));
		assertEquals("Hello, Hello(x3). AND HELLO, HELLO(x2) !", Welcome.welcome(" hello, hello, HELLO, Hello, HELLO"));
		assertEquals("Hello, H(x2), B(x2) and C(x2). AND HELLO, H(x2) !", Welcome.welcome(" h, H, b, H, b, c  , c, h"));
	}
	
	/*EX_10 : Yoda
S’il y a le nom Yoda dans la liste des noms, alors inverser la liste des noms et le mot Hello.
Par exemple, si on donne “bob, yoda, amy, JERRY”, alors répondre “Bob, Yoda, and Amy,
Hello. AND HELLO JERRY”
Autre exemple : si on donne “bob, YODA, amy, JERRY, YODA”, alors répondre “Hello, Bob
and Amy. AND YODA (X2) AND JERRY HELLO !”*/
	
	@Test
	void test_EX_10() {
		assertEquals("Bob, Yoda and Amy, Hello. AND HELLO, JERRY !", Welcome.welcome("bob, yoda, amy, JERRY"));
		assertEquals("Hello, Bob and Amy. AND YODA(x2) AND JERRY, HELLO !", Welcome.welcome("bob, YODA, amy, JERRY, YODA"));
		assertEquals("Hello, Yodam and Yodak. AND YODA(x2) AND YODAR, HELLO !", Welcome.welcome("Yodam, YODA, Yodak, YODAR, YODA"));
	}
}

























