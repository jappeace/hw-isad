/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.graph.Path;

import isad.w6.graph.Path.PathStrategy.Strategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jappie
 */
public class Graph<T> extends isad.w6.graph.Graph<T> {

	private PathStrategy<T> _strategy;
	public Graph(){
		super();
		_strategy = new PositiveWeighted(this);
	}
	@Override
	public void add(T data){
		getVertexes().put(data, new Vertex<T>(data));
	}
	/**
	 * @return the _strategy
	 */
	private PathStrategy getStrategy() {
		if(_strategy == null){
			throw new NullPointerException("strategy was not set");
		}
		return _strategy;
	}
	public void setStrategy(Strategy which){
		if(which == Strategy.NegativeWeighted){
			this.setStrategy(new NegativeWeighted(this));
		}else if(which == Strategy.PositiveWeighted){
			this.setStrategy(new PositiveWeighted(this));
		}else if(which == Strategy.NotWeighted){
			this.setStrategy(new UnWeighted(this));
		}else{
			throw new IllegalArgumentException(_findText + which);
		}
	}
	/**
	 * @param strategy the _strategy to set
	 */
	private void setStrategy(PathStrategy strategy) {
		this._strategy = strategy;
	}
	public Graph<T> Find(T from) {
		if(!check(from)){
			throw new IllegalArgumentException(_findText + from);
		}
		return getStrategy().Find(from);
	}
	public Vertex<T> Find(T from, T to) {
		check(from, to);
		return getStrategy().Find(from, to);
	}
	/**
	 * prepares the vertexes for another algoritim
	 */
	public void clear(){
		
		Map<T, isad.w6.graph.Vertex<T>> items = this.getVertexes();
		
		Iterator<isad.w6.graph.Vertex<T>> i = items.values().iterator();
		while(i.hasNext()){
			Vertex<T> current = (Vertex<T>) i.next();
			current.clear();
		}
	}
	
	/**
	 * overide to make public, so the strategies can acces this function
	 * @param which
	 * @return 
	 */
	@Override
	public Vertex<T> getVertex(T which){
		return (Vertex<T>) super.getVertex(which);
	}
	
	/**
	 * converts the Map<T, Vertex<T>> to List <PathVertex<T>>
	 * @return 
	 */
	public List<Vertex<T>> listVertexes(){
		List<Vertex<T>> list = new ArrayList<Vertex<T>>();
		Iterator<isad.w6.graph.Vertex<T>> i = this.getVertexes().values().iterator();
		while(i.hasNext()){
			list.add((Vertex<T>) i.next());
		}
		return list;
	}
}
