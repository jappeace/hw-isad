/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w3.sort;

/**
 *
 * @author jappie
 */
public interface Sorter <T extends Comparable<? super T>>  {
	
	public T[] Sort(T[] target);
	
}
