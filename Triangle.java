
public class Triangle extends Shapes implements Shape {
	
	Integer side1;
	Integer side2;
	Integer side3;
	

	public String toString() {
		return (name + " (" + String.valueOf(id) + ")");
	}
	
	@Override
	public String getKind() {
		return (name);
	}

	@Override
	public String getDetailString() {
		return ("Name: " + name + "\nID: " + id + "\nColor: " + color + "\nArea: " + String.valueOf(side1 * side2 * side3 / 2) + "\nPerimeter: "
					+ String.valueOf(side1 + side2 + side3) +"\nSide Length 1: " + String.valueOf(side1) + "\nSide Length 2:" + String.valueOf(side2)
					+ "\nSide Length 3: " + String.valueOf(side3));
	}

	@Override
	public int getID() {
		return id;
	}
}
