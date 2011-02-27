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
public class FacadeTest {
	/**
	 * Test of getInstance method, of class Singleton.
	 */ @Test
	public void testFacade() {
		Log log = new Log();
		Facade facade = new Facade();
		facade.doSomething(log);
		String expResult = "ABCD";
		String result = log.toString();
		assertEquals(expResult, result);
	}
}
