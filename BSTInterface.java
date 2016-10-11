package bst;

/**
 * 
 * @author Brandt Jorgensen
 * SEIS 602, Spring 2016
 *
 */

public interface BSTInterface<E> {
	
	// Returns TRUE if the element is in the tree
	public boolean search( E elem );
	
	// Returns TRUE if the element is added successfully
	public boolean insert( E elem );
	
	// Returns TRUE if the element is removed successfully
	public boolean delete( E elem );
	
	// Returns the number of elements in the tree
	public int getSize();
	
	// Returns TRUE if the tree is empty
	public boolean isEmpty();
	
	// Removes all the elements of the tree - set root node to null
	public void clear();

}
