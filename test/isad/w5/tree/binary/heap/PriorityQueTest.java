/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w5.tree.binary.heap;

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
public class PriorityQueTest {
	PriorityQue<String> instance;
	public PriorityQueTest() {
		instance = new PriorityQue<String>();

		
		
	}
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		System.out.print("Priority que: ");
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of enque method, of class PriorityQue.
	 */
	@Test
	public void enque() {
		System.out.println("enque");

		instance.enque("jappie", 1);
		instance.enque("neger", 9999999);
		instance.enque("jappeace laptop", 20);
		instance.enque("blah", 90);
		instance.enque("puk van de petervlet", 400);
		instance.enque("clone jappie",1);
		instance.enque("tim", 232);
		instance.enque("boeh", 89);
		assertEquals("jappie", instance.deque());
		assertEquals("clone jappie", instance.deque());
		assertEquals("jappeace laptop", instance.deque());
		assertEquals("boeh", instance.deque());
		assertEquals("blah", instance.deque());
		assertEquals("tim", instance.deque());
		assertEquals("puk van de petervlet", instance.deque());
		assertEquals("neger", instance.deque());
	}
	
	/**
	 * test of buildheap & add
	 */
	@Test
	public void addAndBuild() {
		System.out.println("addAndBuild");

		instance.add("jappie", 1);
		instance.add("neger", 9999999);
		instance.add("jappeace laptop", 20);
		instance.add("blah", 90);
		instance.add("puk van de petervlet", 400);
		instance.add("clone jappie",1);
		instance.add("tim", 232);
		instance.add("boeh", 89);
		instance.buildHeap();
		assertEquals("jappie", instance.deque());
		assertEquals("clone jappie", instance.deque());
		assertEquals("jappeace laptop", instance.deque());
		assertEquals("boeh", instance.deque());
		assertEquals("blah", instance.deque());
		assertEquals("tim", instance.deque());
		assertEquals("puk van de petervlet", instance.deque());
		assertEquals("neger", instance.deque());
	}

}
