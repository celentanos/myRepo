package fibonacci;

import java.util.Scanner;

public class Fibonacci {

    static int fibonacci(int n) {
        if ((n==1) || (n==2)) return 1;
        else return fibonacci(n-1)+fibonacci(n-2);
    }

    public static void main (String [] args) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Bitte geben Sie die Zahl ein: ");
    	int maxzahl = input.nextInt();
        for (int i = 1; i<=maxzahl; i++) {
            System.out.println(i + ": " + fibonacci(i));
        }
    }
}
