/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w7.practicum.depthFirst;

import java.util.List;

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
}
