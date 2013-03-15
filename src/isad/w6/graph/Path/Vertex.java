/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.graph.Path;

import isad.w6.graph.Edge;
import java.util.Iterator;
import java.util.List;

/**
 * extends vertex in a way that path calculations can easely be don on it
 * @author jappie
 */
public class Vertex<T> extends isad.w6.graph.Vertex<T>{
	public static final Double INFINIT = Double.MAX_VALUE;
	public enum Status{
		Default, Used, Printed;
	}
	private Double _distance = INFINIT; // Cost
	private Vertex<T> _previous;
	private Status _status = Status.Default;
	public Vertex(T data){
		super(data);
	}
	public Vertex(Vertex<T> old){
		this(old.getData(), old.getConnections());
	}
	public Vertex(T data, List<Edge> connections){
		super(data, connections);
	}
	
	/**
	 * clears this vertex to its default state
	 */
	public void clear(){
		setDistance(INFINIT);
		setPrevious(null);
		setStatus(Status.Default);
	}
	
	/**
	 * resets the status of this and all connected vertexes recursivly
	 */
	public void resetStatus(){
		setStatus(Status.Default);
		
		Iterator<Edge> i = getConnections().iterator();
		while(i.hasNext()){
			Vertex<T> next = (Vertex<T>) i.next().getTo();
			if(next.getStatus() != Status.Default){
				next.resetStatus();
			}
		}
	}
	@Override
	public String toString(){
		String result = "";
		
		if(getPrevious() != null){
			if(getPrevious().getStatus() == Status.Default){
				getPrevious().setStatus(Status.Printed);
				
				result += getPrevious().toString();
				result += "->";
				getPrevious().setStatus(Status.Default);
			}
		}
		result += getData()+"("+getDistance()+")";
		return result;
	}
	/**
	 * @return the _distance
	 */
	public Double getDistance() {
		return _distance;
	}

	/**
	 * @param distance the _distance to set
	 */
	public void setDistance(Double distance) {
		this._distance = distance;
	}

	/**
	 * @return the _previous
	 */
	public Vertex<T> getPrevious() {
		return _previous;
	}

	/**
	 * @param previous the _previous to set
	 */
	public void setPrevious(Vertex<T> previous) {
		this._previous = previous;
	}

	/**
	 * @return the _status
	 */
	public Status getStatus() {
		return _status;
	}

	/**
	 * @param status the _status to set
	 */
	public void setStatus(Status status) {
		this._status = status;
	}
	
}
