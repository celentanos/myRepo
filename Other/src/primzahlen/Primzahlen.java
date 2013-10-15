package primzahlen;

import java.util.Scanner;

public class Primzahlen{
    public static void main(String[] args){
    	Scanner input = new Scanner(System.in);
    	System.out.println("Bitte geben Sie minimale Zahl ein: ");
    	int minzahl = input.nextInt();
    	System.out.println("Bitte geben Sie maximale Zahl ein: ");
    	int maxzahl = input.nextInt();
        int zahl;								// Zu überprüfende Zahl
        int zaehler;							// Durch diese Zahl soll geteilt werden
        int teiler;								// Anzahl der möglichen Teiler
        int zahl2;								// Rest bei der Division
        for (zahl = minzahl; zahl <= maxzahl; zahl++){	// zahl <= x   ist der zu überprüfende Zahlenraum
            if (zahl == 1)						// Ausschluss der Zahl 1 als Primzahl
            System.out.println("");
            else{
            	teiler = 0;
                for (zaehler = 1; zaehler <= zahl; zaehler++){
                	// Es empfiehlt sich den Terminationswert auf zahl zu 
                    //setzen und nicht auf limit, da die Berechnung von Primzahlen 
                    //bis zu Milliardenbeträgen sonst nur äußerst langsam 
                    //funktioniert. Die Teilung durch Zahlen, die größer sind als 
                    //die zu überprüfende Zahl selbst ist ohne hin obsolet.
                	zahl2 = zahl % zaehler;		// Division der Ausgangszahl durch eine weitere und ablegen in der Variabel zahl2
                    if (zahl2 == 0)				// Falls der Rest gleich 0 ist ist ein Teiler gefunden
                    teiler++;
                }
                if (teiler == 2)				// Wenn die Zahl genau 2 Teiler hat ist sie eine Primzahl
                System.out.println(zahl+" ist eine Primzahl, da sie genau "+teiler+" Teiler hat");
                /*else							// Andernfalls ist sie keine Primzahl
                System.out.println(zahl+" ist KEINE Primzahl");*/    
            }
        }
    }
}
