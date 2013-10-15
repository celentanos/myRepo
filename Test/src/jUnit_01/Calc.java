package jUnit_01;

public class Calc {

	public static void main(String[] args) {
		int i = add(2, 5);
		int j = div(10, 5);
		System.out.println("add: " + i);
		System.out.println("div: " + j);
	}
	
	public static int add(int a, int b){
		return a + b;
	}
	
	public static int div(int a, int b){
		return a / b;
	}
}
