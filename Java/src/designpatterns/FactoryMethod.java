/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

/**
 *
 * @author jtherrell
 */
abstract class Creator {
	public Product newProduct(Log log) {
		return createProduct(log);
	}
	abstract protected Product createProduct(Log log);

}

class MyCreator extends Creator {
	protected Product createProduct(Log log) {
		log.append("Created new MyProduct!");
		return new MyProduct();
	}
}

class Product {}
class MyProduct extends Product {}
