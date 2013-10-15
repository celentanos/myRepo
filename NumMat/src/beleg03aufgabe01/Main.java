package beleg03aufgabe01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Geben Sie die Matrixdimension an:");
		int n = input.nextInt();
		double A[][] = new double[n][n];
		double A_inverse[][] = new double[n][n];
		double b[] = new double[n];
		int p[] = new int[n-1];
		double y[] = new double[n];
		double x[] = new double[n];
	//--Eingane----------------------------------------------------
		System.out.println("Geben Sie Matrixelemente ein:");
		for (int zeile = 0; zeile < n; zeile++){
			for (int zeilen_el = 0; zeilen_el < n; zeilen_el++){
				A[zeile][zeilen_el] = input.nextDouble();
			}
			System.out.println();
		}
		System.out.println("Geben Sie dan Vektor b ein:");
		for (int i = 0; i < n; i++){
			b[i] = input.nextDouble();
		}
		System.out.println("Die zu berechnete LGS:");
		matrixAusgabe(A, n);
		System.out.println();
		for(int i = 0; i < n; i++){
			System.out.printf("%16.10f", b[i]);
		}
	//-------------------------------------------------------------
		try {
			LR_DECOMP(A, n, p);
			System.out.println("\nLR-Faktorisierung:");
			matrixAusgabe(A, n);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		System.out.print("\nPivotmenge:");
		for (int i = 0; i < n - 1; i++){
			System.out.print(" " + p[i]);
		}
	//--Loop-inverse-Matrix----------------------------------------
		for (int i = 0; i < n; i++){
			double e[] = new double[n];
			e[i] = 1;
			L_SOLVE(A, y, p, e, n);
			R_SOLVE(A, x, y, n);
			for (int j = 0; j < n; j++){
				A_inverse[j][i] = x[j];
			}
		}
		System.out.println("\n\nDie Lösung lautet:");
		System.out.println("\nInverse Matrix:");
		matrixAusgabe(A_inverse, n);
	//--X-Vektor---------------------------------------------------
		L_SOLVE(A, y, p, b, n);
		R_SOLVE(A, x, y, n);
		System.out.println("\nx-Vektor ist gleich:");
		for (int zeile = 0; zeile < n; zeile++){
				System.out.printf("%16.10f", x[zeile]);
		}
	}
	
	public static void LR_DECOMP(double [][] A, int n, int p[]) throws Exception{
		int hauptschritt = 0;
		double first_norm = 0;
		int pivot = hauptschritt;
		for (hauptschritt = 0; hauptschritt < n-1; hauptschritt++){
		//--Pivot Auswahl-----------
			double as = 0;
			for (int zeile = hauptschritt; zeile < n; zeile++){
				double temp_as = 0;
				double temp_first_norm = 0;
				for(int zeilen_el = hauptschritt; zeilen_el < n; zeilen_el++){
					temp_as += Math.abs(A[zeile][zeilen_el]);
					temp_first_norm += Math.abs(A[zeilen_el][zeile]);
				}
				temp_as = A[zeile][hauptschritt]/temp_as;
				if (temp_as > as){
					pivot = zeile;
					as = temp_as;
				}
				if (temp_first_norm > first_norm){
					first_norm = temp_first_norm;
				}
			}
			p[hauptschritt] = pivot;
		//--Zeilenvertauschung------
			double temp[] = A[hauptschritt];
			A[hauptschritt] = A[pivot];
			A[pivot] = temp;
		//--letztes L-Matrix Element
			for(int  i = hauptschritt + 1; i < n; i++){
				A[i][hauptschritt] /= A[hauptschritt][hauptschritt];
			}
		//--R-Matrix----------------
			for(int zeile = hauptschritt + 1; zeile < n; zeile++){
				for (int zeilen_el = hauptschritt + 1; zeilen_el < n; zeilen_el++){
					A[zeile][zeilen_el] -= A[zeile][hauptschritt] * A[hauptschritt][zeilen_el];
				}
			}
		}
		//--SING--------------------
		double sing = first_norm * MachineEpsilonDouble();
		System.out.println("\n\nSING: " + sing);
		if (A[pivot][hauptschritt] < sing){
			throw new Exception ("Fehler! Pivotelement zu klein!");
		}
		return;
	}
	
	public static void L_SOLVE(double [][] A, double y[], int p[], double b[], int n){
		double temp = 0;
		for(int i = 0; i < n - 1; i++){
			temp = b[i];
			b[i] = b[p[i]];
			b[p[i]] = temp;
		}
		for (int zeile = 0; zeile < n; zeile++){
			double vorsum = 0;
			for (int zeilen_el = 0; zeilen_el < zeile; zeilen_el++){
				vorsum += A[zeile][zeilen_el] * y[zeilen_el];
			}
			y[zeile] = b[zeile] - vorsum;
		}
		return;
	}

	public static void R_SOLVE(double [][] A, double x[], double y[], int n){
		for (int zeile = n-1; zeile >= 0; zeile--){
			double vorsum = 0;
			for (int zeilen_el = n - 1; zeilen_el > zeile; zeilen_el--){
				vorsum += A[zeile][zeilen_el] * x[zeilen_el];
			}
			y[zeile] -= vorsum;
			x[zeile] = y[zeile]/A[zeile][zeile];
		}
		return;
	}
	
    private static double MachineEpsilonDouble() {
        double machEps = 1.0f;
        do
           machEps /= 2.0f;
        while ((double) (1.0 + (machEps / 2.0)) != 1.0);
        return machEps;
    }
    
    public static void matrixAusgabe(double [][] A, int n){
    	for (int zeile = 0; zeile < n; zeile++){
			for (int zeilen_el = 0; zeilen_el < n; zeilen_el++){
				System.out.printf("%16.10f", A[zeile][zeilen_el]);
			}
			System.out.println();
		}
    }
}