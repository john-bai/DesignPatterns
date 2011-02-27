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
public class CompositeTest {

	/**
	 * Test
	 */ @Test
    public void testPictureAddingLine() {
		 Graphic compositeObj = new Picture();
		 boolean result = compositeObj.add(new Line());
		 boolean expResult = true;
		 assertEquals(expResult, result);
	}

	/**
	 * Test
	 */ @Test
	public void testPictureAddingRectangle() {
		 Graphic compositeObj = new Picture();
		 boolean result = compositeObj.add(new Rectangle());
		 boolean expResult = true;
		 assertEquals(expResult, result);
	}

	/**
	 * Test
	 */ @Test
	public void testPictureAddingText() {
		 Graphic compositeObj = new Picture();
		 boolean result = compositeObj.add(new Text());
		 boolean expResult = true;
		 assertEquals(expResult, result);
	}

	/**
	 * Test
	 */ @Test
	public void testPictureRemoval() {
		 Graphic compositeObj = new Picture();
		 Graphic textObj = new Text();
		 compositeObj.add(textObj);
		 boolean result = compositeObj.remove(textObj);
		 boolean expResult = true;
		 assertEquals(expResult, result);
	}

	/**
	 * Test
	 */ @Test
	public void testPictureGetChild() {
		 Graphic compositeObj = new Picture();
		 Graphic textObj = new Text();
		 compositeObj.add(textObj);
		 Graphic returnedTextObj = compositeObj.getChild(0);
		 assertEquals(textObj, returnedTextObj);
	}

	/**
	 * Test
	 */ @Test
	public void testPictureDraw() {
		 Log log = new Log();
		 Graphic compositeObj = new Picture();
		 // We'll add a Picture in the Picture along with a standalone Graphic
		 // such as Line.
		 Graphic threeRectanglePicture = new Picture();
		 threeRectanglePicture.add(new Rectangle());
		 threeRectanglePicture.add(new Rectangle());
		 threeRectanglePicture.add(new Rectangle());
		 compositeObj.add(threeRectanglePicture);
		 compositeObj.add(new Line());
		 compositeObj.add(new Text());
		 compositeObj.draw(log);
		 String expResult = "RectRectRectLineText";
		 String result = log.toString();
		 assertEquals(expResult, result);
	}

}
