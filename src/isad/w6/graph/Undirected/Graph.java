/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.graph.Undirected;

import isad.w6.graph.Vertex;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jappie
 */
public class Graph<T> extends isad.w6.graph.Path.Graph<T> {
	
	public boolean isConnected(){
		
		List<Vertex<T>> vertexes = new ArrayList<Vertex<T>>(this.getVertexes().values());
		
		
		return false;
	}
	
}
