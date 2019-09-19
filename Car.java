import java.util.Comparator;

public class Car {
	
	int speed;
	int price;
	String color;
	
	public Car(int speed, int price, String color) {
		this.speed = speed;
		this.price = price;
		this.color = color;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "S: " + this.speed + " Price: " + this.price + " Color: " + this.color;
	}

	
	

	

}
