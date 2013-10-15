package beleg01aufgabe01;

public class Main {

	static double exact1 = Math.sqrt(Math.exp(1));
	static double exact2 = -1/((0.25-0.0169)*(0.25-0.0169));
	
	public static void main(String[] args) {
		
		double h;
		System.out.println(exact1);
		System.out.println("\th\t\t      deltaf1\t\t  delta f1-f'(x0)\t" +
						   "     delta f2\t\t  delta f2-f'(x0)");
		for (double ex = -1;ex>=-11;ex-=0.5){
			h = Math.pow(10, ex);

			beispiela(h);
		}
		System.out.println();
		System.out.println(exact2);
		System.out.println("\th\t\t\tdelta f1\t  delta f1-f'(x0)\t" +
						   "       delta f2\t\t  delta f2-f'(x0)");
		for (double ex = -1;ex>=-11;ex-=0.5){
			h = Math.pow(10, ex);

			beispielb(h);
		}
	}
	
	private static void beispielb(double h) {
		double dif1,dif2, err1, err2, x = 1/((0.5+0.13)*(0.5-0.13));
		
		dif1 = (1/((0.5+h+0.13)*(0.5+h-0.13))-(1/((0.5+0.13)*(0.5-0.13))))/h;
		dif2 = (1/((0.5+h+0.13)*(0.5+h-0.13))-(1/((0.5-h+0.13)*(0.5-h-0.13))))/(2*h);
		
		err1 = Math.abs(exact2 - dif1);
		err2 = Math.abs(exact2 - dif2);
		
		System.out.printf("%.16f\t%.16f\t%.16f\t%.16f\t%.16f\n",h,dif1,err1,dif2,err2);		
	}

	public static void beispiela(double h){
		double dif1,dif2, err1, err2;
		
		dif1 = (Math.exp(0.5+h)-Math.exp(0.5))/h;
		dif2 = (Math.exp(0.5+h)-Math.exp(0.5-h))/(2*h);
		
		err1 = Math.abs(exact1 - dif1);
		err2 = Math.abs(exact1 - dif2);
		
		System.out.printf("%.16f\t%.16f\t%.16f\t%.16f\t%.16f\n",h,dif1,err1,dif2,err2);
	}
}
