/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

/**
 *
 * @author jtherrell
 */
class House implements Cloneable {
	private int numOfDoors;
	private int numOfWindows;
	private int numOfStories;

	public House(int doorsNum, int windowsNum, int storiesNum) {
		numOfDoors = doorsNum;
		numOfWindows = windowsNum;
		numOfStories = storiesNum;
	}
	public void numOfDoors(int num) {
		numOfDoors = num;
	}
	public void numOfWindows(int num) {
		numOfWindows = num;
	}
	public void numOfStories(int num) {
		numOfStories = num;
	}

	@Override
	protected House clone() {
		return new House(numOfDoors, numOfWindows, numOfStories);
	}
}