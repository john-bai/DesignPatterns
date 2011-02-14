/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author jtherrell
 */
abstract class Window {
	private WindowImp implementation;
	private Rectangle boundingBox;

	public void drawText() {
		implementation.drawText();
	}

	public void drawRect() {
		Point p1 = boundingBox.getLocation();
		Point p2 = new Point(p1.x, p1.y + boundingBox.height);
		Point p3 = new Point(p1.x + boundingBox.width, p1.y + boundingBox.height);
		Point p4 = new Point(p1.x + boundingBox.width, p1.y);
		implementation.drawLine(p1, p2);
		implementation.drawLine(p2,p3);
		implementation.drawLine(p3,p4);
		implementation.drawLine(p4,p1);
	}
}

class IconWindow extends Window {
	public void draw() {
		drawRect();
		drawText();
	}
}

class TransientWindow extends Window {
	public void draw() {
		drawRect();
	}
}

abstract class WindowImp {
	abstract public void drawText();
	abstract public void drawLine(Point p1, Point p2);
}

class XWindowImp extends WindowImp {
	public void drawText() {}
	public void drawLine(Point p1, Point p2) {}
}

class YWindowImp extends WindowImp {
	public void drawText() {}
	public void drawLine(Point p1, Point p2) {}
}