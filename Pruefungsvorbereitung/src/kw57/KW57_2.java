package kw57;

//2.
/*
public class Main{

	public static void main(String[] args) {
		System.out.println(stringToInt("1000101101a10101", 2));
	}
	protected static int stringToInt(String s, int base){
		
		try{
			return Integer.parseInt(s, base);
		}
		catch (Exception e){
			return 0;
		}
	}
}
*/
//3.
public class KW57_2 {

	public static void main(String[] args) {
		try{
			System.out.println(stringToInt("100010110110101", 2));
		}
		catch(Exception e){
			System.out.println("Fehler!");
		}
	}
	protected static int stringToInt(String s, int base){
		return Integer.parseInt(s, base);
	}
}