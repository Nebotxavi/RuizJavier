package test;

import org.junit.Test;
import org.junit.*;
import junit.framework.TestCase; 

import calculadora.RPN;


public class Testing extends TestCase {

	@Test
	public void testAdd() {
		String linea = "10 10 +";
		RPN calc = new RPN(linea);
		
		assertEquals(20.000000, calc.resultado());
		assertEquals(10.0 + 10.0, calc.resultado());
		assertNotSame(20, calc.resultado());
	}
	
	@Test
	public void testSubs() {
		String linea = "3 4 -";
		RPN calc = new RPN(linea);
		
		assertEquals(-1.000000, calc.resultado());
		assertEquals(3.0 - 4.0, calc.resultado());
		assertNotSame(-1, calc.resultado());
	}
	
	@Test
	public void testOthers() {
		String linea = "13 4 /";
		RPN calc = new RPN(linea);
		
		assertEquals(3.250000, calc.resultado());
		assertEquals( 13.0 / 4.0 , calc.resultado());
	}
}
