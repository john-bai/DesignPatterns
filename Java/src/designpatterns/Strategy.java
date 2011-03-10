/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

/**
 *
 * @author jtherrell
 */
class Composition {
	private Compositor compositor;

	public Composition(Compositor compositor) {
		this.compositor = compositor;
	}

	public void repair(Log log) {
		compositor.compose(log);
	}

}

abstract class Compositor {
	abstract public void compose (Log log);
}

class SimpleCompositor extends Compositor {

	@Override
	public void compose(Log log) {
		log.append("Performing SimpleCompositor algorithm...");
	}
}

class TeXCompositor extends Compositor {
	public TeXCompositor() {

	}

	@Override
	public void compose(Log log) {
		log.append("Performing TeXCompositor algorithm...");
	}
}

class ArrayCompositor extends Compositor {
	public ArrayCompositor() {

	}

	@Override
	public void compose(Log log) {
		log.append("Performing ArrayCompositor algorithm...");
	}
}