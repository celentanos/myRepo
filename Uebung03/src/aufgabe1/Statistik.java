package aufgabe1;

import java.util.Scanner;

public class Statistik {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Geben Sie Feldlaenge N ein: ");
		int n = input.nextInt();				//n = Feldlänge
		double m = 0, s = 0;						
		double[] x = new double[n];				//x = Feld
		for (int i = 0; i < n; i++){				
			System.out.print("x[" + i + "]= ");
			x[i] = input.nextDouble();
		}
		for (int i = 0; i < n; i++){
			m = m + x[i];
		}
		m = m / n;
		System.out.println("arithmetische Mittel = " + m);
		
		for (int i = 0; i < n; i++){
			s = s + ((x[i] - m) * (x[i] - m));
		}
		s = s/(n -1);
		s = Math.sqrt(s);
		//System.out.println();
		System.out.println("Standartsbweichung = " + s);
		
	}

}
