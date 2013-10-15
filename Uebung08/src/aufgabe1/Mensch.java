package aufgabe1;

import java.util.Calendar;

public class Mensch {
	private String vorname, nachname;
	private int geburtsjahr, nummer;
	private char geschlecht;
	static int gesamtzahl;
	
	Calendar cal = Calendar.getInstance();
	
//-----Konstruktor---------------------------
	public Mensch(String vornam, String nachnam, int gebjahr, char geschl) {
		vorname = vornam;
		nachname = nachnam;
		geburtsjahr = gebjahr;
		geschlecht = geschl;
		nummer = ++gesamtzahl;
	}//---------------------------------------
	
	public int getAlter() {
		return cal.get(Calendar.YEAR) - geburtsjahr;
	}
	
	public boolean istMaenlich() {
		if (geschlecht == 'm') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return nachname + vorname + " ist " + getAlter() + " alt.";
	}
	
	public boolean aelterAls(Mensch m) {
		if (getAlter() > getAlter()) { //oder: (geburtsjahr > m.geburtsjahr)
			return true;
		}
		else {
			return false;
		}
	}
//-----Geters-Seters--------------------------------------------------------
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}

	public void setGeburtsjahr(int geburtsjahr) {
		this.geburtsjahr = geburtsjahr;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public char getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht;
	}

	public static int getGesamtzahl() {
		return gesamtzahl;
	}

	public static void setGesamtzahl(int gesamtzahl) {
		Mensch.gesamtzahl = gesamtzahl;
	}

	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}
	
	
}
