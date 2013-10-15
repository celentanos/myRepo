package IteratorForN;

import java.util.Iterator;

public class IterN implements Iterator<Integer>{

	private Integer state = 0;
	
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Integer next() {
		return ++state;
	}

	@Override
	public void remove() {
		--state;
	}

}
