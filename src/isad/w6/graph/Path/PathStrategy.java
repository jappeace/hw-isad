/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.graph.Path;

/**
 *
 * @author jappie
 */
public abstract class PathStrategy<T> {
	private Graph<T> _dataHolder;
	public enum Strategy{
		NegativeWeighted,
		PositiveWeighted,
		NotWeighted
	}
	public PathStrategy(Graph<T> dataHolder){
		_dataHolder = dataHolder;
	}
	public abstract Graph<T> Find(T from);
	public Vertex<T> Find(T from, T to){
		Graph<T> data = Find(from);
		return (Vertex<T>) data.getVertex(to);
	}
	/**
	 * @return the _owner
	 */
	protected Graph<T> getData() {
		_dataHolder.clear();
		return _dataHolder;
	}

	/**
	 * @param owner the _owner to set
	 */
	protected void setData(Graph<T> owner) {
		this._dataHolder = owner;
	}
	
}
