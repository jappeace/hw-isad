/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w3.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jappie
 */
public class Quick<T extends Comparable<? super T>> implements Sorter<T> {

	@Override
	public T[] Sort(T[] target) {

		// using insertion sort for small arrays
		if (target.length <= 6) {
			return new Insert<T>().Sort(target);
		}
		
		Node<T> first = new Node<T>(target, 0),
				middle = new Node<T>(target, target.length / 2),
				last = new Node<T>(target, target.length - 1);
		
		
		if (first.getData().compareTo(middle.getData()) < last.getData().compareTo(middle.getData())) {
			middle.swap(last);
		} else if (first.getData().compareTo(middle.getData()) > last.getData().compareTo(middle.getData())) {
			middle.swap(last, first);

		} else {
			// the middle element is smaller or bigger then the other two
			if (middle.getData().compareTo(first.getData()) < last.getData().compareTo(first.getData())) {
				first.swap(last);
			} else if (middle.getData().compareTo(first.getData()) > last.getData().compareTo(first.getData())) {
				first.swap(last, middle);
			} else {
				// the last is the median, wich is in the correct place
				if(first.getData().compareTo(last.getData()) > middle.getData().compareTo(last.getData())){
					// making it possible to skip first element in pivet comparison
					first.swap(middle);
				}
				
			}
		}
		int split = 0;
		{ // sorting part
			int small = first.getIndex()+1; 
			// because a correction is needed of 1 when finishing searching for big items
			boolean searchingBig = false;
			// the index of the nodes does not change. this means the last element in the array is now the pivot
			for(int big = last.getIndex()-1; small < big; small++){
				
				searchingBig = false;
				
				if(target[small].compareTo(last.getData()) > -1){
					for(; big > small; big--){
						
						searchingBig = true;
						if(target[big].compareTo(last.getData()) < 1){
							new Node<T>(target, big).swap(new Node<T>(target, small));
							break;
						}
					}
				}
			}
			split = small-(searchingBig? 1 : 0);
		}
		new Node<T>(target, split).swap(last);
		ArrayList<T> list = new ArrayList<T>();
		
		list.addAll(Arrays.asList((T[]) 
				new Quick().Sort(Arrays.copyOfRange(target, first.getIndex(), split))));
		
		list.add(target[split]);
		
		list.addAll(Arrays.asList((T[]) 
				new Quick().Sort(Arrays.copyOfRange(target, split+1, last.getIndex()+1))));
		
		return list.toArray(target.clone());
	}

	private class Node<T extends Comparable<? super T>> {

		private int _index;
		private T[] _parent;

		public Node( T[] parent, int index) {
			_index = index;
			_parent = parent;
		}

		/**
		 * @return the index
		 */
		public int getIndex() {
			return _index;
		}

		/**
		 * @return the data
		 */
		public T getData() {
			return getParent()[getIndex()];
		}

		/**
		 * @return the data
		 */
		public void setData(T data) {
			getParent()[getIndex()] = data;
		}

		/**
		 * @return the _parent
		 */
		private T[] getParent() {
			return _parent;
		}

		/**
		 *
		 * @param target
		 * @param one becomes two
		 * @param two becomes three
		 * @return
		 */
		public void swap(Node<T> one) {
			T data = this.getData();
			setData(one.getData());
			getParent()[one.getIndex()] = data;
		}

		/**
		 *
		 * @param target array
		 * @param one becomes two
		 * @param two becomes three
		 * @param three becomes one
		 * @return
		 */
		public void swap(Node<T> one, Node<T> two) {
			T data = getData();
			setData(two.getData());
			getParent()[one.getIndex()] = two.getData();
			getParent()[two.getIndex()] = data;
		}
	}
}
