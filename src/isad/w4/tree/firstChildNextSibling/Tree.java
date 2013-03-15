/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w4.tree.firstChildNextSibling;

/**
 *
 * @author jappie
 */
public class Tree<T> implements Subtree{
	private Node<T> _root;
	public Tree(Node<T> root){
		_root = root;
	}

	@Override
	public String printPreOrder() {
		return _root.printPreOrder();
	}

	@Override
	public int getSize() {
		return _root.getSize();
	}
}
