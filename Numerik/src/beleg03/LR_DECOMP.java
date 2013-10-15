package beleg03;

import static java.lang.Math.*;

public class LR_DECOMP {
	public static int pivotindex(Matrix M, int s) {
		// Bestimmen und speichern der S-werte auf dem Feld p
		double[] p = new double[M.A[0].length];
		int z = s;
		while (z < M.A.length) {
			double h = 0;
			int j = s; // gibt die Spalte an ab der ich anfange aufzusummieren
			while (j < M.A[z].length) {
				h = h + abs(M.A[z][j]);
				j = j + 1;
			}
			p[z] = abs(M.A[z][s]) / h;
			z = z + 1;
		}
		// Pivotindex bestimmen d.h Position der größten Komponente von p bestimmen
		int i = s;
		for (int zähler = s; zähler < p.length; zähler++) {
			if (p[s] < p[zähler]) {

				p[s] = p[zähler];
				i = zähler;
			}
		}
		return i;
	}

	// LR-Faktorisierung
	public static void lr_matrix(Matrix M, int[] p, boolean[] sing) {
		int s = 0;
		while (s < M.A[0].length - 1) {
			// Pivu Linuex r■ jjM Scrn'i L L b ueb liiiimen
			p[s] = pivotindex(M, s);
			// Sei 1 p r mit der Zei 1 p s vertauschen
			M.changeLine(p[s], s);
			// Singularitätstest
			if (abs(M.A[s][s]) > (Math.pow(2, -52) * M.l_Norm())) {
				int z = s + 1;
				// Durchführung der Elimination und speichern der 1-werte in die Matrix A
				while (z < M.A.length) {
					// Elemente der Matrix L bestimmen
					double l = M.A[z][s] / M.A[s][s];
					M.A[z][s] = l;
					int k = s + 1;
					while (k < M.A[z].length) {
						M.A[z][k] = M.A[z][k] - l * M.A[s][k];
						k = k + 1;
					}
					z = z + 1;
				}
				s = s + 1;
			} else {
				sing[0] = false;
				s = M.A[0].length - 1;
			}
		}
	}
}