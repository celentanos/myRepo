package jUnit_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTest {

	@Test
	public void testAdd() {
		int rez = Calc.add(2, 5);
		assertEquals("bla bla", 7, rez);
	}

	@Test
	public void testDiv() {
		assertEquals("bla bla", 2, Calc.div(10, 5));
		try{
			Calc.div(2, 0);
			fail("should be exception");
		}catch(Exception e){
			fail("do nothing, it must be");
		}
	}
	
	@Test(expected = ArithmeticException.class)
	public void testDivException() {
		Calc.div(2, 0);
	}
}
