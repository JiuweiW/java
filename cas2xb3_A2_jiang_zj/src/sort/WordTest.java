package sort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordTest {
	private Word a;
	private Word b;
	private Word c;
        /**
         * Create words for test
         */
	@Before
	public void setup() {
		a = new Word("Batman", 76);
		b = new Word("Iron man", 76);
		c = new Word("Spiderman", 98);
	}
        /**
         * Tests for word class getScore function.
         * If the score of word is equal to the word use getScore function,  
         * assertEquals() function will pass
         */
	@Test
	public void testGetScore() {
		assertEquals(76, a.getScore());
		assertEquals(76, b.getScore());
		assertEquals(98, c.getScore());
	}
        /**
         * Tests for word class setScore function.
         * If the score of word is equal to the word use setScore function,  
         * assertEquals() function will pass
         */
	@Test
	public void testSetScore() {
		a.setScore(78);
		assertEquals(78, a.getScore());
	}
        /**
         * Tests for word class getWcore function.
         * If the word is equal to the word use getWord function,  
         * assertEquals() function will pass
         */
	@Test
	public void testGetWord() {
		assertEquals("Batman", a.getWord());
		assertEquals("Iron man", b.getWord());
		assertEquals("Spiderman", c.getWord());
	}
        /**
         * Tests for word class setWcore function.
         * If the word is equal to the word use setWord function,  
         * assertEquals() function will pass
         */
	@Test
	public void testSetWord() {
		a.setWord("Bruce Wayne");
		assertEquals("Bruce Wayne", a.getWord());
	}
        /**
         * Tests for word class compareTo function.
         * If the score of word is less than the other word, return -1 
         * assertEquals() function will pass
         */
	@Test
	public void testCompareTo() {
		assertEquals(0, a.compareTo(b));
		assertEquals(1, c.compareTo(a));
		assertEquals(-1, b.compareTo(c));
	}
        /**
         * Tests for word class toString function.
         * If the word format is same to the word use toString function
         * assertEquals() function will pass
         */
	@Test
	public void testToString() {
		assertEquals("{Batman,76}", a.toString());
		assertEquals("{Iron man,76}", b.toString());
		assertEquals("{Spiderman,98}", c.toString());
	}

}
