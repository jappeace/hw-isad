/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w7.practicum.depthFirst;

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
public class GraphTest {
	Graph<String> instance;	
	public GraphTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		System.out.print("Practicum onzin: ");
		instance = new Graph<String>();
		instance.add("A");
		instance.add("B");
		instance.add("C");
		instance.add("D");
		instance.add("E");
		instance.add("F");
		instance.add("G");		
		instance.add("H");
		instance.add("I");
		instance.add("J");		
		instance.add("K");		
		instance.connect("A", "C");
		instance.connect("A", "D");
		instance.connect("D", "C");
		instance.connect("C", "F");
		instance.connect("C", "B");
		instance.connect("F", "G");
		instance.connect("F", "E");
		instance.connect("B", "E");
		instance.connect("E", "H");
		instance.connect("E", "I");
		instance.connect("I", "K");
		instance.connect("K", "J");
		instance.connect("J", "H");
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of DepthFirstSearch method, of class Graph.
	 */
	@Test
	public void testDepthFirstSearch() {
		System.out.println("DepthFirstSearch");
		String result = instance.DepthFirstSearch("I");
		assertEquals("", result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
