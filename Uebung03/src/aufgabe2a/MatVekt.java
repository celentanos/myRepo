package aufgabe2a;

import java.util.Random;
import java.util.Scanner;

public class MatVekt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Random r = new Random();
		
		//System.out.print("Geben Sie die Anzahl der Zeilen m für die Matrix ein: ");
		//int m = input.nextInt();
		//System.out.print("Geben Sie die Anzahl der Spalten n für die Mattrix ein: ");
		//int n = input.nextInt();
		int m = r.nextInt(4) + 2;
		int n = r.nextInt(4) + 2;
		int[][] a = new int[m][n];
		int[] b = new int[n];
		int[] erg = new int[m];
		
		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++){
				a[i][j] = r.nextInt(10);
			}
		}
		System.out.print("Die generierte Matrix:");
		System.out.println();
		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++){
				System.out.printf("%4d",a[i][j]);
			}
			System.out.println();
		}
		for (int i = 0; i < n; i++){
			b[i] = r.nextInt(4) + 2;
		}
		System.out.println("Das Vektor b:");
		for (int i = 0; i < n; i++){
			System.out.println(b[i]);
		}
		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++){
				erg[i] = erg[i] + (a[i][j] * b[j]);
			}
		}
		System.out.println("Matrix * Vektor:");
		for (int i = 0; i < m; i++){
			System.out.println(erg[i]);
		}
		
	}

}
