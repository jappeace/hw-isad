/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.graph.Path;

import isad.w6.graph.Edge;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author jappie
 */
public class UnWeighted<T> extends PathStrategy<T> {
	private Queue<Vertex<T>> _itemsLeft;
	public UnWeighted(Graph<T> dataHolder){
		super(dataHolder);
		_itemsLeft = new LinkedList<Vertex<T>>();
	}
	@Override
	public Graph<T> Find(T from) {
		_itemsLeft.clear();
		Graph<T> data = getData();
		Vertex<T> current = (Vertex<T>)data.getVertex(from);
		current.setDistance((double)0);
		_itemsLeft.add(current);
		while((current = _itemsLeft.poll()) != null){
			Iterator<Edge> i = current.getConnections().iterator();
			while(i.hasNext()){
				Edge next = i.next();
				Vertex<T> to = (Vertex<T>) next.getTo();
				if(to.getDistance() == Vertex.INFINIT){
					to.setDistance(current.getDistance()+1);
					to.setPrevious(current);
					_itemsLeft.add(to);
				}
			}
		}
		
		return data;
	}
	
}
