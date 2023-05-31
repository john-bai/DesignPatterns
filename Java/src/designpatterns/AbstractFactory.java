/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

/**
 *
 * @author jtherrell
 */
abstract class MazeFactory {
	abstract public Maze makeMaze();
    abstract public Wall makeWall();
    abstract public Room makeRoom(int n);
    abstract public Door makeDoor(Room r1, Room r2);
}
//why making an abstract class for the factory classes that shall implement it when you have only one factory class? 
//And even if we take the abstract class into consideration, why wouldn't you make an interface so that it would be final and abstract at the same time.
//Since we will not be changing the values of anything related to that class for the reason that we will not make an object from it.
class BombedMazeFactory extends MazeFactory {
	private static BombedMazeFactory s_instance;

	public Maze makeMaze()
        { return new BombedMaze(); }
    public Wall makeWall()
        { return new BombedWall(); }
    public Room makeRoom(int n)
        { return new BombedRoom(n); }
    public Door makeDoor(Room r1, Room r2)
        { return new BombedDoor(r1, r2); }
	public static BombedMazeFactory GetInstance() {
		if (s_instance == null)
			s_instance = new BombedMazeFactory();
		return s_instance;
	}
}

abstract class Maze {}
class BombedMaze extends Maze{}

class Wall {}
class BombedWall extends Wall{}

class Room {
	int roomNumber;
	public Room(int n) { 
		roomNumber = n;
	}
}
class BombedRoom extends Room {
	public BombedRoom(int n) {
		super(n);
	}
}

class Door {
	Room r1, r2;
	public Door(Room r1, Room r2) {
		this.r1 = r1;
		this.r2 = r2;
	}
}

class BombedDoor extends Door {
	public BombedDoor(Room r1, Room r2) {
		super(r1, r2);
	}
}
