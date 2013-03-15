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
public class QuickTest {
	
	public QuickTest() {
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
	 * Test of Sort method, of class Quick.
	 */
	@Test
	public void testSort() {
		System.out.println("quick Sort");
		Sorter<Integer> instance = new Quick<Integer>();
		Integer[] expResult = new Integer[]{1,2,3,4,5,6,7,8,9,10,22,33,42,90,123,1000, 1001, 1002, 2323,3333};
		Object[] result = instance.Sort(new Integer[]{3,1000,4,1,1001, 1002, 123,2,5,2323,6,7,8,3333,9,10,90,22,33,42});
		assertArrayEquals(expResult, result);
	}
}
