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
public class MergeTest {
	
	public MergeTest() {
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
	 * Test of Sort method, of class Merge.
	 */
	@Test
	public void testSort() {
		System.out.println("merge Sort");
		Merge<Integer> instance = new Merge<Integer>();
		Integer[] expResult = new Integer[]{1,2,3,4,5,6,7,8,9,10,22,33,42,90,123,1000};
		Object[] result = instance.Sort(new Integer[]{3,1000,4,1, 123,2,5,6,7,8,9,10,90,22,33,42});
		assertArrayEquals(expResult, result);
	}
}
