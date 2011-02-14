/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

/**
 *
 * @author jtherrell
 */
abstract class Graphic {
	abstract public void draw();
	abstract public void getExtent();
	abstract public void store();
	abstract public void load();
}

class ImageProxy extends Graphic {
	private Image image;

	public void draw(){
		if (image != null)
			image.draw();
	}
	public void getExtent(){}
	public void store(){}
	public void load(){}
}

class Image extends Graphic {
	private Rectangle boundingBox;

	public void draw(){}
	public void getExtent(){}
	public void store(){}
	public void load(){}
}