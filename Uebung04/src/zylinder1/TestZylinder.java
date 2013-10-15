package zylinder1;

import java.util.Scanner;

public class TestZylinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double r, h;
		Scanner input = new Scanner(System.in);
		System.out.print("Bitte geben Sie d. Radius ein: ");
		r = input.nextDouble();
		System.out.print("Bitte geben Sie d. Hoehe ein: ");
		h = input.nextDouble();
		
		Zylinder z = new Zylinder(r,h); //Achtung!!! man muss immer die Reienfolge von den Elementen im Feld beachten...
		System.out.println(z);
		System.out.printf("Bodenflaeche = %5.2f\n", z.berechneBoden());
		System.out.printf("Mantel = %5.2f\n", z.berechneMantel());
		System.out.printf("Volumen = %5.2f\n", z.berechneVolumen());
		
	}

}
