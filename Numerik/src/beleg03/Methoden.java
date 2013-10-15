package beleg03;

import java.util.Scanner;

public class Methoden {
	public static void printI(int[] p) {
		for (int i = 0; i < p.length; i++) {
			System.out.print(p[i] + " ");
		}
		System.out.println();
	}

	public static void printD(double[] p) {
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%-l7.12f ", p[i]);
		}
		System.out.println();
	}

	public static double[] scanV(double[] b) {
		System.out.println("Geben Sie b ein!");
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < b.length; i++) {
			b[i] = scan.nextDouble();
		}
		return b;
	}
}