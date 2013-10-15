package u2013_05_28;

import java.util.Iterator;

public class BeispielIteratorJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Iterable<Integer> nats = new Iterable<Integer>() {
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					int s = 0;

					public Integer next() {
						int res = s;
						s++;
						return res;
					}

					public boolean hasNext() {
						return true;
					}

					@Override
					public void remove() {
						// TODO Auto-generated method stub

					}
				};
			}
		};
		for (int x : nats) {
			System.out.println(x);
		}

	}

	static Iterable<Integer> range(int start, int count) {
		return null;

	}

}
