/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w7.practicum.depthFirst;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		instance.undirectedConnect("A", "C");
		instance.undirectedConnect("A", "D");
		instance.undirectedConnect("D", "C");
		instance.undirectedConnect("C", "F");
		instance.undirectedConnect("C", "B");
		instance.undirectedConnect("F", "G");
		instance.undirectedConnect("F", "E");
		instance.undirectedConnect("B", "E");
		instance.undirectedConnect("E", "H");
		instance.undirectedConnect("E", "I");
		instance.undirectedConnect("I", "K");
		instance.undirectedConnect("K", "J");
		instance.undirectedConnect("J", "H");
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
		String result = instance.DepthFirstSearch("F", "I");
		assertEquals("C,A,C,A,D,C,A,B,E,H,J,K,I,", result);
	}

}
