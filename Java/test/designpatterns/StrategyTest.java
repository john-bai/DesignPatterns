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
public class StrategyTest {
	private Log log;

    public StrategyTest() {
		log = new Log();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testSimpleCompositor() {
		Composition composition = new Composition(new SimpleCompositor());
		composition.repair(log);
		String expResult = "Performing SimpleCompositor algorithm...";
		String result = log.toString();
		assertEquals(expResult, result);
	}

	@Test
    public void testTeXCompositor() {
		Composition composition = new Composition(new TeXCompositor());
		composition.repair(log);
		String expResult = "Performing TeXCompositor algorithm...";
		String result = log.toString();
		assertEquals(expResult, result);
	}

	@Test
    public void testArrayCompositor() {
		Composition composition = new Composition(new ArrayCompositor());
		composition.repair(log);
		String expResult = "Performing ArrayCompositor algorithm...";
		String result = log.toString();
		assertEquals(expResult, result);
	}

}