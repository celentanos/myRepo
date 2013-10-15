package aufgabe1;

import java.util.Scanner;

public class Ggt {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int n, m, r;
		System.out.print("x = ");
		int x = input.nextInt();
		System.out.print("y = ");
		int y = input.nextInt();
		n = x;
		m = y;
		r = n % m;
		while (r != 0) {
			n = m;
			m = r;
			r = n % m;
		}
		System.out.println("Der ggT von " + x + " und " + y + " ist " + m);
	}
}
