package beleg03;

public class R_SOLVE {
	public static double[] x_Solve(Matrix M, double[] y) {
		// Vektor y allozieren
		double[] x = new double[M.A.length];
		// x ausrechnen
		x[x.length - 1] = y[y.length - 1]
				/ M.A[M.A.length - 1][M.A[0].length - 1];
		int z = x.length - 2;
		while (z > -1) {
			int i = M.A[0].length - 1;
			double sum = 0;
			while (i > z) {
				sum = sum + M.A[z][i] * x[i];
				i = i - 1;
			}
			x[z] = (y[z] - sum) / M.A[z][z];
			z = z - 1;
		}
		return x;
	}
}