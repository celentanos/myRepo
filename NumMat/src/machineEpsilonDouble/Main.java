package machineEpsilonDouble;

public class Main {

	public static void main(String[] args) {
		System.out.println(MachineEpsilonDouble());
	}
	
    private static double MachineEpsilonDouble() {
        double machEps = 1.0f;
        do
           machEps /= 2.0f;
        while ((double) (1.0 + (machEps / 2.0)) != 1.0);
        return machEps;
    }

}

