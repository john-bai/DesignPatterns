/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author jtherrell
 */
public class DecoratorTest {

	/**
	 * Test of getInstance method, of class Singleton.
	 */ @Test
	public void testDecorator() {
		Log log = new Log();
		BorderDecorator decorator = new BorderDecorator(new ScrollDecorator(new TextView()));
		decorator.draw(log);
		String expResult = "textscrollerborder";
		String result = log.toString();
		assertEquals(expResult, result);
	}
}
