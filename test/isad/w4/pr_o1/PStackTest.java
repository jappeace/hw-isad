/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w4.pr_o1;

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
public class PStackTest {
	
	public PStackTest() {
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
	 * Test of Push method, of class PStack.
	 */
	@Test
	public void testPush() {
		System.out.println("Push stack");
		String[] data = new String[]{"blah", "blie", "bloeh"};
		PStack<String> instance = new PStack<String>();
		for(String element : data){
			instance.Push(element);
		}
		try {
			assertEquals(instance.Top(), "bloeh");
		} catch (Exception ex) {
			fail("Push did not add anything");
		}
		
	}

	/**
	 * Test of Pop method, of class PStack.
	 */
	@Test
	public void testPop() throws Exception {
		System.out.println("Pop stack");
		String[] data = new String[]{"blah", "blie", "bloeh"};
		PStack<String> instance = new PStack<String>();
		for(String element : data){
			instance.Push(element);
		}
		try {
			assertEquals(instance.Pop(), "bloeh");
			assertEquals(instance.Pop(), "blie");
			assertEquals(instance.Pop(), "blah");
			
		} catch (Exception ex) {
			fail("Push did not add anything");
		}
		try{
			instance.Top();
			fail("Stack should be empty");
		}catch(Exception ex){
			
		}
	}

	/**
	 * Test of Print method, of class PStack.
	 */
	@Test
	public void testPrint() {
		System.out.println("Print stack");
		String[] data = new String[]{"blah", "blie", "bloeh"};
		PStack<String> instance = new PStack<String>();
		for(String element : data){
			instance.Push(element);
		}
		
		assertEquals("bloeh, blie, blah", instance.Print());
	}
}
