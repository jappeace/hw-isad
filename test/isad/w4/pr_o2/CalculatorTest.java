/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w4.pr_o2;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jappie
 */
public class CalculatorTest {
	
	public CalculatorTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of CalculatePostfix method, of class Calculator.
	 */
	@Test
	public void testCalculatePostfix(){
		try {
			System.out.println("CalculatePostfix");
			String sum = "5 6 +";
			Calculator instance = new Calculator();
			assertEquals(11, instance.CalculatePostfix(sum), 0.0);
			
			sum = "5 6 + 4 3 - -";
			assertEquals(10, instance.CalculatePostfix(sum), 0.0);
			
			expectException(instance, "7 + 9");
			expectException(instance, "1 1 + 1 1 + 1");
			sum = "440 4 11 * /";		
			assertEquals(10, instance.CalculatePostfix(sum), 0.0);
		} catch (Exception ex) {
			fail("unexpected exception");
		}
	}
	private void expectException(Calculator instance, String input){
		try{
			instance.CalculatePostfix(input);
			fail("Input should have thrown an exception");
		}catch(Exception e){}		
	}
}
