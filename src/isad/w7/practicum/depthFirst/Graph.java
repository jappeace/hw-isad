/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w7.practicum.depthFirst;

import isad.w6.graph.Edge;
import isad.w6.graph.Path.PathStrategy;
import isad.w6.graph.Path.Vertex.Status;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jappie
 */
public class Graph<T> extends isad.w6.graph.Path.Graph<T> {
	public String DepthFirstSearch(T from, T to){
		Vertex<T> vert = (Vertex<T>) this.getVertex(from);
		
		return vert.deeper(to, "").getVisits();
	}
	@Override
	public void add(T data){
		getVertexes().put(data, new Vertex<T>(data));
	}
	
	public isad.w6.graph.Path.Graph<T> shortCircut(){
		
		List<isad.w6.graph.Path.Vertex<T>> list = this.listVertexes();
		this.clear();
		isad.w6.graph.Path.Vertex<T> last = list.get(list.size()-1);
		this.setStrategy(PathStrategy.Strategy.NegativeWeighted);
		
		return this.Find(last.getData());
	}
	
	private void add(Vertex<T> vertex){
		this.getVertexes().put(vertex.getData(), vertex);
	}
	private void add(isad.w6.graph.Path.Vertex<T> vertex){
		add((Vertex<T>) vertex);
	}
}
