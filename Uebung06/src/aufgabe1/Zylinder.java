package aufgabe1;

//Konstruktor
public class Zylinder implements IFKoerper{
	
	private double radius, hoehe;
	
	public Zylinder (double r, double h) {
		radius = r;
		hoehe = h;
	}
	
	//get & set Zeug...
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getHoehe() {
		return hoehe;
	}
	public void setHoehe(double hoehe) {
		this.hoehe = hoehe;
	}
	
	//toString()-Methode
	@Override
	public String toString() {
		return "Zylinder [radius=" + radius + ", hoehe=" + hoehe + 
		", Volumen=" + berechneVolumen() + ", Oberflaeche=" + berechneOberflaeche() + "]";
	}
	
	//Methode zur Berechnung der Bodenflaeche vom Zylinder...
	public double berechneBoden() {
		return Math.PI*radius*radius;
	}
	
	public double berechneVolumen() {
		return Math.PI*radius*radius*hoehe;
	}
	
	public double berechneOberflaeche() {
		return berechneBoden() * 2 + berechneMantel();
	}
	
	public double berechneMantel() {
		return Math.PI*2*radius*hoehe;
	}
}
