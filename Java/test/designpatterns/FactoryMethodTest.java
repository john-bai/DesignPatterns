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
public class FactoryMethodTest {

	/**
	 * Test of getInstance method, of class Singleton.
	 */ @Test
	public void testFactoryMethod() {
		 Log log = new Log();
		 Creator myCreator = new MyCreator();
		 myCreator.newProduct(log);
		 String expResult = "Created new MyProduct!";
		 String result = log.toString();
		 assertEquals(expResult, result);
	}
}
