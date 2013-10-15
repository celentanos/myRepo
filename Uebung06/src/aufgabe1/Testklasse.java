package aufgabe1;

import java.util.Random;
import java.util.Scanner;

public class Testklasse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Random ram = new Random();
		int eingabe;
		IFKoerper k;
		do {
			System.out.println();
			System.out.println("(1) Zylinder");
			System.out.println("(2) Quader");
			System.out.println("(3) Wuerfel");
			System.out.println("(0) Ende");
			eingabe = input.nextInt();
			System.out.println();
			
			switch (eingabe) {
				
			case 1: {
				k = new Zylinder(ram.nextInt(9) + 1, ram.nextInt(9) + 1);
				System.out.println(k);
			} break;
			
			case 2: {
				k = new Quader(ram.nextInt(9) + 1, ram.nextInt(9) + 1, ram.nextInt(9) + 1);
				System.out.println(k);
			} break;
			
			case 3: {
				k = new Wuerfel(ram.nextInt(9) + 1);
				System.out.println(k);
			} break;
			
			}
		} while (eingabe != 0);
		
	}

}
