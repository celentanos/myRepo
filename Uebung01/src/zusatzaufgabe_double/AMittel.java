package zusatzaufgabe_double;

import java.util.Scanner;

public class AMittel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Bitte geben Sie Feldlaenge ein: ");
		int n = input.nextInt();
		int zaehler = 0, m;
		double arrayssum = 0, durchschnitt;
		int[] a = new int[n];
		while (zaehler < n){
			System.out.print("Bitte geben Sie Zahl fuer das Feld ein: ");
			m = input.nextInt();
			a[zaehler] = m;
			zaehler = zaehler + 1;
		}
		zaehler = 0;
		while (zaehler < n){
			arrayssum = arrayssum + a[zaehler];
			zaehler = zaehler+1;
		}
		durchschnitt = arrayssum / n;
		System.out.println( durchschnitt );
		
		
	}

}
