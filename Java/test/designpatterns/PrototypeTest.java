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
public class PrototypeTest {

	@Test
	public void testSomeMethod() {
		House original = new House(8, 10, 2);
	    House proto = original.clone();
		assertNotSame(original, proto);
	}

}