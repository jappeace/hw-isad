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
	private PathGraph<T> _dataHolder;
	public enum Strategy{
		NegativeWeighted,
		PositiveWeighted,
		NotWeighted
	}
	public PathStrategy(PathGraph<T> dataHolder){
		_dataHolder = dataHolder;
	}
	public abstract PathGraph<T> Find(T from);
	public PathVertex<T> Find(T from, T to){
		PathGraph<T> data = Find(from);
		return (PathVertex<T>) data.getVertex(to);
	}
	/**
	 * @return the _owner
	 */
	protected PathGraph<T> getData() {
		_dataHolder.clear();
		return _dataHolder;
	}

	/**
	 * @param owner the _owner to set
	 */
	protected void setData(PathGraph<T> owner) {
		this._dataHolder = owner;
	}
	
}
