/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.graph;

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
		System.out.print("Graph test: ");
		instance = new Graph<String>();
		instance.add("jappie");
		instance.add("pownzor");
		instance.add("mega");
		instance.add("super");
		instance.add("man");
		instance.add("henk");		
		instance.connect("jappie", "mega", (double) 10);
		instance.connect("jappie", "pownzor", (double) 53);
		instance.connect("jappie", "super", (double) 34);
		instance.connect("jappie", "man", (double) 13);
		instance.connect("man", "mega", (double) 15);
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of connect method, of class Graph.
	 */


	@Test
	public void testDisconnect() {
		System.out.println("disconnect");
		instance.disConnect("man", "mega");
		assertEquals("Data: \n" +
"		super, connections:\n" +
"\n" +
"		pownzor, connections:\n" +
"\n" +
"		henk, connections:\n" +
"\n" +
"		mega, connections:\n" +
"\n" +
"		man, connections:\n" +
"\n" +
"		jappie, connections:\n" +
"		Weight '10.0' goes to: mega\n" +
"		Weight '53.0' goes to: pownzor\n" +
"		Weight '34.0' goes to: super\n" +
"		Weight '13.0' goes to: man\n\n", instance.toString());
	}

	/**
	 * Test of delete method, of class Graph.
	 */
	@Test
	public void testDelete() {
		System.out.println("delete");
		instance.delete("henk");
		assertEquals("Data: \n" +
"		super, connections:\n" +
"\n" +
"		pownzor, connections:\n" +
"\n" +
"		mega, connections:\n" +
"\n" +
"		man, connections:\n" +
"		Weight '15.0' goes to: mega\n" +
"\n" +
"		jappie, connections:\n" +
"		Weight '10.0' goes to: mega\n" +
"		Weight '53.0' goes to: pownzor\n" +
"		Weight '34.0' goes to: super\n" +
"		Weight '13.0' goes to: man\n\n", instance.toString());
	}
}
