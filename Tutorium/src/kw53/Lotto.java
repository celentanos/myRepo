package kw53;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Lotto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lotto();
	}
	
	public static void lotto(){
		Collection<Integer> lotto = new HashSet<Integer>();
		
		int doubletten = 0;
		
		while (lotto.size() < 7){
			final int num = (int) (Math.random() * 49) + 1;
			
			if(!lotto.add(num)) ++doubletten;
		}
		System.out.println("Anzahl Doubletten: " + doubletten);
		
		//Java for-each Schleife
		for (Integer num : lotto){
			System.out.println("Zahl: " + num);
		}
		
		//Iteratoren
		Iterator<Integer> it = lotto.iterator();
		
		while (it.hasNext()){
			final int num = it.next();
			System.out.println(num);
		}
	}

}
