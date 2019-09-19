import Heaps.Car;
import Heaps.HeapGeneric;

public class ClientHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		HeapGenericRevision<Car> hp = new HeapGenericRevision<>();

		Car[] c = new Car[6];
		c[0] = new Car(10, 100, "Brown");
		c[2] = new Car(20, 200, "Brown");
		c[4] = new Car(30, 300, "Brown");
		c[1] = new Car(40, 400, "Brown");
		c[5] = new Car(50, 500, "Brown");
		c[3] = new Car(60, 600, "Brown");

//		for (Car car : c) {
//			hp.add(car);
//		}
//		hp.display();
//		
		HeapGenericRevision<Integer> hpI = new HeapGenericRevision<>();
		for (int i = 1; i <= 10; i++) {
			hpI.add(10 * i);
		}

		hpI.display();

	

//		System.out.println(hp.remove());
//		hp.display();
//
//		System.out.println(hp.remove());
//		hp.display();

	}
	
	
}
