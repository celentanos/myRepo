package aufgabe1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class StudentGUI extends JFrame implements ActionListener{
	JPanel p;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	JMenuBar jmb = new JMenuBar();
	
	JMenu menu1 = new JMenu("Datei");
	JMenuItem beendenItem = new JMenuItem("Beenden");
	
	JMenu menu2 = new JMenu("Sortieren");
	JMenuItem sort = new JMenuItem("nach Namen u. Vorname");
	
	JLabel matrikel = new JLabel("Matr.Nr.:");
	JLabel name = new JLabel("Name:");
	JLabel vorname = new JLabel("Vorname:");
	JLabel studiengang = new JLabel("Studiengang:");
	JButton anzeigen = new JButton("Daten anzeigen");
	JButton aendern = new JButton("Ändern");
	JButton loeschen = new JButton("Löschen");
	JComboBox matrikelnr = new JComboBox();
	JTextArea namet = new JTextArea();
	JTextArea vornamet = new JTextArea();
	JTextArea studiengangt = new JTextArea();
	JButton aktual = new JButton("Aktualisieren");
	
	String[][] inhalt;
	JTable tabelle;
	
	ArrayList<Student>liste = new ArrayList<Student>();
	
	//Konstruktor
	public StudentGUI(){
		erzeugeListe(liste);
		String[] titel = {"Matr.-Nr.","Vorname","Name","geb.","SG"};
		inhalt = new String[liste.size()][5];
		tabelle = new JTable(inhalt,titel);
		String [] combo = new String[liste.size()];
		for(int i = 0; i < liste.size(); i++){
			combo[i] = Integer.toString(liste.get(i).getMatrikelnummer());
		}
		matrikelnr = new JComboBox(combo);
		this.setTitle("Studentenverwaltung");
		//this.setSize(800,600);
		initGUI();
		tabellenausgabe();
		
	}
	
	private void tabellenausgabe() {
		// TODO Auto-generated method stub
		for (int i = 0; i < liste.size();i++){
			inhalt[i][0] = String.valueOf(liste.get(i).getMatrikelnummer());
			inhalt[i][1] = liste.get(i).getVorname();
			inhalt[i][2] = liste.get(i).getNachname();
			inhalt[i][3] = Integer.toString(liste.get(i).getGeburtsjahr());
			inhalt[i][4] = liste.get(i).getStudiengang();
		}
	}

	private void erzeugeListe(ArrayList<Student> liste2) {
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

	public void initGUI(){
		initMenu();
		this.setJMenuBar(jmb);
		p = (JPanel)this.getContentPane();
		initPanel1();
		initPanel2();
		p.setLayout(new GridLayout(1,2));
		p.add(p1);
		p.add(p2);
		this.pack();
		
	}
	
	private void initPanel1() {
		
		p1.setLayout(null);
		
		matrikel.setBounds(5, 10, 80, 20);
		matrikelnr.setBounds(100, 10, 80, 20);
		anzeigen.setBounds(5, 40, 180, 20);
		name.setBounds(5, 80, 80, 20);
		namet.setBounds(100, 80, 80, 20);
		vorname.setBounds(5, 120, 80, 20);
		vornamet.setBounds(100, 120, 80, 20);
		studiengang.setBounds(5, 160, 80, 20);
		studiengangt.setBounds(100, 160, 80, 20);
		aendern.setBounds(5, 200, 180, 20);
		loeschen.setBounds(5, 240, 180, 20);
		p1.add(matrikel);
		p1.add(matrikelnr);
		p1.add(anzeigen);
		p1.add(name);
		p1.add(namet);
		p1.add(vorname);
		p1.add(vornamet);
		p1.add(studiengang);
		p1.add(studiengangt);
		p1.add(aendern);
		p1.add(loeschen);
	}
	
	private void initPanel2() {
		
		p2.setLayout(new BorderLayout());
		p2.add(new JScrollPane(tabelle),BorderLayout.CENTER);
		p2.add(aktual, BorderLayout.SOUTH);
		
	}

	private void initMenu() {
		
		menu1.add(beendenItem);
		jmb.add(menu1);
		menu2.add(sort);
		jmb.add(menu2);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
