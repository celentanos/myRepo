package aufgabe1_Exception;

public class Exception {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] qn = {"-2","3"};
		Integer[] erg = null;
		erg = processArr(qn);
		System.out.println(erg);
		
	}
	public static Integer[] processArr(String[] quelle){
		Integer[] ziel = null;
		try{
		int zlaenge = new Integer(quelle[0]);
		if(quelle.length > 0)
			ziel = new Integer[zlaenge];
		}catch(NumberFormatException e1){
			//Ausgabe
			System.out.println("Feldlaenge ist keine Zahl!");
		}
		catch (NegativeArraySizeException e2){
			//Ausgabe
			System.out.println("Feldlaenge ist eine negative Zahl!");
		}
		catch (NullPointerException e3){
			//Ausgabe
			System.out.println("Feldlaenge wurde nicht initialisiert!");
		}
		int j=0;
		
		for (int i = 1; i < quelle.length; i++){
			Integer x = new Integer(quelle[i]);
			if (x%2 == 0){
				ziel[j] = x;
				j++;
			}
		}

		return ziel;
	}
	

}
