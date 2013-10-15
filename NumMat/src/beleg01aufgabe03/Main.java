package beleg01aufgabe03;

public class Main {

	static double q = 0.43212345;
	
	public static void main(String[] args) {
		
		double p;
		
		System.out.println("\t   x21\t\t\t\t   x22\t\t\t\t  x1\t\t\tp");
		for (double ex = 0; ex <= 12; ex++){
			p = Math.pow(10, ex);
			beispiela(p);
		}
	}

	private static void beispiela(double p) {
		
		double x1, x21, x22;
		
		x1 = -p-Math.sqrt(p*p+q);
		x21 = -p+Math.sqrt(p*p+q);
		x22= -q/x1;
		System.out.printf("%.26f\t%.26f\t%.17e    %.1e\n",x21,x22,x1,p);
	}
}
