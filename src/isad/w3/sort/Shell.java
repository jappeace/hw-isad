/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w3.sort;

/**
 *
 * @author jappie
 */
public class Shell<T extends Comparable<? super T>> extends Insert<T>{
	
	@Override
	public T[] Sort(T[] target){
		
		for(int step = target.length /2; step > 0; step = step == 2 ? 1 : (int) (step / 2.25)){
			for(int i  = step; i < target.length; i++){
				target = this.finalLoop(target, i, step);
			}
		}
		return target;
	}
	
}
