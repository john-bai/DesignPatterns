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
public class CommandTest {
	/**
	 * Test of getInstance method, of class Singleton.
	 */ @Test
	public void testCommand() {
		Log log = new Log();
		Application app = new Application(log);
		Menu appMenu = new Menu();
		MenuItem open = new MenuItem("Open", new OpenCommand(app));
		MenuItem paste = new MenuItem("Paste", new PasteCommand(app));
		appMenu.addMenuItem(open);
		appMenu.addMenuItem(paste);

		// Now we'll simulate the clicking of both MenuItems...
		open.clicked();
		paste.clicked();

		String expResult = "./untitled.txt opened...Paste to ./untitled.txt";
		String result = log.toString();
		System.out.print(result);

		assertEquals(expResult, result);
	}
}
