/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w3.recursivePrint;

import java.util.ArrayList;

/**
 *
 * @author jappie
 */
public class Printer {
	
	/**
	 *
	 * @param theList
	 * @param i
	 * @return
	 */
	public String printForward(ArrayList<Integer> theList, int i){
		if(i >= theList.size()){
			return "";
		}
		int item = theList.remove(theList.size()-1);
		return this.printForward(theList, i)+" " + item;
	}
	
	public String printBackward(ArrayList<Integer> theList, int i){
		if(i >= theList.size()){
			return "";
		}
		return theList.remove(theList.size()-1) + " " + this.printBackward(theList, i);
	}
	
}
