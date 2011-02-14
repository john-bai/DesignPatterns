/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

/**
 *
 * @author jtherrell
 */
public class Singleton
{
	private static Singleton s_instance;
	private int foo;

	private Singleton() {
		foo = 0;
	}

	public static Singleton getInstance() {
		if (s_instance == null) {
			s_instance = new Singleton();
		}
		return s_instance;
	}

	public void addToFoo(int num) {
		foo += num;
	}

	public int getFoo() {
		return foo;
	}
}
