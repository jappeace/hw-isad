/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w3.sort;

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
public class InsertTest {
	
	public InsertTest() {
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
	 * Test of Sort method, of class Insert.
	 */
	@Test
	public void testSort() {
		System.out.println("insert Sort");
		Sorter<Integer> instance = new Insert<Integer>();
		Integer[] expResult = new Integer[]{1,2,3,4,5};
		Object[] result = instance.Sort(new Integer[]{3,4,1,2,5});
		assertArrayEquals(expResult, result);
	}
	/*
	// because quicksort depends on insertsort. I wanted to see if insert sort sorts the test array good. it did
	@Test
	public void testBigSort() {
		
		System.out.println("insert big Sort");
		Sorter<Integer> instance = new Insert<Integer>();
		Integer[] expResult = new Integer[]{1,2,3,4,5,6,7,8,9,10,22,33,42,90,123,1000, 1001, 1002, 2323,3333};
		Object[] result = instance.Sort(new Integer[]{3,1000,4,1,1001, 1002, 123,2,5,2323,6,7,8,3333,9,10,90,22,33,42});
		assertArrayEquals(expResult, result);
	}
	*/
}
