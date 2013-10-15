/* siehe Vorlesungsfolie 76 */
package fakultaet;

import java.util.Scanner;

public class Fakultaet {
     public static void main(String[] args) {
    	 Scanner input = new Scanner(System.in);
    	 System.out.println("Bitte geben Sie die Zahl ein: ");
    	 int zahl = input.nextInt();
    	 for (int i = 0; i<=zahl; i++)
         System.out.println(i+"! = "+f(i));
     }

     /* iterative Methode f: */
     static double f(int n) {
    	 double fak = 1L;
    	 for (int i = 1; i<=n; i++)
         fak = fak * i;
    	 return fak;
     }
}