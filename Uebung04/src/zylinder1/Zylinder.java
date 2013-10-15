package zylinder1;

//Konstruktor
public class Zylinder {
	
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
}
