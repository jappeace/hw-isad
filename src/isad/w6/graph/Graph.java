/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author jappie
 */
public class Graph<T>{
	protected static final String _noRemoveText = "could not remove ", _noConnectText = "could not connect: ",
			_findText = "Could not find ";
	private Map<T, Vertex<T>> _vertexes;
	
	public Graph(){
		_vertexes = new HashMap<T, Vertex<T>>();
	}
	
	public void add(T data){
		getVertexes().put(data, new Vertex<T>(data));
	}
	/**
	 * connects two vertexes
	 * @param one
	 * @param two 
	 */
	public void connect(T one, T two){
		connect(one, two, 0.0);
	}
	/**
	 * connects two vertexes with a weight
	 * @param one
	 * @param two
	 * @param weight 
	 */
	public void connect(T one, T two, Double weight){		
		check(one, two);
		Vertex<T> second = getVertex(two);

		if(!getVertex(one).connect(second, weight)){
			throw new IllegalArgumentException(_noConnectText + second);
		}
	}
	
	/**
	 * alows a connection to be changed to another value
	 * @param one
	 * @param two
	 * @param weight 
	 */
	public void reConnect(T one, T two, Double weight){
		disConnect(one, two);
		connect(one, two, weight);
	}
	/**
	 * disconnects two vertexes
	 * @param one
	 * @param two 
	 */
	public void disConnect(T one, T two){
		check(one, two);
		Vertex<T> second = getVertex(two);
		
		if(!getVertex(one).disconnect(second)){
			throw new IllegalArgumentException(_noRemoveText + second);
		}
	}
	public void delete(T data){
		getVertexes().remove(data);
	}

	/**
	 * @return the _vertexes
	 */
	protected Map<T, Vertex<T>> getVertexes() {
		return _vertexes;
	}

	/**
	 * @param vertexes the _vertexes to set
	 */
	private void setVertexes(Map<T, Vertex<T>> vertexes) {
		this._vertexes = vertexes;
	}
	protected Vertex<T> getVertex(T which){
		return getVertexes().get(which);
	}
	protected boolean check(T one){
		return getVertexes().containsKey(one);
	}
	/**
	 * checks the existence of two data statemenst and trows an index out of bounds exception if not
	 * @param one
	 * @param two 
	 */
	protected void check(T one, T two){
		if(!(check(one) && check(two))){
			throw new IndexOutOfBoundsException(_findText+ one +" or " + two);
		}
	}
	
	@Override
	public String toString(){
		String result = "Data: " + System.lineSeparator();
		Iterator<Vertex<T>> i = getVertexes().values().iterator();
		while(i.hasNext()){
			Vertex<T> v = i.next();
			result += "		"+ v.toString()+ System.lineSeparator();
		}
		return result;
	}



}
