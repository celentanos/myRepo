package aufgabe2;

import java.util.Scanner;

public class Aufgabe2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n;
		int i, y;
		do {
			System.out.print("Geben Sie die Groesse ein: ");
			n = in.nextInt();
			y = 1;
			for (i = 1; i <= n; i++){
				for (int j = 1; j <= n; j++){
					System.out.printf("%4d",y);
					y = y + 1;
				}
				System.out.println();
				y = i + 1;
			}
		} while (n > 0);
	}
}
