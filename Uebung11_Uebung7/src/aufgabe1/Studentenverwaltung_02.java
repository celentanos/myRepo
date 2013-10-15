package aufgabe1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Studentenverwaltung_02 {
	
	
	public static void main(String[] args) throws IOException {
		
		StudentGUI student = new StudentGUI();
		student.setLocation(200, 200);
		student.setVisible(true);
		
		
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
				ausgabe(liste);
			} break;
			
			case 5: {
				System.out.println("Bitte geben sie die Matrikelnummer ein:");
                set = false;
                auswahl = input.nextInt();
                Student st = null;
                for (Student s : liste) {
                    if (auswahl == s.getMatrikelnummer()) {
                    	st = s;
                        System.out.println("Student gefunden: ");
                        set = true;
                        break;
                    }
                }
                
                System.out.printf("%6s", "Numm.");
                System.out.printf("%14s", "Matrikelnr.");
                System.out.printf("%12s", "Geschl.");
                System.out.printf("%15s", "Vorname");
                System.out.printf("%15s", "Nachname");
                System.out.printf("%12s", "Alter");
                System.out.printf("%16s", "Studiengang");
                System.out.println("");
                System.out.println("==========================================================================================");
                System.out.printf("%6d", st.getNummer() - 1);
                System.out.printf("%14d", st.getMatrikelnummer());
                System.out.printf("%12s", st.getGeschlecht());
                System.out.printf("%15s", st.getVorname());
                System.out.printf("%15s", st.getNachname());
                System.out.printf("%12d", st.getAlter());
                System.out.printf("%16s", st.getStudiengang());
                System.out.println();            
                
                if (set == false){
                	System.out.println("Student Student wurde nicht gefunden!");
                    System.out.println();
                }
			} break;
			
			
			case 6:{
				speichern(liste);
			}
			}

		} while (eingabe != 0);

	}

    public static void printmenu() {
        System.out.println("1.) Studenten Sortieren");
        System.out.println("2.) Student editieren");
        System.out.println("3.) Student loeschen");
        System.out.println("4.) Studentenliste anzeigen");
        System.out.println("5.) Studenten ansehen");
        System.out.println("6.) Spechern in eine Datei");
        System.out.println("7.) Lesen aus einer Datei");
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
	
    public static void ausgabe(ArrayList<Student> liste) {
        System.out.printf("%6s", "Numm.");
        System.out.printf("%14s", "Matrikelnr.");
        System.out.printf("%12s", "Geschl.");
        System.out.printf("%15s", "Vorname");
        System.out.printf("%15s", "Nachname");
        System.out.printf("%12s", "Alter");
        System.out.printf("%16s", "Studiengang");
        System.out.println("");
        System.out.println("==========================================================================================");
        for (Student s : liste) {
            System.out.printf("%6d", s.getNummer() - 1);
            System.out.printf("%14d", s.getMatrikelnummer());
            System.out.printf("%12s", s.getGeschlecht());
            System.out.printf("%15s", s.getVorname());
            System.out.printf("%15s", s.getNachname());
            System.out.printf("%12d", s.getAlter());
            System.out.printf("%16s", s.getStudiengang());
            System.out.println();
        }
        System.out.println();
    }
    
    public static void speichern(ArrayList<Student> liste) throws IOException{
    	
    	BufferedWriter output = new BufferedWriter(new FileWriter("student.txt"));
    	//fuer jeden Student in der Liste
    	{
    		//erzeuge String st
    		String st = null;
    		for(Student s : liste){
        		st = ("" + (s.getNummer()-1)
        				 + "\t" + s.getMatrikelnummer()
        				 + "\t" + s.getGeschlecht()
        				 + "\t" + s.getVorname()
        				 + "\t" + s.getNachname()
        				 + "\t" + s.getAlter()
        				 + "\t" + s.getStudiengang());
        		output.write(st);
        		output.newLine();
    		}
    	}
    	output.close();
    }
    
    public static ArrayList<Student> offnen() throws IOException{
    	BufferedReader input = new BufferedReader(new FileReader("student.txt"));
    	String line;
		//zeilenweise einlesen
    	while((line = input.readLine()) != null){
    		String[] splittArray = line.split("\t");
    		
    	}
    	input.close();
		return null;
    }
	
}
