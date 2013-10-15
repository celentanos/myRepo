package programm;

import java.io.Serializable;

public class Konto implements Serializable{
	
	private static final long serialVersionUID = -2112412912590624609L;
	int kontonummer, betrag, dispolimit;
	
	//Konstruktor
	public Konto(int kontonummer, int betrag, int dispolimit){
		this.kontonummer = kontonummer;
		this.betrag = betrag;
		this.dispolimit = dispolimit;
	}
	
	public String toString(){
		
		String s = "Kontonummer: " + kontonummer + " Betrag: " + betrag + " Dispolimit: " + dispolimit;
		return s;
	}
	
	public int getKontonummer() {
		return kontonummer;
	}
	
	public String getKontonummerS() {
		return Integer.toString(kontonummer);
	}
	
	public void setKontonummer(int kontonummer) {
		this.kontonummer = kontonummer;
	}

	public int getBetrag() {
		return betrag;
	}
	
	public String getBetragS() {
		return Integer.toString(betrag);
	}


	public void setBetrag(int betrag) {
		this.betrag = betrag;
	}

	public int getDispolimit() {
		return dispolimit;
	}
	
	public String getDispolimitS() {
		return Integer.toString(dispolimit);
	}

	public void setDispolimit(int dispolimit) {
		this.dispolimit = dispolimit;
	}

}
