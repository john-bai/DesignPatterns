/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;
import java.awt.Rectangle;
/**
 *
 * @author jtherrell
 */
abstract class Glyph {
	protected Rectangle extent;
	
	abstract public void draw();
	abstract public Rectangle getExtent();
}

class ImageProxy extends Glyph {
	private Image image;
	private String filename;

	public ImageProxy(String filename) {
		this.filename = filename;
		extent = null;
	}
	public void draw(){
		getImage().draw();
	}
	public Rectangle getExtent() {
		if (extent == null)
			return getImage().getExtent();
		return extent;
	}

	public boolean isImageLoaded() {
		return image != null;
	}

	private Image getImage() {
		image = new Image(filename);
		return image;
	}
}

class Image extends Glyph {
	public Image(String filename) {
		// Load the file here using the filename
		// get the extent of the loaded image and update extent
		extent = new Rectangle(0,0,100,100);
	}
	public void draw(){}
	public Rectangle getExtent(){ return extent; }
}