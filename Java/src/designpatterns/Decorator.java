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
	abstract public void draw(Log log);
}

class TextView extends VisualComponent {
	public void draw(Log log){log.append("text");}
}

abstract class Decorator extends VisualComponent {
	private VisualComponent component;

	public Decorator(VisualComponent component) {
		this.component = component;
	}

	public void draw(Log log) {
		component.draw(log);
	}
}

class ScrollDecorator extends Decorator {

	public ScrollDecorator(VisualComponent component) {
		super(component);
	}

	@Override
	public void draw(Log log) {
		super.draw(log);
		drawScroller(log);
	}

	private void drawScroller(Log log) {log.append("scroller");}
}

class BorderDecorator extends Decorator {

	public BorderDecorator(VisualComponent component) {
		super(component);
	}

	@Override
	public void draw(Log log) {
		super.draw(log);
		drawBorder(log);
	}

	private void drawBorder(Log log) {log.append("border");}
}


