
public class Circle extends Shapes implements Shape {
	
	Integer radius;
	
	Circle(){
	}

	public String toString() {
		return (name + " (" + String.valueOf(id) + ")");
	}
	
	@Override
	public String getKind() {
		return (name);
	}

	@Override
	public String getDetailString() {
		return ("Name: " + name + "\nID: " + id + "\nColor: " + color + "\nArea: " + String.valueOf(3.14 * radius * radius) + "\nCircumference: "
					+ String.valueOf(3.14 * radius * 2) +"\nRadius: " + String.valueOf(radius));
	}

	@Override
	public int getID() {
		return id;
	}
}
