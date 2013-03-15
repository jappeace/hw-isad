/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.graph.Undirected;

import isad.w6.graph.Path.PathGraph;
import isad.w6.graph.Path.PathVertex;
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
		System.out.print("Graph with pathwalking test: ");
		instance = new Graph<String>();
		instance.add("jappie");
		instance.add("pownzor");
		instance.add("mega");
		instance.add("super");
		instance.add("man");
		instance.add("henk");		
		instance.connect("jappie", "pownzor", (double) 10);
		instance.connect("pownzor", "mega", (double) 53);
		instance.connect("mega", "super", (double) 34);
		instance.connect("super", "man", (double) 13);
		instance.connect("man", "henk", (double) 15);
		instance.connect("henk", "jappie", (double) 15);
		instance.connect("jappie", "super", (double) 14);
		instance.connect("super", "pownzor", (double) 230);
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of isConnected method, of class Graph.
	 */
	@Test
	public void testIsConnected() {
		System.out.println("isConnected");
		assertEquals(true, instance.isConnected());
		instance.disConnect("super", "man");
		instance.disConnect("man", "henk");
		assertEquals(false, instance.isConnected());
	}
}
