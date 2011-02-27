package designpatterns;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Dimension;

interface GUIComponent {
	public Rectangle boundingBox();
}

class TextShapeAdapter implements GUIComponent
{
	private TextBox text;

	public TextShapeAdapter() {
		text = new TextBox();
	}

	public Rectangle boundingBox() {
		return new Rectangle(text.getOrigin(), text.getExtent());
	}
}

class Shape implements GUIComponent
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