/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w4.tree.firstChildNextSibling;

/**
 *
 * @author jappie
 */
public class Node <T> implements Subtree{
	
	private Node<T> _child;
	private Node<T> _sibling;
	private T _data;
	
	public Node(T data){
		this(data, null);
	}
	public Node(T data, Node<T> child){
		this(data, child, null);
	}
	public Node(T data, Node<T> sibling, boolean noChild){
		this(data, null, sibling);
	}
	public Node(T data, Node<T> child, Node<T> sibling){
		_data = data;
		_child = child;
		_sibling = sibling;
	}
	
	
	@Override
	public String printPreOrder(){
		return _data.toString() 
				+ ((_child != null) ? _child.printPreOrder() : "") 
				+ ((_sibling != null) ? _sibling.printPreOrder() : "") ;
	}
	
	@Override
	public int getSize(){
		return 1 
				+ ((_sibling != null) ? _sibling.getSize() : 0) 
				+ ((_child != null) ? _child.getSize() : 0) ;
	}
}
