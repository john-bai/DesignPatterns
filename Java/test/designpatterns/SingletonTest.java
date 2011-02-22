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
public class SingletonTest {

	/**
	 * Test of getInstance method, of class Singleton.
	 */ @Test
	public void testGetInstance() {
		Singleton expResult = Singleton.getInstance();
		Singleton result = Singleton.getInstance();
		assertEquals(expResult, result);
	}

	/**
	 * Test of addToFoo method, of class Singleton.
	 */ @Test
	public void testAddToFoo() {
		int num = 10;
		Singleton instance = Singleton.getInstance();
		int expResult = instance.getFoo() + num;
		instance.addToFoo(num);
		int result = instance.getFoo();
		assertEquals(expResult, result);
	}
}