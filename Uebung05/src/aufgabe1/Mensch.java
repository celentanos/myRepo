package aufgabe1;

import java.util.Calendar;

public class Mensch {
	private String vorname, nachname;
	private int geburtsjahr, nummer;
	private char geschlecht;
	static int gesamtzahl;
	
	Calendar cal = Calendar.getInstance();
	
	//Konstruktor
	public Mensch(String vornam, String nachnam, int gebjahr, char geschl) {
		vorname = vornam;
		nachname = nachnam;
		geburtsjahr = gebjahr;
		geschlecht = geschl;
		nummer = gesamtzahl++;
	}
	
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
}
