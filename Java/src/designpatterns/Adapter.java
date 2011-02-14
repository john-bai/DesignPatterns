package designpatterns;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Dimension;

class TextShapeAdapter
{
	private TextView text;

	public TextShapeAdapter(TextView text) {
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

class TextView
{
	private Point origin;
	private Dimension dimension;
	
	public TextView() {
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