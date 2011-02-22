package designpatterns;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Dimension;

class TextShapeAdapter
{
	private TextBox text;

	public TextShapeAdapter(TextBox text) {
		this.text = text;
	}

	public Rectangle boundingBox() {
		return new Rectangle(text.getOrigin(), text.getExtent());
	}
}

class Shape
{
	private Rectangle boundingBox;
	
	public Shape() {
		boundingBox = new Rectangle(0,0,100,100);
	}
	public Rectangle boundingBox() {
		return boundingBox;
	}
}

class TextBox
{
	private Point origin;
	private Dimension dimension;
	
	public TextBox() {
		origin = new Point(0,0);
		dimension = new Dimension(10,10);
	}

	public Point getOrigin() {
		return origin;
	}

	public Dimension getExtent() {
		return dimension;
	}
}