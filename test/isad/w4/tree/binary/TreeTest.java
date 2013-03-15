/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w4.tree.binary;

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
public class TreeTest {
	Tree<String> instance;
	public TreeTest() {
		instance = new Tree<String>(
				new Node<String>("a", 
				new Node<String>("b", 
				new Node<String>("h", 
				new Node<String>("i"), 
				new Node<String>("j"))), 
				new Node<String>("c",
				new Node<String>("d", 
				new Node<String>("e", 
				new Node<String>("g"),
				new Node<String>("k",
				new Node<String>("l"), 
				new Node<String>("jappie"))), 
				new Node<String>("f")))));
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		System.out.print("Binary tree test: ");
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of size method, of class Tree.
	 */
	@Test
	public void testSize() {
		System.out.println("size");
		int expResult = 13;
		int result = instance.size();
		assertEquals(expResult, result);
	}

	/**
	 * Test of height method, of class Tree.
	 */
	@Test
	public void testHeight() {
		System.out.println("height");
		int expResult = 6;
		int result = instance.height();
		assertEquals(expResult, result);
	}

	

	/**
	 * Test of isEmpty method, of class Tree.
	 */
	@Test
	public void testIsEmpty() {
		System.out.println("isEmpty"); 
		boolean expResult = false;
		boolean result = instance.isEmpty();
		assertEquals(expResult, result);
	}

	/**
	 * Test of printPreOrder method, of class Tree.
	 */
	@Test
	public void testPrintPreOrder() {
		System.out.println("printPreOrder");
		String expResult = "abhijcdegkljappief";
		String result = instance.printPreOrder();
		assertEquals(expResult, result);
	}

	/**
	 * Test of printInOrder method, of class Tree.
	 */
	@Test
	public void testPrintInOrder() {
		System.out.println("printInOrder");
		String expResult = "ihjbagelkjappiedfc";
		String result = instance.printInOrder();
		assertEquals(expResult, result);
	}

	/**
	 * Test of printPostOrder method, of class Tree.
	 */
	@Test
	public void testPrintPostOrder() {
		System.out.println("printPostOrder");
		String expResult = "ihjbgelkjappiedfca";
		String result = instance.printPostOrder();
		assertEquals(expResult, result);
	}

	/**
	 * Test of countLeaves method, of class Tree.
	 */
	@Test
	public void testCountLeaves() {
		System.out.println("countLeaves");
		
		assertEquals(6, instance.countLeaves(0));
		assertEquals(2, instance.countLeaves(1));
		assertEquals(5, instance.countLeaves(2));
		assertEquals(0, instance.countLeaves(3));
		assertEquals(0, instance.countLeaves(-1));
	}
}
