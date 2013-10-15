package beleg01aufgabe02;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("\tV\t\t\tVg\t\t\tR\t\t\tRg");
		for (int k = 0; k < 31; k++){
			System.out.printf("%.16e\t",V(k));
			System.out.printf("%.16e\t",Vgestoert(k));
			System.out.printf("%.16e\t",R(k));
			System.out.printf("%.16e\n", Rgestoert(k));
		}
	}
	
	public static double V(int k) {
		if(k==0){
			return (Math.exp(1)-1)/Math.exp(1);
		}
		else {
			return 1-k*V(k-1);
		}
	}
	
	public static double Vgestoert(int k) {
		if(k==0){
			return ((Math.exp(1)-1)/Math.exp(1)) + Math.pow(10, -6);
		}
		else {
			return 1-k*Vgestoert(k-1);
		}
	}

	public static double R(int k){
		if(k==40){
			return 0.7/41;
		}
		else{
			return (1-R(k+1))/(k+1);
		}
	}
	
	public static double Rgestoert(int k){
		if(k==40){
			return 0.7/41 + .1;
		}
		else{
			return (1-Rgestoert(k+1))/(k+1);
		}
	}
}
