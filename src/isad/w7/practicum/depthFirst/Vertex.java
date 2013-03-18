/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w7.practicum.depthFirst;

import isad.w6.graph.Edge;
import java.util.List;

/**
 *
 * @author jappie
 */
public class Vertex<T> extends isad.w6.graph.Path.Vertex<T>{
	
	public Vertex(T data){
		super(data);
	}
	
	public DeepResult deeper(T target, String visits){
		List<Edge> connections = this.getConnections();
		for(Edge conn : connections){
			Vertex<T> to = (Vertex<T>) conn.getTo();
			if(to.getStatus().equals(Status.Default)){
				to.setStatus(Status.Used);
				visits += to.getData() + ",";
				if(to.getData().equals(target)){
					return new DeepResult(false, visits.substring(0, visits.length()-1));
				}else{
					visits += to.deeper(target, visits).getVisits();
				}
			}
		}
		
		return new DeepResult(false, visits.substring(0, visits.length()-1));
	}
}
