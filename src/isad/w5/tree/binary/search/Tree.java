/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w5.tree.binary.search;

import isad.huiswerk.ISADHuiswerk;
import isad.w4.tree.binary.Node;

/**
 *
 * @author jappie
 */
public class Tree<T extends Comparable<? super T>> extends isad.w4.tree.binary.Tree<T> {
	public Tree(T startData){
		super(new Node<T>(startData));
	}
	private Tree(Node<T> sturcture){
		super(sturcture);
	}
	public void insert(T data){
		Node<T> current = super.getRoot();
		while(current != null){
			if(data.compareTo(current.getData()) < 1){
				if(current.hasLft()){
					current = current.getLft();
				}else{
					current.setLft(new Node<T>(data));
					break;
				}
			}else{
				if(current.hasRght()){
					current = current.getRght();
				}else{
					current.setRght(new Node<T>(data));
					break;
				}
			}
		}
	}
	
	@Override
	public String toString(){
		return printInOrder();
	}
	
	public void remove(T target){
		Node<T> current = getRoot(), parrent = null;
		// find the target
		while(current != null){
			if(target.compareTo(current.getData()) < 1){
				if(target.compareTo(current.getData()) == 0){
					// target found
					break;
				}
				if(current.hasLft()){
					parrent = current;
					current = current.getLft();
				}else{
					throw new IndexOutOfBoundsException("Could not find: " + target);
				}
			}else{
				if(current.hasRght()){
					parrent = current;
					current = current.getRght();
				}else{
					throw new IndexOutOfBoundsException("Could not find: " + target);
				}
			}
		}
		
		// special case for root element
		if(parrent == null){
			if(!current.hasRght() && !current.hasLft()){
				// empty tree
				setRoot(null);
				return;
			}
			if(ISADHuiswerk.xor(!current.hasRght(), !current.hasLft())){
				if(current.hasRght()){
					setRoot(current.getRght());
				}else{
					setRoot(current.getLft());
				}
				return;
			}			
			
			// has right and left
			setRoot(rewireMin(current));
			return;
		}
		if(!current.hasRght() && !current.hasLft()){
			parrent.remove(current);
			return;
		}
		if(ISADHuiswerk.xor(!current.hasRght(), !current.hasLft())){
			if(current.hasRght()){
				parrent.replace(current, current.getRght());
			}else{
				parrent.replace(current, current.getLft());
			}
			return;
		}
		parrent.replace(current, rewireMin(current));
		
	}
	private Node<T> rewireMin(Node<T> branch){
		Tree<T> temp = new Tree(branch.getRght());
		SmartNode<T> found = temp._findMin();
		
		if(found.getParent() == null){
			branch.remove(found.getData());
		}else{
			found.getParent().remove(found.getData());
		}
		
		found.setLft(branch.getLft());
		found.setRght(branch.getRght());


		return found;
	}
	private SmartNode<T> _findMin(){
		return new FindNode<T>(getRoot()).findMin();
	}
	private SmartNode<T> _findMax(){
		return new FindNode<T>(getRoot()).findMax();
	}
	private SmartNode<T> _find(T data){
		return new FindNode<T>(getRoot()).find(data);
	}
	public T findMin(){
		return _findMin().getData();
	}
	public T findMax(){
		return _findMax().getData();
	}
	public T find(T data){
		return _find(data).getData();
	}
	private class FindNode<T extends Comparable<? super T>> extends Node<T>{
		public FindNode(Node<T> from){
			this((from == null)? null : from.getData(),
					(from == null)? null :from.getLft(), 
					(from == null)? null :from.getRght());
		}
		public FindNode(T data){
			this(data, null);
		}
		public FindNode(T data, Node<T> lft){
			this(data, lft, null);
		}
		public FindNode(T data, Node<T> lft, Node<T> rght){
			super(data, lft, rght);
		}
		public SmartNode<T> find(T data){
			return find(data, null); // dont know the current parent.
		}
		private SmartNode<T> find(T data, SmartNode<T> parent){
			SmartNode<T> current = createSmartNode(parent);
			if(getData().compareTo(data) < 1){
				
				if(getData().compareTo(data) == 0){
					return current;
				}
				if(hasLft()){
					return getLft().find(data, current);
				}else{
					throw new IndexOutOfBoundsException("Could not find: " + data);
				}
			}else{
				if(current.hasRght()){
					return getRght().find(data, current);
				}else{
					throw new IndexOutOfBoundsException("Could not find: " + data);
				}
			}			
		}
		public SmartNode<T> findMin(){
			return findMin(null);
		}
		private SmartNode<T> findMin(SmartNode<T> parent){
			SmartNode<T> current = createSmartNode(parent);
			if(hasLft()){
				return getLft().findMin(current);
			}
			return current;
		}
		public SmartNode<T> findMax(){
			return findMax(null);
		}
		private SmartNode<T> findMax(SmartNode<T> parent){
			SmartNode<T> current = createSmartNode(parent);
			if(hasRght()){
				return getRght().findMax(current);
			}
			return current;
		}
		private SmartNode<T> createSmartNode(SmartNode<T> parent){
			return  new SmartNode<T>(getData(), getLft(), getRght(), parent);
		}
		
		// the nodes need aditional behavior to work recursivly
		@Override
		public FindNode<T> getLft(){
			return new FindNode<T>(super.getLft());
		}
		
		@Override
		public FindNode<T> getRght(){
			return new FindNode<T>(super.getRght());
		}
		
		@Override
		public boolean hasLft(){
			return super.getLft() != null;
		}
		
		@Override
		public boolean hasRght(){
			return super.getRght() != null;
		}
	}
	/**
	 * node that remembers parent, only needed in some cases (findmin) therefore it is not default
	 * @param <T> 
	 */
	private class SmartNode<T> extends Node<T>{
		
		private SmartNode<T> _parent;
		public SmartNode(T data){
			this(data, null);
		}
		public SmartNode(T data, SmartNode<T> parent){
			this(data, parent, null);
		}
		public SmartNode(T data, Node<T> lft, SmartNode<T> parent){
			this(data, parent, lft, null);
		}
		public SmartNode(T data, Node<T> lft, Node<T> rght, SmartNode<T> parent){
			super(data, lft, rght);
			_parent = parent;
		}

		/**
		 * @return the _parent
		 */
		public SmartNode<T> getParent() {
			return _parent;
		}

		/**
		 * @param parent the _parent to set
		 */
		public void setParent(SmartNode<T> parent) {
			this._parent = parent;
		}
		
	}
	
}
