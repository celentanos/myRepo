package beleg03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);
		System.out.println("Geben Sie die Größe des LGS(n:=)!");
		int n = S.nextInt();
		// LGS-Definition
		Matrix A = new Matrix(n, n);
		double[] b = new double[n];
		// Pivotfeld (Länge ist um Eins kleiner als die von b)
		int[] p = new int[n - 1];
		// sing = true bedeutet ,dass ich vermute, dass die Matrix A regulär ist
		boolean[] sing = { true };
		// LGS-Eingabe
		A.scan(S);
		b = scanV(b);
		System.out.println("Es ist das folgende LGS zu lösen: ");
		A.print();
		printD(b);
		System.out.println();
		// Losen von Ax=b
		System.out.println("Die Lösung lautet: ");
		LR_DECOMP.lr_matrix(A, p, sing);
		if (sing[0]) {
			System.out.println("L" + '\\' + "R-Fa.ktorisierung: ");
			A.print();
			System.out.print("Pivotmenge: ");
			printI(p);
			System.out.println("Die Matrix ist regulär!");
			double[] y = L_SOLVE.y_Solve(A, b, p);
			double[] x = R_SOLVE.x_Solve(A, y);
			System.out.print("x = ");
			printD(x);
		} else {
			System.out.print("Die Matrix ist singulär");
		}
	}
	
	private static void printI(int[] p) {
		for (int i = 0; i < p.length; i++) {
			System.out.print(p[i] + " ");
		}
		System.out.println();
	}

	private static void printD(double[] p) {
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%12f ", p[i]);
		}
		System.out.println();
	}

	private static double[] scanV(double[] b) {
		System.out.println("Geben Sie b ein!");
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < b.length; i++) {
			b[i] = scan.nextDouble();
		}
		return b;
	}
}
