/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

/**
 *
 * @author jtherrell
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Singleton var1 = Singleton.getInstance();
		Singleton var2 = Singleton.getInstance();
		System.out.println("var1 and var2 both refer to one single instance of the Singleton class");
		var1.addToFoo(1);
		System.out.println("var1 added 1 to foo...");
		var2.addToFoo(10);
		System.out.println("var2 added 10 to foo...");
		System.out.println("var1.getFoo() returns: " + var1.getFoo());
		System.out.println("var2.getFoo() returns: " + var2.getFoo());

    }

}
