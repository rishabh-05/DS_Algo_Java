import java.util.ArrayList;

public class HeapGenericRevision<T extends Comparable<T>> {

	private ArrayList<T> data = new ArrayList<>();

	public int size() {
		return data.size();
	}
	
	public boolean isEmpty() {
		return this.data.size() == 0;
	}

	public void add(T item) {
		data.add(item);

		upheapify(data.size() - 1);
	}

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;

		if (data.get(ci).compareTo(data.get(pi)) < 0) {
			swap(pi, ci);
			upheapify(pi);
		}
	}

	private void swap(int i, int j) {
		T idata = data.get(i);
		T jdata = data.get(j);

		data.set(i, jdata);
		data.set(j, idata);
	}

	public T remove() {
		// can only remove topmost element form heap.

		swap(0, data.size() - 1);
		T item = data.remove(data.size() - 1);
		downheapify(0);
		return item;
	}
	


	private void downheapify(int pi) {
		int li = 2 * pi + 1;
		int ri = 2 * pi + 2;

		int mini = pi;

		if (li < data.size() && data.get(li).compareTo(data.get(mini)) < 0) {
			mini = li;
		}
		if (ri < data.size() && data.get(ri).compareTo(data.get(mini)) < 0) {
			mini = ri;
		}
		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}

	}

	public void display() {
		System.out.println(data);
	}

}
