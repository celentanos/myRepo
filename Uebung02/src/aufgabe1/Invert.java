package aufgabe1;

import java.util.Scanner;

public class Invert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Bitte geben Sie Feldlaenge ein: ");
		int laenge = input.nextInt();
		int anfang = 0, ende = laenge -1, tausch;
		int[] a = new int[laenge];
		
		for (int i = 0; i < laenge; i++){
			System.out.print("Bitte geben Sie a[" + i + "]= ");
			a[i] = input.nextInt();
		}
		for (int i = 0; i < laenge; i++){
			System.out.println("Das Feld sieht so aus: " + a[i]);
		}
		while (anfang < ende){
			tausch = a[anfang];
			a[anfang] = a[ende];
			a[ende] = tausch;
			anfang = anfang + 1;
			ende = ende - 1;
		}
		for (int i = 0; i < laenge; i++){
			System.out.println("Jetzt sieht das Feld so aus: " + a[i]);
		}
		System.out.print("Feldlaenge: " + a.length);
	}

}
