package beleg03;

import java.util.*;
import static java.lang.Math.*;

public class Matrix {
	double[][] A;

	Matrix(int m, int n) {
		A = new double[m][n];
	}

	Matrix scan(Scanner S) {
		System.out.println("Geben sie die Matrix ein!");
		int z = 0;
		while (z < this.A.length) {
			int s = 0;
			while (s < this.A[z].length) {
				A[z][s] = S.nextDouble();
				s = s + 1;
			}
			System.out.println();
			z = z + 1;
		}
		return this;
	}

	void print() {
		int z = 0;
		while (z < this.A.length) {
			int s = 0;
			while (s < this.A[z].length) {
				System.out.printf("%-17.12f ", A[z][s]);
				s = s + 1;
			}
			System.out.println();
			z = z + 1;
		}
		System.out.println();
	}

	void changeLine(int r, int i) {
		int s = 0;
		double[] h = new double[A[0].length];
		while (s < A[0].length) {
			h[s] = A[r][s]; // Speichern der zeile r auf h
			A[r][s] = A[i][s];
			A[i][s] = h[s];
			s++;
		}
	}

	double l_Norm() {
		// Spaltensummen bestimmen und in sum Speichern
		double[] sum = new double[A[0].length];
		int s = 0;
		while (s < A[0].length) {
			int z = 0;

			while (z < A.length) {
				sum[s] = sum[s] + abs(A[z][s]);
				z = z + 1;
			}
			s = s + 1;
		}
		double max = sum[0];
		for (int i = 0; i < sum.length; i++) {
			if (max < sum[i])
				max = sum[i];
		}

		return max;
	}

	Matrix invers() {
		Matrix h = new Matrix(A.length, A[0].length);
		this.copy(h);
		h = h.adj();
		h.transpose();
		double d = this.det();
		int z = 0;
		while (z < A.length) {
			int s = 0;
			while (s < A[z].length) {
				A[z][s] = h.A[z][s] / d;
				s = s + 1;
			}
			z = z + 1;
		}
		return this;
	}

	void transpose() {
		// Vor : m ist quadratisch
		Matrix h = new Matrix(A.length, A[0].length);
		this.copy(h);
		int z = 0;
		while (z < A.length) {
			int s = 0;
			while (s < A[z].length) {
				A[z][s] = h.A[s][z];
				s = s + 1;
			}
			z = z + 1;
		}
	}

	double det() {
		int[] p = new int[A[0].length - 1];
		int s = 0;
		while (s < A[0].length - 1) {
			p[s] = LR_DECOMP.pivotindex(this, s);
			this.changeLine(p[s], s);
			int z = s + 1;
			while (z < A.length) {
				double l = A[z][s] / A[s][s];
				int k = s;
				while (k < A[z].length) {
					A[z][k] = A[z][k] - l * A[s][k];
					k = k + 1;
				}
				z = z + 1;
			}
			s = s + 1;
		}
		// Vorzeichen der determinante bestimmen
		int v = 1;
		for (int j = 0; j < p.length; j++) {
			if (p[j] != j) {
				v = -1 * v;
			}
		}
		// Determinate ausrechnen
		double d = 1;
		int i = 0;
		while (i < A.length) {
			d = d * A[i][i];
			i = i + 1;
		}
		return v * d;
	}

	Matrix laplace(int z, int s) {
		Matrix m = new Matrix(A.length - 1, A[0].length - 1);
		int i = 0;
		int i2 = 0;
		while (i < A.length) {
			if (z == i) {
			} else {
				int j = 0;
				int j2 = 0;
				while (j < A[0].length) {
					if (s == j) {
					} else {
						m.A[i2][j2] = A[i][j];
						j2 = j2 + 1;
					}
					j = j + 1;
				}
				i2 = i2 + 1;
			}
			i = i + 1;
		}
		return m;
	}

	Matrix copy(Matrix m) {
		int z = 0;
		while (z < this.A.length) {
			int s = 0;
			while (s < this.A[z].length) {
				m.A[z][s] = this.A[z][s];
				s = s + 1;
			}
			z = z + 1;
		}
		return m;
	}

	Matrix adj() {
		Matrix h = new Matrix(A.length, A[0].length);
		this.copy(h);
		int z = 0;
		while (z < A.length) {
			int s = 0;
			while (s < A[0].length) {
				Matrix hl = new Matrix(A.length, A[0].length);
				h.copy(hl);
				hl = hl.laplace(z, s);
				A[z][s] = pow(-1, z + s) * hl.det();
				s = s + 1;
			}
			z = z + 1;
		}
		return this;
	}
}