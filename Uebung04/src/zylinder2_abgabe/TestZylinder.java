package zylinder2_abgabe;

import java.util.Random;
import java.util.Scanner;


public class TestZylinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Zylinder z = new Zylinder(); //Achtung!!! man muss immer die Reienfolge von den Elementen im Feld beachten...
		double r, h, f, gesVol;
		Scanner input = new Scanner(System.in);
		Random ram = new Random();
		int eingabe, laenge;
		do {
			System.out.println();
			System.out.println("(1) Zylinderwerte ausgeben");
			System.out.println("(2) Zylinderdaten aendern");
			System.out.println("(3) Skalierung");
			System.out.println("(4) Zylinderfeld");
			System.out.println("(0) Ende");
			eingabe = input.nextInt();
			System.out.println();
			
			switch (eingabe) {
			
			case 1: {
				System.out.println(z);
				System.out.printf("Bodenflaeche = %5.2f\n", z.berechneBoden());
				System.out.printf("Mantel = %5.2f\n", z.berechneMantel());
				System.out.printf("Oberflaeche = %5.2f\n", z.berechneOberflaeche());
				System.out.printf("Volumen = %5.2f\n", z.berechneVolumen());
				System.out.println();
			} break;
			
			case 2: {
				System.out.print("Bitte geben Sie d. Radius ein: ");
				r = input.nextDouble();
				System.out.print("Bitte geben Sie d. Hoehe ein: ");
				h = input.nextDouble();
				z.setHoehe(h);	//neue Werte Uebergeben
				z.setRadius(r);	//neue Werte Uebergeben
			} break;
			
			case 3: {
				System.out.println("Bitte geben Sie ein Skalierfaktor ein: ");
				f = input.nextDouble();
				z.skaliere(f);
			} break;
			
			case 4: {
				gesVol = 0;
				laenge = ram.nextInt(9) + 1;
				Zylinder [] zylFeld = new Zylinder [laenge];
				for (int i = 0; i <= laenge - 1; i++) {
					r = ram.nextInt(9) + 1;
					h = ram.nextInt(9) + 1;
					zylFeld[i] = new Zylinder(r,h);
					
				}
				for (int i = 0; i <= laenge - 1; i++) {
					System.out.println(i + 1 + ": " + zylFeld[i]);
					gesVol = gesVol + zylFeld[i].berechneVolumen() ;
				}

				System.out.printf("Gesamtvolumen = %5.2f\n", gesVol);
				System.out.println();
			} break;
			}
		} while (eingabe != 0);
	}

}
