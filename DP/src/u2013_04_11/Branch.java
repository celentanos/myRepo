package u2013_04_11;

public class Branch<K> implements Tree<K>{
	
	private final Tree<K> left, right;
	
	public Branch(Tree<K> left, Tree<K> right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "Branch [left=" + left + ", right=" + right + "]";
	}

	@Override
	public int size() {
		return 1+left.size() + right.size();
	}
}
