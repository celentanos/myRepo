package kaffekanne;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Kaffekanne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int s, w, j = 1;
		
		ArrayList<Integer> kanne = new ArrayList<Integer>();
		
		Random zufal = new Random();
		
		Scanner eingabe = new Scanner(System.in);
		
		System.out.println("Bitte geben Sie Anzahl der schwarzen Bohnen an: ");
		s = eingabe.nextInt();
		System.out.println("Bitte geben Sie Anzahl der weißen Bohnen an: ");
		w = eingabe.nextInt();
		
		int gesammt = s + w;
		for (int i = 0; i < gesammt; i++){
			kanne.add(i, zufal.nextInt(2));
		}
		for (int i = 0; i < gesammt; i++){
			System.out.println(j + ". " + kanne.get(i));
			j++;
		}
	}

}
