package kw50;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class MainKw50 {

	/**
	 * @param args
	 */
	//List<Integer> list1 = new Stack<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = new LinkedList<Integer>();
		list1.add(0);
		list1.add(23);
		list1.add(4);
		list1.add(23);
		list1.add(12);
		
		final Iterator<Integer> it = list1.iterator();
		while(it.hasNext()){
			final Integer x = it.next();
			
			System.out.println(x);
		}
	}

}
