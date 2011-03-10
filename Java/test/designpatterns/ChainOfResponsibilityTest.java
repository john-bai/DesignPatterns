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
public class ChainOfResponsibilityTest {
	final int PRINT_TOPIC = 1;
	final int PAPER_ORIENTATION_TOPIC = 2;
	final int APPLICATION_TOPIC = 3;

	private HelpApplication application;
	private HelpDialog dialog;
	private HelpButton button;

	private Log log;

    public ChainOfResponsibilityTest() {
		log = new Log();
		HelpHandler.log = log;
		application = new HelpApplication(APPLICATION_TOPIC);
		dialog = new HelpDialog(application, PRINT_TOPIC);
		button = new HelpButton(dialog, PAPER_ORIENTATION_TOPIC);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testExpectedButtonHandle() {
		button.handleHelp(PAPER_ORIENTATION_TOPIC);
		String expResult = "In HelpButton...Button helped!";
		String result = log.toString();
		assertEquals(expResult, result);
	}

	@Test
    public void testExpectedDialogHandle() {
		button.handleHelp(PRINT_TOPIC);
		String expResult = "In HelpButton...In HelpHandler..." +
						   "In HelpDialog...Dialog helped!";
		String result = log.toString();
		assertEquals(expResult, result);
	}

	@Test
    public void testExpectedApplicationHandle() {
		button.handleHelp(APPLICATION_TOPIC);
		String expResult = "In HelpButton...In HelpHandler..." +
						   "In HelpDialog...In HelpHandler..." +
						   "In HelpApplication...Application helped!";
		String result = log.toString();
		assertEquals(expResult, result);
	}
}