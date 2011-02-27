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
public class AdapterTest {

	/**
	 * Test of Adapter class' adherence to the GUIComponent interface.
	 */ @Test
	public void testAdherenceToGUIComponentInterface() {
		 GUIComponent comp = new TextShapeAdapter();
		 String expResult = "java.awt.Rectangle[x=0,y=0,width=10,height=10]";
		 String result = comp.boundingBox().toString();
		 assertEquals(expResult, result);
	}
}
