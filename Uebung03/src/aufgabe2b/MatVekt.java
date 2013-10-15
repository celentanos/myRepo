package aufgabe2b;

import java.util.Random;
import java.util.Scanner;

public class MatVekt {

	/**
	 * @param args
	 */
	public static void ausgabeMatrix(int [][] x){
		System.out.print("Die generierte Matrix:");
		System.out.println();
		for (int i = 0; i < x.length; i++){
			for (int j = 0; j < x[0].length; j++){
				System.out.printf("%4d",x[i][j]);
			}
			System.out.println();
		}
	}
	public static void ausgabeVektor(int [] b){
		System.out.println("Das Vektor b:");
		for (int i = 0; i < b.length; i++){
			System.out.println(b[i]);
		}
	}
	public static void produkt(int [] y){
		System.out.println("Matrix * Vektor:");
		for (int i = 0; i < y.length; i++){
			System.out.println(y[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
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
		ausgabeMatrix(a);
		
		for (int i = 0; i < n; i++){
			b[i] = r.nextInt(4) + 2;
		}
		ausgabeVektor(b);
		
		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++){
				erg[i] = erg[i] + (a[i][j] * b[j]);
			}
		}
		produkt(erg);
		
	}

}
