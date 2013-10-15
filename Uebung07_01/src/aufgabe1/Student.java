package aufgabe1;

public class Student extends Mensch implements Comparable<Student>{
	
	private int matrikelnummer;
	private String studiengang;
	
	//Konstruktor
	public Student(String vornam, String nachnam, int gebjahr, char geschl, int matrikel, String sgang) {
		super(vornam, nachnam, gebjahr, geschl);
		
		matrikelnummer = matrikel;
		studiengang = sgang;
	}
	
	public String toString() {
		//String s = Integer.toString(getNummer()) ;
		//s = s + matrikelnummer;
		/*if (this.istMaenlich())
			s = s + "\t Herr ";
		else{
			s = s + "\t Frau ";
		}*/
		String s = null;
		if (this.istMaenlich())
			s ="Herr";
		else{
			s ="Frau";	
		}
		return getNummer() + "\t" + matrikelnummer + "\t\t" + s + "\t" + getNachname() 
				+ ",\t\t" + getVorname()+ "\t\t" + getAlter() + "\t\t" + studiengang;
	}
	
//-----Geters-Seters-----------------------------------
	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}

	public String getStudiengang() {
		return studiengang;
	}

	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}
//------------------------------------------------------
	/*@Override
	public int compareTo(Student other) {
		if (this.getAlter() < other.getAlter())
			return -1;
		else if (this.getAlter() > other.getAlter())
			return 1;
		else return 0;

	}*/
	
	public int compareTo(Student other) {
		String name1 = getNachname() + getVorname();
		String name2 = other.getNachname() + other.getVorname();
		
		return name1.compareTo(name2);

	}
	
}
