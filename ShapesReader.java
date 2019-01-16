import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class ShapesReader extends DefaultHandler {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private String chars;
	public ArrayList<Shape> getShapes() { return shapes; }
	
	// startElement here will assign all the variables the proper items and assign the objects to the arraylist
	public void startElement(String namespaceURI, String localname, String gname, Attributes atts) {
		chars = "";
		if(localname.equals("circle")) {
			Circle s = new Circle();
			s.id = Integer.parseInt(atts.getValue("id"));
			s.color = atts.getValue("color");
			s.radius = Integer.parseInt(atts.getValue("radius"));
			s.name = "Circle";
			shapes.add(s);
		}
		else if (localname.equals("square")) {
			Square s = new Square();
			s.id = Integer.parseInt(atts.getValue("id"));
			s.color = atts.getValue("color");
			s.side = Integer.parseInt(atts.getValue("side"));
			s.name = "Square";
			shapes.add(s);
		}
		else if (localname.equals("triangle")) {
			Triangle t = new Triangle();
			t.id = Integer.parseInt(atts.getValue("id"));
			t.color = atts.getValue("color");
			t.side1 = Integer.parseInt(atts.getValue("side1"));
			t.side2 = Integer.parseInt(atts.getValue("side2"));
			t.side3 = Integer.parseInt(atts.getValue("side3"));
			t.name = "Triangle";
			shapes.add(t);
		}
		else if (localname.equals("rectangle")) {
			Rectangle r = new Rectangle();
			r.id = Integer.parseInt(atts.getValue("id"));
			r.color = atts.getValue("color");
			r.length = Integer.parseInt(atts.getValue("length"));
			r.width = Integer.parseInt(atts.getValue("width"));
			r.name = "Rectangle";
			shapes.add(r);
		}
	}
	
	public void characters (char[] ch, int start, int length) {
		if (chars == null)
			chars = "";
		chars = chars + new String(ch, start, length);
	}
	
	// No need to run this function that I have found
	public void endElement(String uri, String localName, String gName) {	
	}
}
