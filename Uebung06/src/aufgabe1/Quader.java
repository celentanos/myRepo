package aufgabe1;

public class Quader implements IFKoerper{
	
	private double hoehe, breite, tiefe;
	
	public Quader (double h, double b, double t) {
		hoehe = h;
		breite = b;
		tiefe = t;
	}
	
	public double berechneVolumen() {
		return hoehe*breite*tiefe;
	}
	
	public double berechneOberflaeche() {
		return hoehe*breite*6;
	}
	
	//toString()-Methode
	public String toString() {
		return "Quader [hoehe=" + hoehe + ", breite=" + breite + ", tiefe=" + tiefe + 
		", Volumen=" + berechneVolumen() + ", Oberflaeche=" + berechneOberflaeche() + "]";
	}

}
