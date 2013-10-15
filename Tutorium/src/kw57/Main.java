package kw57;

public class Main {

	public static void main(String[] args) {
		try{
			System.out.println(stringToInt("10001010101010101", 2));
		}
		catch (NumberFormatException e){
			System.out.println("Fehler!");
		}
		
		finally {
			System.out.println("Fertig!");
		}
	}
	
	protected static int stringToInt(String s, int base){
		return Integer.parseInt(s, base);
		/*
		try{
			return Integer.parseInt(s, base);
		}
		catch (Exception e){
			return 0;
		}
		*/
	}
}
