package aufgabe1;
import java.util.Calendar;
import java.util.Date;



public class Mensch {

	private String Vorname;
    private String Nachname;
    private int Geburtsjahr;
    private Geschlecht geschlecht;
    private int ID;
    private static int gesamtzahl; 
   
     public Mensch(String Vo,String Na,int GebJ,Geschlecht geschlecht){
        Vorname=Vo;
        Nachname=Na;
        Geburtsjahr=GebJ;
        this.geschlecht= geschlecht;
        ID=gesamtzahl+1;
        gesamtzahl++;   
    }
   
    public int getAlter(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date()); 
        int jahr = cal.get(Calendar.YEAR);
        return jahr-Geburtsjahr;
    }
      
    public boolean alterAls(Mensch m){
        if (this.getAlter()== m.getAlter()){
            return true;
        }
        else
        {
            return false;
        }
    }
   
    public String toString(){
        return this.geschlecht.gibAnrede()+" "+Vorname+" "+Nachname+" ist "+this.getAlter()+" Jahre alt."+this.getGeschlecht();
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public static int getGesamtzahl() {
        return gesamtzahl;
    }

    public static void setGesamtzahl(int gesamtzahl) {
        Mensch.gesamtzahl = gesamtzahl;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public int getGeburtsjahr() {
        return Geburtsjahr;
    }

    public void setGeburtsjahr(int geburtsjahr) {
        Geburtsjahr = geburtsjahr;
    }

    public Geschlecht getGeschlecht() {
        return this.geschlecht;
    }

    public void setGeschlecht(Geschlecht geschlecht) {
        this.geschlecht = geschlecht;
    }
	
	
	
}
