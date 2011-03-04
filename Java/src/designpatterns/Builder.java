/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;
/**
 *
 * @author jtherrell
 */

class Director {
	private Builder builder;
	public Director(Builder b) {
		builder = b;
	}
	public void convert(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (i % 2 == 0)
				builder.buildPartA(string.charAt(i));
			else
				builder.buildPartB(string.charAt(i));
		}
	}
}

abstract class Builder {
	protected BuildProduct product;
	abstract public void buildPartA(char c);
	abstract public void buildPartB(char c);
}

class ConcreteBuilderA extends Builder {
	public ConcreteBuilderA() {
		product = new BuildProduct();
	}
	public void buildPartA(char c) {
		buildPartB(c);
	}
	public void buildPartB(char c) {
		product.append(Character.toUpperCase(c));
	}
	public BuildProduct getProduct() {
		return product;
	}
}

class ConcreteBuilderB extends Builder {
	public ConcreteBuilderB() {
		product = new BuildProduct();
	}
	public void buildPartA(char c) {
		product.append(Character.toUpperCase(c));
	}
	public void buildPartB(char c) {
		product.append(c);
	}
	public BuildProduct getProduct() {
		return product;
	}
}

class BuildProduct {
	private Log doc;
	
	public BuildProduct() {
		doc = new Log();
	}

	public void append(char c) {
		doc.append(c);
	}

	@Override
	public String toString() {
		return doc.toString();
	}
}