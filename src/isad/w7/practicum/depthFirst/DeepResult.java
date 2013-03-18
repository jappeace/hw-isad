/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w7.practicum.depthFirst;

/**
 *
 * @author jappie
 */
public class DeepResult {
	private boolean _succes;
	private String _visits;
	
	DeepResult(boolean succes, String visits){
		_succes = succes;
		_visits = visits;
	}

	/**
	 * @return the _succes
	 */
	public boolean isSucces() {
		return _succes;
	}

	/**
	 * @param succes the _succes to set
	 */
	public void setSucces(boolean succes) {
		this._succes = succes;
	}

	/**
	 * @return the _visits
	 */
	public String getVisits() {
		return _visits;
	}

	/**
	 * @param visits the _visits to set
	 */
	public void setVisits(String visits) {
		this._visits = visits;
	}
}
