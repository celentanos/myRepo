package aufgabe1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Studentenverwaltung {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student>liste = new ArrayList<Student>();
		
		Map <String, Integer> hm = new HashMap<String, Integer>();
	}
	public static void erzeugeListe(ArrayList<Student> liste){
		liste.add(new Student("Alex", "Meier", 1912, 'm', 12345, "IMN"));
		liste.add(new Student("Apfel", "Baum", 1922, 'm', 12346, "IMN"));
		liste.add(new Student("Max", "Meier", 1934, 'm', 12347, "BAU"));
		liste.add(new Student("Andre", "Meier", 1945, 'w', 12348, "BAU"));
		liste.add(new Student("Tino", "Schulz", 1956, 'm', 12349, "IMN"));
		liste.add(new Student("Mihael", "Meier", 1967, 'm', 12350, "MED"));
		liste.add(new Student("Andreas", "Meier", 1782, 'w', 12351, "MED"));
		liste.add(new Student("Chris", "Rohth", 1989, 'm', 12352, "BAU"));
		liste.add(new Student("Philipp", "Eling", 1998, 'm', 12353, "MED"));
		liste.add(new Student("Ricardo", "Schade", 1342, 'm', 12354, "IMN"));
	}
}
