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
public class BuilderTest {

	@Test
	public void testSomeMethod() {
		String testString = "hello world!";
		ConcreteBuilderA builder = new ConcreteBuilderA();
		Director director = new Director(builder);
		director.convert(testString);
		BuildProduct finalProduct = builder.getProduct();

		String expResult = "HELLO WORLD!";
		assertEquals(expResult, finalProduct.toString());
	}

	@Test
	public void testSomeMethod2() {
		String testString = "hello world!";
		ConcreteBuilderB builder = new ConcreteBuilderB();
		Director director = new Director(builder);
		director.convert(testString);
		BuildProduct finalProduct = builder.getProduct();

		String expResult = "HeLlO WoRlD!";
		assertEquals(expResult, finalProduct.toString());
	}

}