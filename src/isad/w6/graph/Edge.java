/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w6.graph;

/**
 *
 * @author jappie
 */
public class Edge {
	private Vertex _to;
	private Double _weight;
	
	public Edge(Vertex to, Double weight){
		_to = to;
		_weight = weight;
	}

	/**
	 * @return the _to
	 */
	public Vertex getTo() {
		return _to;
	}

	/**
	 * @param to the _to to set
	 */
	private void setTo(Vertex to) {
		this._to = to;
	}

	/**
	 * @return the _weight
	 */
	public Double getWeight() {
		return _weight;
	}

	/**
	 * @param weight the _weight to set
	 */
	private void setWeight(Double weight) {
		this._weight = weight;
	}
	
		
	@Override
	public String toString(){
		return "Weight '"+ getWeight() +"' goes to: " + getTo().getData();
		
	}

}
