/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

/**
 *
 * @author jtherrell
 */
abstract class VisualComponent {
	abstract public void draw();
}

class TextView extends VisualComponent {
	public void draw(){}
}

abstract class Decorator extends VisualComponent {
	private VisualComponent component;

	public Decorator(VisualComponent component) {
		this.component = component;
	}

	public void draw() {
		component.draw();
	}
}

class ScrollDecorator extends Decorator {

	public ScrollDecorator(VisualComponent component) {
		super(component);
	}

	@Override
	public void draw() {
		super.draw();
		drawScroller();
	}

	private void drawScroller() {}
}

class BorderDecorator extends Decorator {

	public BorderDecorator(VisualComponent component) {
		super(component);
	}

	@Override
	public void draw() {
		super.draw();
		drawBorder();
	}

	private void drawBorder() {}
}


