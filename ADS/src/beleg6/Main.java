package beleg6;

import java.util.Random;

public class Main {

	static int n = 10000;

	static Random zufall = new Random();

	static GraphListe liste = new GraphListe(n);

	static GraphMatrix matrix = new GraphMatrix(n);

	public static void main(String[] args) {

		//add_2n_liste();
		
		//add_2n_matrix();
		
		add_n2_liste();
		
		add_n2_matrix();
	}

	private static void add_n2_liste() {
		
		long time = System.currentTimeMillis();
		
		for(int i = 1; i < n+1; i++)
			for(int j = 1; j < n+1; j++)
				liste.addKante(i,j);
		
		System.out.println(System.currentTimeMillis() - time);
		
	}

	private static void add_n2_matrix() {
		
		long time = System.currentTimeMillis();
		
		for(int i = 1; i < n+1; i++)
			for(int j = 1; j < n+1; j++)
				matrix.addKante(i,j);
		
		System.out.println(System.currentTimeMillis() - time);
		
	}

	private static void add_2n_matrix() {
		
		long time = System.currentTimeMillis();
		
		for(int i = 0; i < 2*n; i++) {
			
			int x = zufall.nextInt(n)+1;
			int y = zufall.nextInt(n)+1;
		
			matrix.addKante(x,y);
		}
		
		System.out.println(System.currentTimeMillis() - time);
		
	}

	private static void add_2n_liste() {
		
		long time = System.currentTimeMillis();
		
		for(int i = 0; i < 2*n; i++) {
			
			int x = zufall.nextInt(n)+1;
			int y = zufall.nextInt(n)+1;
		
			liste.addKante(x,y);
		}
		
		System.out.println(System.currentTimeMillis() - time);
	}
}
