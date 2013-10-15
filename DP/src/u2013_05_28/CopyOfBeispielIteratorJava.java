package u2013_05_28;

import java.util.Iterator;

public class CopyOfBeispielIteratorJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int x : range(2, 5)) {
			System.out.println(x);
		}
	}

	private static Iterable<Integer> range(final int start, final int count) {
		return new Iterable<Integer>() {

			@Override
			public Iterator<Integer> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<Integer>() {

					@Override
					public void remove() {
						// TODO Auto-generated method stub

					}

					private int state = 0;

					@Override
					public Integer next() {
						int result = start + state;
						this.state++;
						return result;
					}

					@Override
					public boolean hasNext() {
						return this.state < count;
					}
				};
			}
		};
	}

}
