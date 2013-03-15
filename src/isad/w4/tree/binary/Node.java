/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w4.tree.binary;

/**
 *
 * @author jappie
 */
public class Node<T> implements Subtree {
	private T _data;
	// used shortcuts to follo cakephp conventions
	private Node<T> _lft;
	private Node<T> _rght;
	public Node(T data){
		this(data, null);
	}
	public Node(T data, Node<T> lft){
		this(data, lft, null);
	}
	public Node(T data, Node<T> lft, Node<T> rght){
		_data = data;
		_lft = lft;
		_rght = rght;
	}

	@Override
	public int size() {
		return 1 + (hasLft()? getLft().size() : 0) 
				 + (hasRght()? getRght().size() : 0);
	}
	
	public boolean hasLft(){
		return getLft() != null;
	}
	public boolean hasRght(){
		return getRght() != null;
	}

	@Override
	public int height() {
		int left = 1, right = 1;
		if(hasLft()){
			left += getLft().height();
		}
		if(hasRght()){
			right += getRght().height();
		}
		return (right > left) ? right : left;
	}

	@Override
	public void makeEmpty() {
		setLft(null);
		setRght(null);
		_data = null;
	}

	@Override
	public boolean isEmpty() {
		return (getLft() == null) && (getRght() == null) && (getData() == null);
	}
	@Override
	public String toString(){
		return (getData() != null)? getData().toString() : "NULL";
	}
	@Override
	public String printPreOrder() {
		return toString() + (hasLft() ? getLft().printPreOrder() : "") + (hasRght() ? getRght().printPreOrder() : "");
	}

	@Override
	public String printInOrder() {
		return  (hasLft() ? getLft().printInOrder() : "") + toString() + (hasRght() ? getRght().printInOrder() : "");
	}

	@Override
	public String printPostOrder() {
		return  (hasLft() ? getLft().printInOrder() : "")  + (hasRght() ? getRght().printInOrder() : "") + toString();	
	}

	@Override
	public int countLeaves(int nullChildren) {
		return (((hasLft() ? 1 : 0) + (hasRght()? 1 : 0)) == nullChildren? 1 : 0) + 
				(hasLft()? getLft().countLeaves(nullChildren) : 0) +
				(hasRght()? getRght().countLeaves(nullChildren) : 0);
	}

	/**
	 * @return the _data
	 */
	public T getData() {
		return _data;
	}

	/**
	 * @return the _lft
	 */
	public Node<T> getLft() {
		return _lft;
	}

	/**
	 * @param lft the _lft to set
	 */
	public void setLft(Node<T> lft) {
		this._lft = lft;
	}

	/**
	 * @return the _rght
	 */
	public Node<T> getRght() {
		return _rght;
	}

	/**
	 * @param rght the _rght to set
	 */
	public void setRght(Node<T> rght) {
		this._rght = rght;
	}
	/**
	 * removes the node, left or right. Both if the target equals eachother data
	 * @param target 
	 */
	public void remove(T target){
		boolean found = false;
		if(hasLft()){
			if(getLft().getData().equals(target)){
				found = true;
				setLft(getLft().getLft());
			}
		}
		if(hasRght()){
			if(getRght().getData().equals(target)){
				found = true;
				setRght(getRght().getRght());
			}
		}
		
		if(!found){
			throw new IndexOutOfBoundsException("Could not find in my childeren te following data " + target 
					+ " while trying to delete that child");
		}	
	}
	/**
	 * removes the node, left or right. Both if the target is equal to eachother
	 * @param target 
	 */
	public void remove(Node<T> target){
		replace(target, null);
	}
	/**
	 * 
	 * @param one lft or rght note te be replaced
	 * @param two the node thats gonna replace the lft or rght node
	 */
	public void replace(Node<T> one, Node<T> two){
		boolean found = false;
		
		if(hasLft()){
			if(getLft().equals(one)){
				found = true;
				setLft(two);
			}
		}
		if(hasRght()){
			if(getRght().equals(one)){
				found = true;
				setRght(two);
			}
		}
		
		if(!found){
			throw new IndexOutOfBoundsException("Could not find "+ one +" while searching to replace "+ two);
		}
			
	}
	
}
