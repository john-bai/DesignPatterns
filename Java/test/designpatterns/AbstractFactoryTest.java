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
public class AbstractFactoryTest {

	/**
	 * Test of Adapter class' adherence to the GUIComponent interface.
	 */ @Test
	public void testAbstractFactory() {
		 MazeFactory factory = BombedMazeFactory.GetInstance();
		 Maze myMaze = factory.makeMaze();
		 Wall rm1_wall = factory.makeWall();
		 Room rm1 = factory.makeRoom(1);
		 Room rm2 = factory.makeRoom(2);
		 Door myDoor = factory.makeDoor(rm1, rm2);
		 assertEquals(BombedDoor.class, myDoor.getClass());
		 assertEquals(BombedWall.class, rm1_wall.getClass());
		 assertEquals(BombedRoom.class, rm1.getClass());
		 assertEquals(BombedMaze.class, myMaze.getClass());

	}
}
