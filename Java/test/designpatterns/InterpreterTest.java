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
public class InterpreterTest {

    public InterpreterTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
		BooleanExp expression;
		Context context = new Context();

		VariableExp x = new VariableExp("X");
		VariableExp y = new VariableExp("Y");

		expression = new OrExp(
			new AndExp(new Constant(true), x),
			new AndExp(y, new NotExp(x)));

		context.assign(x, false);
		context.assign(y, true);

		boolean result = expression.evaluate(context);
		assertTrue(result);
	}

}