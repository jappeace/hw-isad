/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.practicum.o1;

/**
 *
 * @author jappie
 */
public class Tree<T> extends isad.w4.tree.binary.Tree<T>{
	public Tree(Node<T> root){
		super(root);
	}
	
	public void calcX(){
		((Node<T>) getRoot()).calcX(0);
	}
	public void calcY(){
		((Node<T>) getRoot()).calcY();
	}
	public String printPreWithCoordinates(){
		return ((Node<T>) getRoot()).printPreWithCoordinates();
	}
}
