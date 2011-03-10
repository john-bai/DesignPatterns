/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jtherrell
 */
public class MementoTest {

    public MementoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testMoveExecuteOnce() {
		Point delta = new Point(5,5);
		Graphix g = new Graphix(new Point(100,100));
		MoveCommand move = new MoveCommand(g);
		move.execute(delta);

		Point expResult = new Point(105,105);
		Point result = g.position();
		assertEquals(expResult, result);
	}

	@Test
    public void testMoveExecuteMany() {
		Point delta = new Point(5,5);
		Graphix g = new Graphix(new Point(100,100));
		MoveCommand move = new MoveCommand(g);
		for(int i = 0; i < 10; i++)
			move.execute(delta);

		Point expResult = new Point(150,150);
		Point result = g.position();
		assertEquals(expResult, result);
	}

	@Test
    public void testMoveUndoOnce() {
		Point delta = new Point(5,5);
		Graphix g = new Graphix(new Point(100,100));
		MoveCommand move = new MoveCommand(g);
		move.execute(delta);
		move.unexecute();
		Point expResult = new Point(100,100);
		Point result = g.position();
		assertEquals(expResult, result);
	}

	@Test
    public void testMoveUndoMany() {
		Point delta = new Point(5,5);
		Graphix g = new Graphix(new Point(100,100));
		MoveCommand move = new MoveCommand(g);
		for(int i = 0; i < 10; i++)
			move.execute(delta);
		for(int i = 0; i < 10; i++) {
			move.unexecute();
		}
		Point expResult = new Point(100,100);
		Point result = g.position();
		assertEquals(expResult, result);
	}

}