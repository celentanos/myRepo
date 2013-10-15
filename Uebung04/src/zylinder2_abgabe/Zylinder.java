package zylinder2_abgabe;

public class Zylinder {
	
	public double radius, hoehe;
	
	//Konstruktor2
	public Zylinder() {
		radius = 1.0;
		hoehe = 1.0;
	}
	
	//Konstruktor1
	public Zylinder(double r,double h) {
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
		return "Zylinder [radius=" + radius + ", hoehe=" + hoehe + "]";
	}
	
	//Methode zur Berechnung der Bodenflaeche vom Zylinder...
	public double berechneBoden() {
		return Math.PI*radius*radius;
	}
	
	public double berechneVolumen() {
		return Math.PI*radius*radius*hoehe;
	}
	
	public double berechneMantel() {
		return Math.PI*2*radius*hoehe;
	}
	
	public double berechneOberflaeche() {
		return berechneBoden() * 2 + berechneMantel();
	}
	
	//Methode fuer Skalierung...
	public void skaliere(double f) {
		radius = radius * f;
		hoehe = hoehe * f;
	}
}
