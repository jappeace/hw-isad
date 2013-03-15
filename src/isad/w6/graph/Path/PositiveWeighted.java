/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.graph.Path;

import isad.w6.graph.Edge;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jappie
 */
public class PositiveWeighted <T> extends PathStrategy<T>{
	public PositiveWeighted(Graph<T> dataHolder){
		super(dataHolder);
	}

	@Override
	public Graph<T> Find(T from) {
		Graph<T> data = getData();
		
		Vertex<T> current = (Vertex<T>)data.getVertex(from);
		current.setDistance((double)0);
		DijkstrasAlgoritm(data.listVertexes());
		return data;
	}
	/**
	 * selects a vertex to use dijkstras algoritm on
	 * @param vertexes 
	 */
	private void DijkstrasAlgoritm(List<Vertex<T>> vertexes){
		Iterator<Vertex<T>> i = vertexes.iterator();
		Vertex<T> smallest = null;
		while(i.hasNext()){
			Vertex<T> current = i.next();
			
			if(current.getStatus() != Vertex.Status.Used){
				if(smallest == null){
					smallest = current;
				}else if(smallest.getDistance() > current.getDistance()){
					smallest = current;
				}
			}
		}
		if(smallest != null){
			DijkstrasAlgoritm(smallest);
			DijkstrasAlgoritm(vertexes);
		}
		
		prepToString(vertexes);
	}
	/**
	 * the core of dijkstras algoritm, without the select vertex part
	 * @param target 
	 */
	protected void DijkstrasAlgoritm(Vertex<T> target){
		target.setStatus(Vertex.Status.Used);
		Iterator<Edge> i = target.getConnections().iterator();
		while(i.hasNext()){
			Edge e = i.next();
			Vertex<T> next = (Vertex<T>) e.getTo();
			Double calced = e.getWeight() + target.getDistance();
			if(next.getDistance() > calced){
				onOverwrite();
				next.setDistance(calced);
				next.setPrevious(target);
			}
			onLoopEnd(next);
		}
	}
	
	protected void prepToString(List<Vertex<T>> vertexes){
			// reseting status for the to string
		Iterator<Vertex<T>> i = vertexes.iterator();
		while(i.hasNext()){
			Vertex<T> current = i.next();
			current.setStatus(Vertex.Status.Default);
		}	
	}
	protected void onOverwrite(){}
	protected void onLoopEnd(Vertex<T> target){}
}
