
public class Square extends Shapes implements Shape {
	
	Integer side;
	
	public String toString() {
		return (name + " (" + String.valueOf(id) + ")");
	}
	
	@Override
	public String getKind() {
		return (name);
	}

	@Override
	public String getDetailString() {
		return ("Name: " + name + "\nID: " + id + "\nColor: " + color + "\nArea: " + String.valueOf(side * side) + "\nPerimeter: "
					+ String.valueOf(side * 4) +"\nSide Length: " + String.valueOf(side));
	}

	@Override
	public int getID() {
		return id;
	}
}

