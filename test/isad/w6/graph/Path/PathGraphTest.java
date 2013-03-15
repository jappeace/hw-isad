/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.graph.Path;

import isad.w6.graph.Path.PathStrategy.Strategy;
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
public class PathGraphTest {
	Graph<String> instance, resultGraph;
	Vertex<String> resultVertex;
	public PathGraphTest() {
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
		resultGraph = null;
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
	 * Test of add method, of class PathGraph.
	 */
	@Test
	public void testUnweigted() {
		System.out.println("Unweighted");
		
		instance.setStrategy(Strategy.NotWeighted);
		resultGraph = instance.Find("jappie");
		assertEquals("Data: \n" +
					"		jappie(0.0)->super(1.0)\n" +
					"		jappie(0.0)->pownzor(1.0)\n" +
					"		jappie(0.0)->super(1.0)->man(2.0)->henk(3.0)\n" +
					"		jappie(0.0)->pownzor(1.0)->mega(2.0)\n" +
					"		jappie(0.0)->super(1.0)->man(2.0)\n" +
					"		jappie(0.0)\n" +
					"", resultGraph.toString());
		
		resultVertex = instance.Find("jappie", "henk");
		assertEquals("jappie(0.0)->super(1.0)->man(2.0)->henk(3.0)", resultVertex.toString());
	}
	
	@Test
	public void testWeighted(){
		System.out.println("Weighted");
		
		instance.setStrategy(Strategy.PositiveWeighted);
		resultGraph = instance.Find("jappie");
		assertEquals("Data: \n" +
					"		jappie(0.0)->super(14.0)\n" +
					"		jappie(0.0)->pownzor(10.0)\n" +
					"		jappie(0.0)->super(14.0)->man(27.0)->henk(42.0)\n" +
					"		jappie(0.0)->pownzor(10.0)->mega(63.0)\n" +
					"		jappie(0.0)->super(14.0)->man(27.0)\n" +
					"		jappie(0.0)\n" +
					"", resultGraph.toString());
		
		resultVertex = instance.Find("jappie", "henk");
		assertEquals("jappie(0.0)->super(14.0)->man(27.0)->henk(42.0)", resultVertex.toString());
		
		instance.connect("jappie", "henk", 5.3);
		resultVertex = instance.Find("jappie", "henk");
		assertEquals("jappie(0.0)->henk(5.3)", resultVertex.toString());
		
	}
	
	@Test
	public void testNegativeWeighted(){
		System.out.println("Negative weighted");
		
		instance.setStrategy(Strategy.NegativeWeighted);
		resultGraph = instance.Find("jappie");
		assertEquals("Data: \n" +
					"		jappie(0.0)->super(14.0)\n" +
					"		jappie(0.0)->pownzor(10.0)\n" +
					"		jappie(0.0)->super(14.0)->man(27.0)->henk(42.0)\n" +
					"		jappie(0.0)->pownzor(10.0)->mega(63.0)\n" +
					"		jappie(0.0)->super(14.0)->man(27.0)\n" +
					"		jappie(0.0)\n" +
					"", resultGraph.toString());
		
		resultVertex = instance.Find("jappie", "henk");
		assertEquals("jappie(0.0)->super(14.0)->man(27.0)->henk(42.0)", resultVertex.toString());
		
		instance.connect("jappie", "henk", -5.3);
		resultVertex = instance.Find("jappie", "henk");
		assertEquals("jappie(0.0)->henk(-5.3)", resultVertex.toString());
		
		instance.disConnect("jappie", "henk");
		instance.reConnect("jappie", "pownzor", -5.1);
		
		resultGraph = instance.Find("man");	
		assertEquals("Data: \n" +
					"		man(0.0)->henk(15.0)->jappie(30.0)->super(44.0)\n" +
					"		man(0.0)->henk(15.0)->jappie(30.0)->pownzor(24.9)\n" +
					"		man(0.0)->henk(15.0)\n" +
					"		man(0.0)->henk(15.0)->jappie(30.0)->pownzor(24.9)->mega(77.9)\n" +
					"		man(0.0)\n" +
					"		man(0.0)->henk(15.0)->jappie(30.0)\n" +
					"", resultGraph.toString());
		
		instance.reConnect("henk", "jappie", -20.0);
		instance.reConnect("super", "man", -35.0);
		
		try{
			instance.Find("man");
			fail("Code is rigged to produce a negative loop. An exception is excpected");
		}catch(IllegalArgumentException e){
			assertEquals("NegativeWeigted is caught in a negative cycle", e.getMessage());
		}
		
	}	
}
