package fibonacci;

import java.util.Scanner;

public class FibonacciIt {
    public static void main (String [] args) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Bitte geben Sie die Zahl ein: ");
    	int maxzahl = input.nextInt();
        double [] fib = new double [maxzahl+1];
        fib[1]=1;
        fib[2]=1;
        System.out.println("1: " + fib[1]);
        System.out.println("2: " + fib[2]);
        for (int i = 3; i <= maxzahl; i++) {
            fib[i] = fib[i-1] + fib[i-2];
            System.out.println(i + ": " + fib[i]);
        }
    }
}
