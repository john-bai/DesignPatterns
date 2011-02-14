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
	abstract public void draw();
	abstract public void add(Graphic g);
	abstract public void remove(Graphic g);
	abstract public Graphic getChild(int index);
}

class Picture extends Graphic {
	private ArrayList<Graphic> children;

	public Picture() {
		children = new ArrayList<Graphic>();
	}

	public void draw() {
		for (int i = 0; i < children.size(); i++)
			children.get(i).draw();
	}
	public void add(Graphic g) {
		children.add(g);
	}
	public void remove(Graphic g) {
		children.remove(g);
	}
	public Graphic getChild(int index) {return null;}
}

class Line extends Graphic {
	public void draw(){}
	public void add(Graphic g){} // do nothing
	public void remove(Graphic g){} // do nothing
	public Graphic getChild(int index){return null;}
}

class Rectangle extends Graphic {
	public void draw(){}
	public void add(Graphic g){} // do nothing
	public void remove(Graphic g){} // do nothing
	public Graphic getChild(int index){return null;}
}

class Text extends Graphic {
	public void draw(){}
	public void add(Graphic g){} // do nothing
	public void remove(Graphic g){} // do nothing
	public Graphic getChild(int index){return null;}
}