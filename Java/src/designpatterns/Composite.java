/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import java.util.ArrayList;

/**
 *
 * @author jtherrell
 */
abstract class Graphic {
	abstract public void draw(Log log);
	abstract public boolean add(Graphic g);
	abstract public boolean remove(Graphic g);
	abstract public Graphic getChild(int index);
}

class Picture extends Graphic {
	private ArrayList<Graphic> children;

	public Picture() {
		children = new ArrayList<Graphic>();
	}

	public void draw(Log log) {
		for (int i = 0; i < children.size(); i++)
			children.get(i).draw(log);
	}
	public boolean add(Graphic g) {
		children.add(g);
		return children.contains(g);
	}
	public boolean remove(Graphic g) {
		children.remove(g);
		return !children.contains(g);
	}
	public Graphic getChild(int index) {
		return index < children.size() ? children.get(index) : null;
	}
}

class Line extends Graphic {
	public void draw(Log log) {log.append("Line");}
	public boolean add(Graphic g) { return false; } // do nothing
	public boolean remove(Graphic g) { return false; } // do nothing
	public Graphic getChild(int index) {return null;}
}

class Rectangle extends Graphic {
	public void draw(Log log) {log.append("Rect");}
	public boolean add(Graphic g) { return false; } // do nothing
	public boolean remove(Graphic g) { return false; } // do nothing
	public Graphic getChild(int index) {return null;}
}

class Text extends Graphic {
	public void draw(Log log) {log.append("Text");}
	public boolean add(Graphic g) { return false; } // do nothing
	public boolean remove(Graphic g) { return false; } // do nothing
	public Graphic getChild(int index) {return null;}
}