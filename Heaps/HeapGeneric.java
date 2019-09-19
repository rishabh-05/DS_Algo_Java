package Heaps;

import java.util.ArrayList;

public class HeapGeneric<T extends Comparable<T>> {

	
	private ArrayList<T> data = new ArrayList<>();

	public void add(T item) {
		data.add(item);
		
			upheapify(data.size() - 1);
	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (isLarger(data.get(ci), data.get(pi)) > 0) {
			swap(ci, pi);
			upheapify(pi);
		}

	}

	private void swap(int i, int j) {

		T idata = data.get(i);
		T jdata = data.get(j);

		data.set(i, jdata);
		data.set(j, idata);
	}

	public void display() {
		System.out.println(data);
	}

	public T remove() {
		swap(0, data.size() - 1);
		T temp = data.remove(data.size() - 1);
		downheapify(0);
		return temp;
	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		if (lci < data.size() && data.get(lci).compareTo(data.get(mini)) > 0)
			mini = lci;
		if (rci < data.size() && data.get(rci).compareTo(data.get(mini)) > 0)
			mini = rci;

		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}

	}

	public boolean isEmpty() {
		return data.size() == 0;
	}

	public int size() {

		return data.size();
	}

	public T get() {
		return data.get(0);
	}

	public int isLarger(T t, T o) {
		return t.compareTo(o);
	}

	public void updatePriority(T item) {

		int idx = 0;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i) == item) {
				idx = i;
				break;
			}
		}

		upheapify(idx);
	}

}
