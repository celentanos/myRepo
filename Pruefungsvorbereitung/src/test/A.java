package test;

import java.util.Map;
import java.util.TreeMap;

public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	public static boolean test(R a, S b){
		return false;
		
	}
	
	public static Map<R,S> m(Map<R,S> oe){
		Map<R,S> ork = new TreeMap<R,S>(); 
		boolean p = false;
		for (R r : oe.keySet()){
			S s = oe.get(r);
			
			if (test(r,s) == true){
				ork.put(r, s);

			}
			
		}
		return ork;
	}

}
