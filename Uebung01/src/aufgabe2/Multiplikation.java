package aufgabe2;

import java.util.Scanner;

public class Multiplikation {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);		
		
		int akku = 0;
		System.out.print("x = ");
		int x = input.nextInt();
		System.out.print("y = ");
		int y = input.nextInt();
		if (x < 0){
			x = -x;
			y = -y;
		}
		while (x > 0) {
			if (x % 2 == 0){
				x = x / 2;
				y = y * 2;
			}
			else {
				akku = akku + y;
				x = (x-1)/2;
				y = y * 2;
			}
		}
		System.out.println(akku);
	}
}
