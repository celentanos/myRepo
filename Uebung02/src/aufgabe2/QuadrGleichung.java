package aufgabe2;

import java.util.Scanner;
import static java.lang.Math.sqrt;

public class QuadrGleichung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		double a, b, c, d, x1, x2;
		System.out.print("Geben Sie bitte Koeffizient a ein: ");
		a = in.nextInt();
		System.out.print("Geben Sie bitte Koeffizient b ein: ");
		b = in.nextInt();
		System.out.print("Geben Sie bitte Koeffizient c ein: ");
		c = in.nextInt();
		d = (b*b)/((2*a)*(2*a))-(c/a);
		System.out.println();
		if (a == 0 || a == 0.000001){
			x1 = -c/b;
			System.out.printf("x1 = x2 = %4.2f \n" ,x1);
		}
		else{
			if (d < 0){
				System.out.printf("Diskriminante = %4.2f \n",d);
				System.out.println();
				System.out.print("Diskriminante < 0 ---> die Gleichung ist nicht lösbar!");			
			}
			/*if (d == 0){
				System.out.printf("Diskriminante = %4.2f \n",d);
				x1 = -(b/2*a);
				System.out.println();
				System.out.printf("x1 = x2 = %4.2f \n" ,x1);
			}*/
			if (d >= 0){
				System.out.printf("Diskriminante = %4.2f \n",d);
				x1 = -(b/2*a) + sqrt(d);
				x2 = -(b/2*a) - sqrt(d);
				System.out.println();
				System.out.printf("x1 = %4.2f \nX2 = %4.2f \n" ,x1,x2);
			}
			
		}
		
	}

}
