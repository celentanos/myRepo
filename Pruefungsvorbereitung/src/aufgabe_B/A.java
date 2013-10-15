package aufgabe_B;

public class A {
	public static void main(String[] args) {

		if (args.length > 0){
			try{
				System.out.println(new Integer(args[2]));
			}
			catch(Exception e){
				System.out.println("Petermana na mylo!!!");
			}
		}
	}
}
//1. Alle Zeichen auﬂer Zahlen(Integerzeug) sind Ausnahmen...