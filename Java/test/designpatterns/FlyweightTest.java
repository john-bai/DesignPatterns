/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.Font;
/**
 *
 * @author jtherrell
 */
public class FlyweightTest {

	private static final char[] chars = {'a','b','c','d','e','f'};
	private static final Font[] fonts = {new Font("Arial", Font.BOLD, 12), new Font("Times", Font.ITALIC, 18)};
	/**
	 * Test of getInstance method, of class Singleton.
	 */ @Test
	public void testFlyweightSingletonBehavior() {
		 Character[] characters = new Character[chars.length];
		 for (int i = 0; i < chars.length; i++) {
			characters[i] = CharacterFactory.CreateCharacter(chars[i]);
			assertEquals(characters[i], CharacterFactory.CreateCharacter(chars[i]));
		}
	}

	/**
	 * Test of getInstance method, of class Singleton.
	 */ @Test
	public void testFlyweightDraw() {
		Log log = new Log();
		Character[] characters = new Character[chars.length];
		for (int i = 0; i < chars.length; i++) {
			CharacterFactory.CreateCharacter(chars[i]).draw(fonts[i%2], log);
		}
		String expResult = "a:Arial-BoldMT\nb:Times-Italic\nc:Arial-BoldMT\n"
						 + "d:Times-Italic\ne:Arial-BoldMT\nf:Times-Italic\n";
		String result = log.toString();
		assertEquals(expResult, result);
	 }

}
