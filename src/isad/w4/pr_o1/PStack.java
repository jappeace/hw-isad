/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w4.pr_o1;

/**
 *
 * @author jappie
 */
public class PStack<T> {
	private T[] array;
	private int size = 0;
	public PStack(){
		this(10);
	}
	public PStack(int size){
		array  = createGenericArray(size);
	}
	public void Push(T data){
		
		// fixxing size
		if((size+1) > array.length){
			T[] temp = createGenericArray(size*2);
			System.arraycopy(array, 0, temp, 0, array.length);
			array = temp;
		}
		
		
		for(int i = array.length-1; i > 0; i--){
			array[i] = array[i-1];
		}
		array[0] = data;
		size++;
	}
	public T Pop()throws Exception{
		T result = Top();
		
		for(int i = 1; i < array.length; i++){
			array[i-1] = array[i];
		}
		size--;
		return result;
	}
	public T Top()throws Exception{
		if(IsEmpty()){
			throw new Exception("stack empty");
		}
		return array[0];
	}
	public boolean IsEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}
	public String Print(){
		
		String result = "";
		
		for(T element : array){
			if(element != null){
				result += element.toString() + ", ";
			}
		}
		return result.substring(0, result.length() -2);
	}
	private final T[] createGenericArray(int size){
		return (T[]) new Object[size];
	}
}
