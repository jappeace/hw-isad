/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w5.tree.binary.heap;

/**
 *
 * @author jappie
 */
public class PriorityQue<T extends Object> {
	private Node<T>[] _heapdata;
	private int _size = 0;
	public PriorityQue(){
		_heapdata = createArray(10);
	}
	private Node<T>[] createArray(int size){		
		return (Node<T>[]) new Node[size];
	}
	private void resize(){
		Node<T>[] temp = createArray(getHeapdata().length*2);
		System.arraycopy(getHeapdata(), 1, temp, 1, getHeapdata().length-1);
		setHeapdata(temp);
	}
	private Node<T> addMethod(T data, int priority){
		setSize(getSize()+1);
		if(getSize() >= getHeapdata().length){
			this.resize();
		}
		return new Node<T>(data, priority);
	}
	
	public void add(T data, int priority){
		Node<T> instance = addMethod(data, priority);
		getHeapdata()[getSize()] = instance;
		
	}
	/**
	 * builds a clasic binary heap structure
	 */
	public void buildHeap(){
		buildHeap(1);
	}
	private void swap(int one, int two){
		Node<T> temp = getHeapdata()[one];
		getHeapdata()[one] = getHeapdata()[two];
		getHeapdata()[two] = temp;
	}
	private boolean notNull(int index){
		if(getHeapdata().length <= index){
			return false;
		}
		return getHeapdata()[index] != null ;
	}
	private void buildHeap(int index){		
		build(index, index*2);
		build(index, index*2+1);
	}
	private void build(int parent, int child){
		if(!notNull(child)){
			return;
		}
		
		buildHeap(child);
		if(getHeapdata()[parent].getPriority() > getHeapdata()[child].getPriority()){
			swap(parent, child);
			buildHeap(child);
		}			
		
	}
	public void enque(T data, int priority){
		Node<T> current = addMethod(data, priority), temp;
		
		for(int i = 1, add = 0; true; i = i * 2 + add, add = 0){
			if(i >= getHeapdata().length){
				this.resize();
			}
			if(getHeapdata()[i] == null){
				getHeapdata()[i] = current;
				return;
			}
			if(getHeapdata()[i].getPriority() <= current.getPriority()){
				// determening if to go lft or rhgt
				if(sizeOf(i*2) > sizeOf(i*2+1)){
					add = 1;
				}
			}else{
				temp = getHeapdata()[i];
				getHeapdata()[i] = current;
				current = temp;
				i = 1;
			}
		}
	}
	private int sizeOf(int nodeIndex){
		if(nodeIndex > _size){
			return 0;
		}
		// alows the recursion to be once
		int lft = sizeOf(nodeIndex *2)+1, rght = sizeOf(nodeIndex*2+1)+1;
		return lft<rght? lft: rght;
	}
	public T deque(){
		setSize(getSize()-1);
		T current = (getHeapdata()[1] == null)? null : getHeapdata()[1].getData();
		int add = 0, i = 1;
		for(; i*2 < getHeapdata().length; i = i *2 + add, add = 0){
			if(i*2+1 >= getHeapdata().length){
				getHeapdata()[i] = getHeapdata()[i*2];
				break;
			}
			if(getHeapdata()[i*2] == null){
				getHeapdata()[i] = getHeapdata()[i*2+1];
				add = 1;
				
			}else if(getHeapdata()[i*2+1] == null){
				getHeapdata()[i] = getHeapdata()[i*2];
				
			}else if(getHeapdata()[i*2].getPriority() < getHeapdata()[i*2+1].getPriority()){
				getHeapdata()[i] =getHeapdata()[i*2];
				
			}else{
				getHeapdata()[i] = getHeapdata()[i*2+1];
				add = 1;
				
			}
		}
		
		getHeapdata()[i] = null;
		return current;
	}

	/**
	 * @return the _heapdata
	 */
	private Node<T>[] getHeapdata() {
		return _heapdata;
	}

	/**
	 * @param heapdata the _heapdata to set
	 */
	private void setHeapdata(Node<T>[] heapdata) {
		this._heapdata = heapdata;
	}

	/**
	 * @return the _size
	 */
	private int getSize() {
		return _size;
	}

	/**
	 * @param size the _size to set
	 */
	private void setSize(int size) {
		this._size = size;
	}

	
	private class Node<T>{
		private T _data;
		private int _priority;
		public Node(T data, int priority){
			_data = data;
			_priority = priority;
		}
		
		@Override
		public String toString(){
			return _data.toString();
		}

		/**
		 * @return the _data
		 */
		public T getData() {
			return _data;
		}

		/**
		 * @param data the _data to set
		 */
		public void setData(T data) {
			this._data = data;
		}

		/**
		 * @return the _priority
		 */
		public int getPriority() {
			return _priority;
		}

		/**
		 * @param priority the _priority to set
		 */
		public void setPriority(int priority) {
			this._priority = priority;
		}
	}
}
