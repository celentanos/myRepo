package aufgabe1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Studentenverwaltung {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student>liste = new ArrayList<Student>();
		/*erzeugeListe(liste);
		ausgabeListe(liste);
		Collections.sort(liste);
		ausgabeListe(liste);
		*/
		int auswahl = 0;
		boolean set;
		String neu;
		erzeugeListe(liste);
		Scanner input = new Scanner(System.in);
		int eingabe;
		do {
			printmenu();
			eingabe = input.nextInt();
			System.out.println();
			
			switch (eingabe) {
			
			case 1: {
				Collections.sort(liste);
			} break;
			
			case 2: {
				System.out.println("Bitte geben sie die Matrikelnummer ein:");
                set = false;
                auswahl = input.nextInt();
                for (Student s : liste) {
                    if (auswahl == s.getMatrikelnummer()) {
                        System.out.println("Student gefunden: "
                                + s.getVorname() + " " + s.getNachname()
                                + " " + s.getMatrikelnummer());
                        System.out.println();
                        System.out.println("Geben Sie bitte den neuen Vornamen!");
                        neu = input.next();
                        s.setVorname(neu);
                        System.out.println("Geben Sie bitte den neuen Nachnamen!");
                        neu = input.next();
                        s.setNachname(neu);
                        System.out.println("Geben Sie bitte den neuen Studiengang!");
                        neu = input.next();
                        s.setStudiengang(neu);
                        set = true;
                    }
                }
                if (set == false){
                	System.out.println("Student wurde nicht gefunden!");
                    System.out.println();
                }
			} break;
			
			case 3: {
				System.out.println("Bitte geben sie die Matrikelnummer ein:");
                set = false;
                auswahl = input.nextInt();
                Student st = null;
                for (Student s : liste) {
                    if (auswahl == s.getMatrikelnummer()) {
                        System.out.println("Student gefunden: "
                                + s.getVorname() + " " + s.getNachname()
                                + " " + s.getMatrikelnummer());
                        System.out.println();
                        st = s;

                        set = true;
                    }
                }
                if (set == true){
                    System.out.println("Student wirklich loeschen? 1 = ja");
                    eingabe = input.nextInt();
                    if (eingabe == 1) {
                        //System.out.println(liste.remove(s));
                    	liste.remove(st);
                        System.out.println("Student geloescht!");
                    }
                }
                if (set == false){
                	System.out.println("Student wurde nicht gefunden!");
                    System.out.println();
                }
			} break;
			
			case 4: {
				kopf();
				ausgabeListe(liste);
				System.out.println();
			} break;
			
			case 5: {
				System.out.println("Bitte geben sie die Matrikelnummer ein:");
                set = false;
                auswahl = input.nextInt();
                for (Student s : liste) {
                    if (auswahl == s.getMatrikelnummer()) {
                        System.out.println("Student gefunden: ");
                        kopf();
                        System.out.println(s);
                        System.out.println();
                        set = true;
                        break;
                    }
                }
                if (set == false){
                	System.out.println("Student Student wurde nicht gefunden!");
                    System.out.println();
                }
			} break;
			}

		} while (eingabe != 0);

	}

    public static void printmenu() {
        System.out.println("1.) Studenten Sortieren");
        System.out.println("2.) Student editieren");
        System.out.println("3.) Student loeschen");
        System.out.println("4.) Studentenliste anzeigen");
        System.out.println("5.) Studenten ansehen");
        System.out.println("0.) Beenden");
    }
	public static void ausgabeListe(ArrayList<Student> liste) {
		for (Student s : liste)
			System.out.println(s);
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
	public static void kopf(){
		System.out.println("Numm." + "\tMatrikelnr." + "\t\tNachname" 						
				+ "\tVorname" + "\t\tAlter" + "\t\tStudiengang");
		System.out.println("====================================================" + 
				"=======================================");
	}
	
}
