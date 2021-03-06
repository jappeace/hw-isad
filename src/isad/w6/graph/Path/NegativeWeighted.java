/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.graph.Path;

import isad.w6.graph.Path.Vertex.Status;

/**
 *
 * @author jappie
 */
public class NegativeWeighted<T> extends PositiveWeighted<T> {

	public NegativeWeighted(Graph<T> dataHolder){
		super(dataHolder);
	}

	@Override
	public Graph<T> Find(T from) {
		Graph<T> data = getData();
		Vertex<T> current = (Vertex<T>)data.getVertex(from);
		current.setDistance((double)0);
		// three cycles should be enough
		for(int i = 3; i > 0; i--){
			current.resetStatus();
			DijkstrasAlgoritm(current);
		}
		Check e = new Check(data);
		current.resetStatus();
		e.DijkstrasAlgoritm(current);
		if(e.isOverwridden()){
			throw new IllegalArgumentException("NegativeWeigted is caught in a negative cycle");
		}
		
		prepToString(data.listVertexes());
		return data;
	}
	
	@Override
	public void onLoopEnd(Vertex<T> target){
		if(target.getStatus() == Status.Default){ // otherwise stackoverflow
			DijkstrasAlgoritm(target);
		}
	}
	
	
	/*
	 * a class that overwrites onoverwrite to check if dijkstras algoritm overwrites somthing
	 */
	private class Check<T> extends PositiveWeighted<T>{
		private boolean _overwridden = false;
		public Check(Graph<T> dataHolder){
			super(dataHolder);
		}
		@Override
		public void onOverwrite(){
			setOverwridden(true);
		}

		/**
		 * @return the _overwridden
		 */
		public boolean isOverwridden() {
			return _overwridden;
		}

		/**
		 * @param overwridden the _overwridden to set
		 */
		public void setOverwridden(boolean overwridden) {
			this._overwridden = overwridden;
		}
	}
}
