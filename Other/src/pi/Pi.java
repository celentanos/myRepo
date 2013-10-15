package pi;

import java.util.Scanner;

public class Pi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i;
		System.out.println("Geben Sie bitte die Zahl groesser 10^4 ein:");
		i = input.nextInt();
		System.out.println("pi = " + approximiere_pi (i));
		
	}
	
	public static double approximiere_pi(int tropfenzahl) {
		double pi = 0;
		int innerhalb = 0;
		int gesamt = tropfenzahl;
		 
		while (tropfenzahl > 0) { // generiere Tropfen und addiere je nach Zugeh�rigkeit
			double dotx = Math.random();
		    double doty = Math.random();
		 
		    if (dotx*dotx + doty*doty <= 1) {
		      // Punkt liegt innerhalb des Kreises
		      innerhalb++;
		    } else {
		      // Punkt liegt au�erhalb des Kreises
		    }
		    tropfenzahl--;  
		}
		   
		pi = 4*(double)innerhalb/gesamt;
		return pi;	
	}

}
