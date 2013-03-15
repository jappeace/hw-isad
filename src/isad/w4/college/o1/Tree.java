/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w4.college.o1;

/**
 *
 * @author jappie
 */
public class Tree<T> {
	private Tree<T> lft;
	private Tree<T> rght;
	private Tree<T> parrent;
	private T data;
	public Tree(T data, Tree<T> parrent){
		this.data = data;
		lft = null;
		rght = null;
		this.parrent = parrent;
	}
	
	@Override
	public String toString(){
		String value = data.toString();
		if(!lft.equals(null)){
			value += lft.toString();
		}
		if(!rght.equals(null)){
			value += rght.toString();
		}
		
		
		return value;
	}
}
