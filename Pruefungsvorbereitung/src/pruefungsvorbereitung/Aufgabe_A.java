package pruefungsvorbereitung;

import java.util.ArrayList;
import java.util.Collection;

public class Aufgabe_A {

	public static void main(String[] args) {
		ArrayList<String> c = new ArrayList<String>();
		c.add("12");
		c.add("13");

		System.out.println(m(c));

	}

	private static Integer f(String a) {
		return ((new Integer(a)) * 3);
	}

	// S - Integer
	// R - String
	private static Collection<Integer> m(Collection<String> c) {

		ArrayList<Integer> d = new ArrayList<Integer>();

		for (String a : c) {
			d.add(f(a));
		}

		return d;
	}
}