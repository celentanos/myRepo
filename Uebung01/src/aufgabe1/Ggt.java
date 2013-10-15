package aufgabe1;

import java.util.Scanner;

public class Ggt {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input = new Scanner(System.in);		
		
int n , m , r;
System.out.println("x= ");
int x = input.nextInt();
System.out.println("y= ");
int y = input.nextInt();
n = x; m = y;
r = n % m;
while (r!=0){
	n = m;
	m = r;
	r = n % m;
}
System.out.println( "Der ggT von "+ x +" und "+ y +" ist "+ m);
	}

}
