/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import java.awt.Point;
import java.util.Stack;

/**
 *
 * @author jtherrell
 */
class Graphix {
	private Point position;

	public Graphix(Point position) {
		this.position = position;
	}

	public void move(Point delta) {
		position.x += delta.x;
		position.y += delta.y;
	}

	public GraphixMemento createMemento() {
		return new GraphixMemento(new Point(position.x, position.y));
	}

	public void setMemento(GraphixMemento memento) {
		position = memento.state();
	}

	public Point position() {
		return position;
	}
}

class GraphixMemento{
	private Point position;

	public GraphixMemento(Point position) {
		this.position = position;
	}

	public Point state() {
		return position;
	}
}

class MoveCommand {
	private Graphix target;
	private Stack<GraphixMemento> state;
	
	public MoveCommand (Graphix target) {
		this.target = target;
		state = new Stack<GraphixMemento>();
	}

	public void execute(Point delta) {
		
		state.push(target.createMemento());
		target.move(delta);
	}

	public void unexecute() {
		if(!state.empty())
			target.setMemento(state.pop());
	}
}


