package u2013_04_11;

import static org.junit.Assert.*;
import org.junit.Test;

public class Main {
	
	static Tree<Boolean> full (int d){
		if(d > 0){
			return new Branch<Boolean>(Main.full(d-1), Main.full(d-1));			
		}else{
			return new Leaf<Boolean>(false);
		}
	}

	@Test
	public void sizefull(){
		assertEquals(15,Main.full(3).size());
	}
	
	public static void main(String[] args) {
		System.out.println(Main.full(3));

	}
}
