/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w3.sort;


import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jappie
 */
public class Merge <T extends Comparable<? super T>> implements Sorter<T> {
	
	@Override
	public T[] Sort(T[] target){
		if(target.length <= 1){
			return target;
		}
		int split = target.length/2;
		return this.merge(
				this.Sort(Arrays.copyOfRange(target, 0, split)), 
				this.Sort(Arrays.copyOfRange(target, split, target.length))
				);
	}
	
	
	private T[] merge(T[] one, T[] two){
		ArrayList<T> list = new ArrayList<T>();
		int first = 0, second = 0;
		
		for(int i = 0; i < (one.length + two.length); i++){
			
			if(first >= one.length){
				list.addAll(Arrays.asList(Arrays.copyOfRange(two, second, two.length)));
				break;
			}
			else if(second >= two.length){
				list.addAll(Arrays.asList(Arrays.copyOfRange(one, first, one.length)));
				break;
			}
			
			
			int result = one[first].compareTo(two[second]);
			if(result < 0){
				list.add(one[first]);
				first++;
			}else if(result > 0){
				list.add(two[second]);
				second++;
			}else{
				list.add(one[first]);
				list.add(two[second]);
				first++;
				second++;
			}
		}
		
		T[] temp = one.clone();
		return list.toArray(temp);		
	}
	
}
