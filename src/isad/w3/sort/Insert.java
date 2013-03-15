/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w3.sort;


/**
 *
 * @author jappie
 */
public class Insert<T extends Comparable<? super T>> implements Sorter<T>{
	
	@Override
	public T[] Sort(T[] target){
		
		for(int i = 1; i < target.length; i++){
			target = finalLoop(target, i, 1);
		}
		return target;
		
	}
	
	protected T[] finalLoop(T[] target, int iterator, int step){
		T temp = target[iterator];
		for(; iterator >= step && temp.compareTo(target[iterator - step]) < 0; iterator -=  step){
			target[iterator] = target[iterator-step];
		}	
		target[iterator] = temp;
		return target;
	}
	
}
