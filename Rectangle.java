
public class Rectangle extends Shapes implements Shape{
	
	Integer length;
	Integer width;
	
	public String toString() {
		return (name + " (" + String.valueOf(id) + ")");
	}
	
	@Override
	public String getKind() {
		return (name);
	}

	@Override
	public String getDetailString() {
		return ("Name: " + name + "\nID: " + id + "\nColor: " + color + "\nArea: " + String.valueOf(length + width) + "\nPerimeter: "
					+ String.valueOf(width * 2 + length *2) +"\nWidth: " + String.valueOf(width) + "\nLength:" + String.valueOf(length));
	}

	@Override
	public int getID() {
		return id;
	}
}
