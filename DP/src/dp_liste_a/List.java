package dp_liste_a;

public class List <A> implements ListInterface<A>{
	private final A element;
	private final List <A> restElemente;
	
	public List(A element, List<A> restElemente) {
		this.element = element;
		this.restElemente = restElemente;
	}

	public A getElement() {
		return element;
	}

	public List<A> getRestElemente() {
		return restElemente;
	}

	@Override
	public A getElement(int i) {
		if(i == 0){
			return this.element;
		}else{
			if(this.element != null){
				return	this.restElemente.getElement(i - 1);
			}else{
				return null;
			}
		}
	}

	@Override
	public void addElement(A element) {
	}

	@Override
	public void removeElement(int i) {
	}
	
}
