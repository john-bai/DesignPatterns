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
public class ProxyTest {

	/**
	 * Test of getInstance method, of class Singleton.
	 */ @Test
	public void testProxyLazyLoad() {
		ImageProxy proxy = new ImageProxy("example.jpg");
		boolean expResult = false;
		boolean result = proxy.isImageLoaded();
		assertEquals(expResult, result);
	}

	 /**
	 * Test of getInstance method, of class Singleton.
	 */ @Test
	public void testProxyLoadOnDraw() {
		ImageProxy proxy = new ImageProxy("example.jpg");
		proxy.draw();
		boolean expResult = true;
		boolean result = proxy.isImageLoaded();
		assertEquals(expResult, result);
	}

}
