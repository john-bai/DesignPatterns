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
	protected WindowImp implementation;
	protected Log log;
	protected Rectangle boundingBox;

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
	public IconWindow(Log l) {
		log = l;
		implementation = WindowImp.getWindowImp(0);
		implementation.attachLog(log);
		boundingBox = new Rectangle(10,10);
	}
	public void draw() {
		drawRect();
		drawText();
	}
}

class TransientWindow extends Window {
	public TransientWindow(Log l) {
		log = l;
		implementation = WindowImp.getWindowImp(1);
		implementation.attachLog(log);
		boundingBox = new Rectangle(10,10);
	}
	public void draw() {
		drawRect();
	}
}

abstract class WindowImp {
	protected Log log;
	abstract public void drawText();
	abstract public void drawLine(Point p1, Point p2);
	public void attachLog(Log log) {
		this.log = log;
	}
	static WindowImp getWindowImp(int context) {
		return context < 1 ? new XWindowImp() : new YWindowImp();
	}
}

class XWindowImp extends WindowImp {
	public void drawText() { log.append("world"); }
	public void drawLine(Point p1, Point p2) { log.append("hello"); }
}

class YWindowImp extends WindowImp {
	public void drawText() { log.append("neato"); }
	public void drawLine(Point p1, Point p2) { log.append("wow"); }
}

class Log {
	private StringBuffer log;
	public Log() { 
		log = new StringBuffer();
	}
	public void append(char c) {
		log.append(c);
	}
	public void append(String s) {
		log.append(s);
	}
	@Override
	public String toString() {
		return log.toString();
	}
}