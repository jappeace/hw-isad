/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.graph.Path;

import isad.w6.graph.Edge;
import isad.w6.graph.Vertex;
import java.util.List;

/**
 * extends vertex in a way that path calculations can easely be don on it
 * @author jappie
 */
public class PathVertex<T> extends Vertex<T>{
	public static final Double INFINIT = Double.MAX_VALUE;
	public enum Status{
		Default, Used, Printed;
	}
	private Double _distance = INFINIT; // Cost
	private PathVertex<T> _previous;
	private Status _status = Status.Default;
	public PathVertex(T data){
		super(data);
	}
	public PathVertex(Vertex<T> old){
		this(old.getData(), old.getConnections());
	}
	public PathVertex(T data, List<Edge> connections){
		super(data, connections);
	}
	
	public void clear(){
		setDistance(INFINIT);
		setPrevious(null);
		setStatus(Status.Default);
	}
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
	public PathVertex<T> getPrevious() {
		return _previous;
	}

	/**
	 * @param previous the _previous to set
	 */
	public void setPrevious(PathVertex<T> previous) {
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
