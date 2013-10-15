package u2013_04_11;

public class Leaf<K> implements Tree<K>{
	public final K key;

	public Leaf(K key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Leaf [key=" + key + "]";
	}

	@Override
	public int size() {
		return 1;
	}
	
	

}
