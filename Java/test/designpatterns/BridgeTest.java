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
public class BridgeTest {

	/**
	 * Test of draw method, of class IconWindow.
	 */ @Test
	public void testIconWindowDraw() {
		 Log log = new Log();
		 IconWindow icon = new IconWindow(log);
		 icon.draw();
		 String expResult = "hellohellohellohelloworld";
		 String result = log.toString();
		 assertEquals(expResult, result);
	}

	 /**
	 * Test of draw method, of class TransientWindow.
	 */ @Test
	public void testTransientWindowDraw() {
		 Log log = new Log();
		 TransientWindow transWin = new TransientWindow(log);
		 transWin.draw();
		 String expResult = "wowwowwowwow";
		 String result = log.toString();
		 assertEquals(expResult, result);
	}

}