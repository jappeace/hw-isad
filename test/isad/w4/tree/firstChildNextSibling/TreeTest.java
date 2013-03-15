/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w4.tree.firstChildNextSibling;

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
public class TreeTest {
	Subtree instance ;
	public TreeTest() {
		instance = new Tree<String>(
				new Node<String>("a", 
				new Node<String>("b", new Node<String>("f", new Node<String>("g"), true), 
				new Node<String>("c", new Node<String>("d", new Node<String>("h"), new Node<String>("e",
				new Node<String>("i", new Node<String>("j", new Node<String>("k")), true))), true))));
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
	 * Test of printPreOrder method, of class Tree.
	 */
	@Test
	public void testPrintPreOrder() {
		System.out.println("tree printPreOrder");
		String expResult = "abfgcdheijk";
		String result = instance.printPreOrder();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getSize method, of class Tree.
	 */
	@Test
	public void testGetSize() {
		System.out.println("tree getSize");
		int expResult = 11;
		int result = instance.getSize();
		assertEquals(expResult, result);
	}
}
