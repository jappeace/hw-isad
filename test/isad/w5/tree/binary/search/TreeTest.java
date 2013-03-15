/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w5.tree.binary.search;

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
	Tree instance;
	public TreeTest() {
		instance = new Tree(4);
		Integer[] testData = {1, 9, 3, 0, 4, 7, 8, 10, 111, 23};
		for(Integer data : testData){
			instance.insert(data);
		}
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		System.out.print("Binary tree: ");
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of insert method, of class Tree.
	 */
	@Test
	public void testInsert() {
		System.out.println("insert");
		assertEquals("013447891023111", instance.toString());
		
	}
	/**
	 * Test of insert method, of class Tree.
	 */
	@Test
	public void testRemove() {
		System.out.println("remove");
		instance.remove(9);
		instance.remove(111);
		assertEquals("01344781023", instance.toString());
		
	}
	/**
	 * Test of insert method, of class Tree.
	 */
	@Test
	public void testFindMin() {
		System.out.println("findmin");
		assertEquals(0, instance.findMin());
		
	}
	/**
	 * Test of insert method, of class Tree.
	 */
	@Test
	public void testFindMax() {
		System.out.println("findmax");
		assertEquals(111, instance.findMax());
		
	}
		/**
	 * Test of insert method, of class Tree.
	 */
	@Test
	public void find() {
		System.out.println("findmax");
		assertEquals(4, instance.find(4));
		
	}
	
	
}
