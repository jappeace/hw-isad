/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package isad.w4.tree.binary;

/**
 *
 * @author jappie
 */
public interface Subtree {

	public int size( );
	public int height( );
	public String printPreOrder( );
	public String printInOrder( );
	public String printPostOrder( );
	public void makeEmpty( );
	public boolean isEmpty( );
	public int countLeaves(int nullChildren);
}
