package test;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Person c  = new Person(111, "");
		
		Person a  = new Person(12, "");
		Person b  = new Person(11, "");
		System.out.println(Person.anzahl);
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for (int i : list) {
			System.out.println(i*i);
		}
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			int i = it.next();
			System.out.println(i*i);
		}
	}
}
