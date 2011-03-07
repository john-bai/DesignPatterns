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
public class TemplateMethodTest {

    public TemplateMethodTest() {
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
    public void testTemplateMethod() {
		Log log = new Log();
		UnixWordProcessorApplication app = new UnixWordProcessorApplication(log);
		app.openDocument("helloworld.txt");
		String expResult = "TEMPLATE METHOD START:UNIX canOpen:UNIX "
				+ "doCreate:UNIX aboutTo:TEMPLATE METHOD END";
		String result = log.toString();
		System.out.print(result);
		assertEquals(expResult, result);
	}

}