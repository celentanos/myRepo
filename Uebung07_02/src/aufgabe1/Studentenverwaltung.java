package aufgabe1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner; 


public class Studentenverwaltung {

    public static void lz(ArrayList<Student> a) {
        System.out.printf("%10s", "Lfd Nr.");
        System.out.printf("%10s", "Mat-Nr.");
        System.out.printf("%6s", "Anr.");
        System.out.printf("%25s", "Vorname");
        System.out.printf("%25s", "Nachname");
        System.out.printf("%6s", "Alter");
        System.out.printf("%25s", "Studiengang");
        System.out.println("");
        System.out
                .println("===========================================================================================================");
        for (Student s : a) {
            System.out.printf("%10d", s.getID() - 1);
            System.out.printf("%10d", s.getMatrikelnummer());
            System.out.printf("%6s", s.getGeschlecht().gibAnrede());
            System.out.printf("%25s", s.getVorname());
            System.out.printf("%25s", s.getNachname());
            System.out.printf("%6d", s.getAlter());
            System.out.printf("%25s", s.getStudiengang());
            System.out.println("");
        }
    }

    public static void printmenu() {
        System.out.println("1.) Studenten Sortieren");
        System.out.println("2.) Student editieren");
        System.out.println("3.) Student löschen");
        System.out.println("4.) Studentenliste anzeigen");
        System.out.println("5.) Student ansehen");
    }

    

    public static void main(String[] args) {
        ArrayList<Student> Studlist = new ArrayList<Student>();
        Scanner in = new Scanner(System.in);
        int cho1 = 0;
        int cho2 = 0;
        int i = 0;
        boolean set;
        String vgl;
      
        Studlist.add(new Student(56567, "Informatik", "Nils-Martin", "Steiniger",1988, new Maennlich()));
        Studlist.add(new Student(56082, "Theologie", "Karl","Heinz", 1990, new Maennlich()));
        Studlist.add(new Student(56083, "Informatik", "Kai Uwe", "Schneck", 1971,new Maennlich()));
        Studlist.add(new Student(56084, "Informatik", "Nils", "Rexin",1987, new Maennlich()));
        Studlist.add(new Student(56085, "Informatik", "Marco", "Kastner",1983,new Maennlich()));
        Studlist.add(new Student(56086, "Biologie", "Fanny","Rger", 1989, new Weiblich()));
        Studlist.add(new Student(56087, "Informatik", "Bastian", "Geweniger", 1984,new Maennlich()));
        Studlist.add(new Student(56088, "Sport", "Denniz", "Schuz", 1985,new Maennlich()));
        Studlist.add(new Student(56089, "Wirtschaft", "Frank", "Lenz",1986, new Maennlich()));
        Studlist.add(new Student(56081, "Medieninformatik", "Tim","Tunar", 1989, new Maennlich()));
        Studlist.add(new Student(56091, "Medieninformatik", "","Nicht", 1987, new Maennlich()));
        lz(Studlist);
        do {
            printmenu();
            cho1 = in.nextInt();
            if (cho1 == 1) {
                Collections.sort(Studlist);
            }
            if (cho1 == 2) {
                do {
                    System.out.println("Bitte geben sie die Matrikelnummer an");
                    set = false;
                    cho2 = in.nextInt();
                    for (Student s : Studlist) {
                        if (cho2 == s.getMatrikelnummer()) {
                            System.out.println("Student gefunden."
                                    + s.getVorname() + " " + s.getNachname()
                                    + " " + s.getMatrikelnummer());
                            
                            System.out.println("Geben Sie den neuen Vornamen!");
                            vgl = in.next();
                            s.setVorname(vgl);
                            
                            System.out.println("Geben Sie den neuen Nachnamen!");
                            vgl = in.next();
                            s.setNachname(vgl);
                            
                            System.out.println("Geben Sie den neuen Studiengang!");
                            vgl = in.next();
                            s.setStudiengang(vgl);
                            set = true;
                            break;
                        }
                    }
                } while (!set);
            }
            if (cho1 == 3) {
                do {
                    System.out.println("Bitte geben sie die Matrikelnummer an");
                    set = false;
                    cho2 = in.nextInt();
                    for (Student s : Studlist) {
                        if (cho2 == s.getMatrikelnummer()) {

                            System.out.println("Student gefunden: "
                                    + s.getVorname() + " " + s.getNachname()
                                    + " " + s.getMatrikelnummer());
                            System.out
                                    .println("Student wirklich löschen? 1=ja");
                            cho1 = in.nextInt();
                            if (cho1 == 1) {
                                System.out.println(Studlist.remove(s));
                                System.out.println("Student gelöscht!");
                            }
                            set = true;
                            break;
                        }
                    }
                } while (!set);
            }
            if (cho1 == 4) {
                lz(Studlist);
            }
            i = 0;
            if (cho1 == 5)
                do {
                    System.out.println("Bitte geben sie die Matrikelnummer an");
                    set = false;
                    cho2 = in.nextInt();
                    for (Student s : Studlist) {
                        if (cho2 == s.getMatrikelnummer()) {
                            System.out.println("Student gefunden: ");
                            System.out.println(Studlist.get(i));
                            set = true;
                            break;
                        }
                        i++;
                    }
                } while (!set);
        } while ((cho1 >= 1) || (cho1 <= 5));
    }
}