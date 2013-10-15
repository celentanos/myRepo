package pi;

import java.util.Scanner;

public class Pi_ {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i;
		System.out.println("Geben Sie bitte die Zahl groesser 10^4 ein:");
		i = input.nextInt();
		System.out.println("pi = " + approximiere_pi (i));
	}
	
	public static double approximiere_pi(int n) {
		double pi = 0;
		int k = 0;
		int gesamt = n;
		 
		while (n > 0) {
			double dotx = Math.random();
		    double doty = Math.random();
		 
		    if (dotx*dotx + doty*doty <= 1) {
		    	k++;
		    } else {
		    }
		    n--;  
		}
		pi = 4*(double)k/gesamt;
		return pi;	
	}
}
