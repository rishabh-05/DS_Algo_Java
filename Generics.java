import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Generics {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

//		Car[] cars = new Car[5];
//		cars[0] = new Car(50, 100, "White");
//		cars[1] = new Car(60, 200, "Red");
//		cars[2] = new Car(90, 300, "Black");
//		cars[3] = new Car(40, 400, "Grey");
//		cars[4] = new Car(70, 500, "Green");
//
//		display(cars);
//		bubblesort(cars, new SpeedComparator());
//		display(cars);
//
//		bubblesort(cars, new PriceComparator());
//		display(cars);
//		
//		bubblesort(cars, new ColorComparator());
//		display(cars);
		
		LLGeneric<ArrayList<Integer>> list = new LLGeneric<>();
		
		list.addlast(new ArrayList<>());
		list.getAt(0).add(10);
		list.getAt(0).add(20);
		list.getAt(0).add(30);
		list.addlast(new ArrayList<>());
		list.getAt(1).add(11);
		list.getAt(1).add(12);
		list.getAt(1).add(13);
		list.getAt(1).add(14);
		list.addlast(new ArrayList<>());
		list.display();
		
		System.out.println("------------");
		System.out.println(list.getAt(2));
		


	}
	

	public static <T> void display(T[] arr) {
		System.out.println("------------");
		for (T val : arr) {
			System.out.println(val);
		}
		System.out.println("------------");
	}

	public static <T extends Comparable<T>> void bubblesort(T[] arr) {

		int len = arr.length;

		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {

				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static <T> void bubblesort(T[] arr, Comparator<T> comp) {

		int len = arr.length;

		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {

				if (comp.compare(arr[j], arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
