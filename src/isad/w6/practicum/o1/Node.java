/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.practicum.o1;

/**
 *
 * @author jappie
 */
public class Node<T> extends isad.w4.tree.binary.Node {
	private int _x, _y;
	public Node(T data){
		this(data, null);
	}
	public Node(T data, Node<T> lft){
		this(data, lft, null);
	}
	public Node(T data, Node<T> lft, Node<T> rght){
		super(data, lft, rght);
	}
	/**
	 * @return the _x
	 */
	public int getX() {
		return _x;
	}

	/**
	 * @param x the _x to set
	 */
	public void setX(int x) {
		this._x = x;
	}
	public void calcY(){
		setY(this.height());
		if(hasLft()){
			((Node<T>) getLft()).calcY();
		}
		if(hasRght()){
			((Node<T>) getRght()).calcY();
		}
		
	}
	public int calcX( int offset){
		
		offset = (hasLft()? ((Node<T>)getLft()).calcX(offset -1) : 0) +1;
		if(hasRght()){
			((Node<T>)getRght()).calcX(offset + (hasLft()? getLft().size() : 0));
		}
		setX(offset);
		return offset;
				
	}
	public String printPreWithCoordinates(){
		return toString() + "(" + getX() +"," + getY() +")"
				+ (hasLft() ?  ((Node<T>)getLft()).printPreWithCoordinates()  : "") 
				+ (hasRght() ? ((Node<T>)getRght()).printPreWithCoordinates() : "");

	}
	/**
	 * @return the _y
	 */
	public int getY() {
		return _y;
	}

	/**
	 * @param y the _y to set
	 */
	public void setY(int y) {
		this._y = y;
	}
}
