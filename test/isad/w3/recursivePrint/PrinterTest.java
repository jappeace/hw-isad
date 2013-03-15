/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w3.recursivePrint;

import java.util.ArrayList;
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
public class PrinterTest {
	
	public PrinterTest() {
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
	 * Test of printForward method, of class Printer.
	 */
	@Test
	public void testPrintForward() {
		System.out.println("recursive printForward test");
		ArrayList<Integer> theList = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++){
			theList.add(i);
		}
		int i = 3;
		Printer instance = new Printer();
		String expResult = " 3 4 5 6 7 8 9";
		String result = instance.printForward(theList, i);
		assertEquals(expResult, result);
	}
	@Test
	public void testPrintBackward() {
		System.out.println("recursive printBackward test");
		ArrayList<Integer> theList = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++){
			theList.add(i);
		}
		int i = 3;
		Printer instance = new Printer();
		String expResult = "9 8 7 6 5 4 3 ";
		String result = instance.printBackward(theList, i);
		assertEquals(expResult, result);
	}
}
