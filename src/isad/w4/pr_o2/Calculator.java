/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w4.pr_o2;

import java.util.Stack;

/**
 *
 * @author jappie
 */
public class Calculator {
	
	
	public double CalculatePostfix(String expresion) throws Exception{
		String[] actions = expresion.split(" ");
		Stack<Double> s = new Stack<Double>();
		
		double one;
		double two;
		for(String action: actions){
			if(action.equals("*") || action.equals("/") || action.equals("+") || action.equals("-")){
				// do some calculations
				if(s.size() < 2){
					error();
				}
				
				if(action.equals("*")){
					s.push(s.pop() * s.pop());
				}else if(action.equals("/")){
					
					one = s.pop();
					two = s.pop();
					
					s.push(two / one);
				}else if(action.equals("+")){
					s.push(s.pop() + s.pop());
				}else if(action.equals("-")){
					one = s.pop();
					two = s.pop();
					s.push(two - one);
				}
				
			}else{
				// add stuff to the stack
				s.push(Double.parseDouble(action));
			}
		}
		
		if(s.size() != 1){
			error();
		}
		return s.pop();
	}
	private void error() throws Exception{
		throw new Exception("Invalid string");
	}
}
