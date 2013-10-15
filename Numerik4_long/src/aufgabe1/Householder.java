package aufgabe1;

import java.math.BigDecimal;
import java.util.Scanner;

/*
 Berechnet x in Ax = b, wo: A ist mxn Matrix, x ist n dimensionales Vektor, b ist m
 dimensionales Vektor.
 Eingabe:
 1. Zeile:
 m n
 (Zahlen vom Typ BigDecimal)
 nächste m Zeilen:
 ai1 ai2 ... ain bi (Zahlen vom Typ BigDecimal)(i = {1,2,...,m})
 Ausgabe:
 Matrix A|b
 Matrix HA|b mit House Vektoren
 Vektor r der Diagonalelemente
 Vektor x der Lösungen
 */
public class Householder {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int m = 12;
		int n = 6;
		if (n > m) {
			System.out.println("n can't be greater than m.");
			input.close();
			return;
		}
		BigDecimal A[][] = new BigDecimal[m][n + 1];
		BigDecimal r[] = new BigDecimal[n];
		BigDecimal x[] = new BigDecimal[n];
		BigDecimal res[] = new BigDecimal[1];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n + 1; j++) {
				A[i][j] = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(i+1+j),50,java.math.RoundingMode.HALF_UP);
			}
			A[i][n]=input.nextBigDecimal();
		}
		input.close();

		printMatrix(A, m, n + 1, "A|b");
		try {
			HOUSEHOLDER(m, n + 1, A, r, x, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		printMatrix(A, m, n + 1, "HA|b with House vectors");
		printVector(r, n, "r");
		printVector(x, n, "x");
		System.out.printf("\nResiduum: %10.5f", res[0]);
		return;

	}

	public static void HOUSEHOLDER(int m, int n, BigDecimal A[][], BigDecimal r[],
			BigDecimal x[], BigDecimal res[]) throws Exception {

		// QR ZERLEGUNG================================================
		for (int j = 0; j < n - 1; j++) {

			BigDecimal s = new BigDecimal(0);
			for (int zeile = j; zeile < m; zeile++) {
				s = s.add(A[zeile][j].pow(2));
			}
			if (s.compareTo(BigDecimal.valueOf(0))==0)
				throw new Exception("Singulär");

			r[j] = A[j][j].compareTo(BigDecimal.valueOf(0)) < 0 ? BigDecimal.valueOf(Math.sqrt(s.doubleValue())) : BigDecimal.valueOf(-Math.sqrt(s.doubleValue()));

			BigDecimal kappa = s.subtract(A[j][j].multiply(r[j]));

			BigDecimal u[] = new BigDecimal[m - j];
			for (int i = j; i < m; i++) {
				u[i - j] = A[i][j];
			}
			u[0] = u[0].subtract(r[j]);

			BigDecimal y[] = new BigDecimal[n - j];

			for (int i = j; i < n; i++) {
				y[i - j] = BigDecimal.valueOf(0);
				for (int k = j; k < m; k++) {
					y[i - j] = y[i-j].add(u[k - j].multiply(A[k][i]));
				}
				y[i-j].setScale(50, java.math.RoundingMode.HALF_UP);
				y[i - j] = y[i-j].divide(kappa, java.math.RoundingMode.HALF_UP);
			}

			for (int spalte = j + 1; spalte < n; spalte++) {
				for (int zeile = j; zeile < m; zeile++) {
					A[zeile][spalte] = A[zeile][spalte].subtract(u[zeile - j].multiply(y[spalte - j]));
				}
			}

			for (int i = j; i < m; i++) {
				A[i][j] = u[i - j];
			}

		}

		// X BERECHNEN =============================================
		for (int j = n - 2; j >= 0; j--) {
			BigDecimal sumand = BigDecimal.valueOf(0);
			for (int i = j + 1; i < n - 1; i++) {
				sumand = sumand.add(x[i].multiply(A[j][i]));
			}
			x[j] = (A[j][n - 1].subtract(sumand)).divide(r[j], 50, java.math.RoundingMode.HALF_UP);
		}

		// REST BERECHNEN ==========================================
		res[0] = BigDecimal.valueOf(0);
		for (int j = n - 1; j < m; j++) {
			res[0] = res[0].add(A[j][n - 1].pow(2));
		}
		res[0] = BigDecimal.valueOf(Math.sqrt(res[0].doubleValue()));

	}

	public static void printMatrix(BigDecimal A[][], int m, int n) {
		System.out.println();
		for (int i = 0; i < m; i++) {
			System.out.print("|");
			for (int j = 0; j < n; j++) {
				System.out
						.printf(j >= n - 2 ? "%10.5f |" : "%10.5f ¦", A[i][j].doubleValue());
			}
			System.out.println();
		}
	}

	public static void printMatrix(BigDecimal A[][], int m, int n, String name) {
		System.out.println("\nMatrix " + name + ":");
		printMatrix(A, m, n);
	}

	public static void printVector(BigDecimal x[], int n) {
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.printf("|%10.5f |\n", x[i].doubleValue());
		}
	}

	public static void printVector(BigDecimal x[], int n, String name) {
		System.out.println("\nVector " + name + ":");
		printVector(x, n);
	}

}