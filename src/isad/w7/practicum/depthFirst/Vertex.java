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
		setStatus(Status.Used);
		for(Edge conn : connections){
			Vertex<T> to = (Vertex<T>) conn.getTo();
			if(to.getStatus().equals(Status.Default)){
				
				visits += to.getData() + ",";
				if(to.getData().equals(target)){
					return new DeepResult(true, visits);
				}else{
					DeepResult r = to.deeper(target, visits);
					if(r.isSucces()){
						return r;
					}
					visits += r.getVisits();
				}
			}
		}
		
		return new DeepResult(false, visits.substring(0, visits.length()-1));
	}
}
