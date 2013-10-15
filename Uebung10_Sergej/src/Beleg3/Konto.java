package Beleg3;

import java.io.Serializable;

public class Konto implements Serializable{
	
	int kontonummer, betrag, dispolimit;
	
	public Konto(int kontonummer, int betrag, int dispolimit){
		this.kontonummer = kontonummer;
		this.betrag = betrag;
		this.dispolimit = dispolimit;
	}
	
	
	public int getKontonummer() {
		return kontonummer;
	}

	public void setKontonummer(int kontonummer) {
		this.kontonummer = kontonummer;
	}

	public int getBetrag() {
		return betrag;
	}

	public void setBetrag(int betrag) {
		this.betrag = betrag;
	}

	public int getDispolimit() {
		return dispolimit;
	}

	public void setDispolimit(int dispolimit) {
		this.dispolimit = dispolimit;
	}

}
