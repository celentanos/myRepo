package beleg03;

public class L_SOLVE {
	private static void b_transform(double[] b, int[] p) {
		// Index zum durchlaufen des Feldes p
		int i = 0;
		// Hi 1 Fsvariable bei der- Vertauschung
		double h = 0;
		while (i < p.length) {
			int j = p[i];
			h = b[j];
			b[j] = b[i];
			b[i] = h;
			i = i + 1;
		}
	}

	public static double[] y_Solve(Matrix M, double[] b, int[] p) {
		// Vektor y allozieren
		double[] y = new double[M.A.length];
		// Vektor b permutieren
		b_transform(b, p);
		// y ausrechnen
		y[0] = b[0];
		int z = 1;
		while (z < M.A[0].length) {
			int i = 0;
			double sum = 0;
			while (i < z) {
				sum = sum + M.A[z][i] * y[i];
				i = i + 1;
			}
			y[z] = b[z] - sum;
			z = z + 1;
		}
		return y;
	}
}
