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
	public String DepthFirstSearch(T to){
		List<isad.w6.graph.Path.Vertex<T>> list = listVertexes();
		String found = "";
		for(isad.w6.graph.Path.Vertex<T>  v : list){
			Vertex<T> vert = (Vertex<T>) v;
			DeepResult result = vert.deeper(to, found);
			found = result.getVisits();
			if(result.isSucces()){
				break;
			}
		}
		return found;
	}
	@Override
	public void add(T data){
		getVertexes().put(data, new Vertex<T>(data));
	}
}
