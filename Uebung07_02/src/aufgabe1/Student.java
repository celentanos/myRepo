package aufgabe1;


public class Student extends Mensch implements Comparable<Student>{
    int Matrikelnummer;
    String Studiengang;
   
   
    public Student (int Ma, String StG,String Vo,String Na,int GebJ,Geschlecht Ges){
        super(Vo,Na,GebJ,Ges);
        Matrikelnummer=Ma;
        Studiengang=StG;   
    }

    public int getMatrikelnummer() {
        return Matrikelnummer;
    }

    public void setMatrikelnummer(int matrikelnummer) {
        Matrikelnummer = matrikelnummer;
    }

    public String getStudiengang() {
        return Studiengang;
    }

    public void setStudiengang(String studiengang) {
        Studiengang = studiengang;
    }
   
    public String toString(){
    	Geschlecht ges = this.getGeschlecht();
        String anr="";
        anr="Student"+ges.gibGenus()+" "+ ges.gibAnrede()+ " " +this.getVorname()+" "+this.getNachname()+" Matrikelnummer "+this.Matrikelnummer+" besucht Studiengang "+this.Studiengang+" ist "+this.getAlter()+" Jahre alt und "+this.getGeschlecht()+".";
        return anr;
    }

    @Override
    public int compareTo(Student a) {
    	  return this.getMatrikelnummer()-a.getMatrikelnummer();
//        return ((this.getNachname() + this.getVorname()).compareTo(a.getNachname()+a.getNachname()));
    }
}