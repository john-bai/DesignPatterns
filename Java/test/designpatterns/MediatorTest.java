/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jtherrell
 */
public class MediatorTest {

    public MediatorTest() {
    }

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
	public void testMediator() {
		Log log = new Log();
		FontDialogMediator mediator = new FontDialogMediator(log);
		Widget[] widgets = mediator.getWidgets();
		//Simulate mouse events triggering action on a few widgets
		for(int i = 0; i < widgets.length; i++) {
			widgets[i].handleMouse(new MouseEvent());
		}
		String expResult = "Button changed OK Button changed CANCEL ListBox " +
				"changed updating fontName field EntryField changed ";
		String result = log.toString();
		assertEquals(expResult, result);
	}

}