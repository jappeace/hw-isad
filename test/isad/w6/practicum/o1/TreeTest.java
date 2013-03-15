/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.practicum.o1;

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
	Tree<Integer> instance;
	public TreeTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		System.out.print("Practicum bullshit: ");
		Node<Integer> root = new Node<Integer>(6, null, new Node<Integer>(4, 
							new Node<Integer>(8), new Node<Integer>(3, 
							new Node<Integer>(7, null, new Node<Integer>(1)), 
							new Node<Integer>(2, new Node<Integer>(1)))));
		instance = new Tree<Integer>(root);
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testTreePreOrder() {
		System.out.println("tree working");

		assertEquals("64837121", instance.printPreOrder());
		
	}
	
	@Test
	public void testCoordinates() {
		System.out.println("coordinates");
		instance.calcX();
		instance.calcY();
		assertEquals("6(1,5)4(2,4)8(1,1)3(5,3)7(3,2)1(4,1)2(7,2)1(6,1)", instance.printPreWithCoordinates());
		
	}
}
