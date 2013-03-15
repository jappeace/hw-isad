/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w4.tree.binary;

/**
 *
 * @author jappie
 */
public class Tree<T>  implements Subtree{
	private Node<T> _root;
	public Tree(Node<T> root){
		_root = root;
	}

	@Override
	public int size() {
		return getRoot().size();
	}

	@Override
	public int height() {
		return getRoot().height();
	}

	@Override
	public void makeEmpty() {
		setRoot(null);
	}

	@Override
	public boolean isEmpty() {
		return getRoot() == null;
	}

	@Override
	public String printPreOrder() {
		return getRoot().printPreOrder();
	}

	@Override
	public String printInOrder() {
		return getRoot().printInOrder();
	}

	@Override
	public String printPostOrder() {
		return getRoot().printPostOrder();
	}
	
	@Override
	public int countLeaves(int nullChildren){
		return getRoot().countLeaves(nullChildren);
	}

	/**
	 * @return the _root
	 */
	protected Node<T> getRoot() {
		return _root;
	}
	@Override
	public String toString(){
		return printPreOrder();
	}

	/**
	 * @param root the _root to set
	 */
	protected void setRoot(Node<T> root) {
		this._root = root;
	}
}
