/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jappie
 */
public class Vertex<T> {
	
	private T _data;
	private List<Edge> _connections;
	public Vertex(T data){
		this(data, new LinkedList<Edge>());
	}
	public Vertex(T data, List<Edge> connections){
		_data = data;
		_connections = connections;
	}

	/**
	 * @return the _data
	 */
	public T getData() {
		return _data;
	}
	
	/**
	 * @param data the _data to set
	 */
	private void setData(T data) {
		this._data = data;
	}

	/**
	 * @return the _connections
	 */
	public List<Edge> getConnections() {
		return _connections;
	}

	/**
	 * @param connections the _connections to set
	 */
	private void setConnections(List<Edge> connections) {
		this._connections = connections;
	}
	
	@Override
	public String toString(){
		String result = getData() + ", connections:" + System.lineSeparator();
		Iterator<Edge> i = getConnections().iterator();
		while(i.hasNext()){
			Edge e = i.next();
			result += "		"+ e.toString()+ System.lineSeparator();
		}
		return result;
	}
	
	public boolean disconnect(Vertex<T> to){
		Iterator<Edge> i = getConnections().iterator();
		while(i.hasNext()){
			Edge e = i.next();
			if(e.getTo().equals(to)){
				i.remove();
				return true;
			}
		}
		return false;
	}
	
	public boolean connect(Vertex<T> to, Double weight){
		return getConnections().add(new Edge(to, weight));
	}
	
	
	
	
}
