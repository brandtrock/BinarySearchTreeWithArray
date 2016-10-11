package bst;

import java.util.ArrayList;

/**
 * 
 * @author Brandt Jorgensen
 * SEIS 602, Spring 2016
 *
 */

public class Tree<E extends Comparable<E>> implements BSTInterface<E> {
	// Use Comparable for node manipulation checking
	
	// Private vars
	private int size = 0; // Tree Size, default to 0
	private Node<E> root = null; // root node variable
	private ArrayList<E> treeOutput = new ArrayList<E>(); // Use a Java list!

	// Constructor
	public Tree() {
		// nothing
	}
	
	// Nodes (using an inner class, makes it a bit easier)
	public static class Node<E> {
		private E element;
		private Node<E> left;
		private Node<E> right;
		
		// Inner constructor
		public Node( E elem ) {
			element = elem;
		}
	}
	
	// Create a new node
	private Node<E> createNewNode( E node ) {
		return new Node<E>( node );
	}

	@Override
	public boolean search(E elem) {
		// Begin with the root node
		Node<E> current = root;
		
		// Iterate through the tree nodes
		while ( current != null ) {
			if ( elem.compareTo( current.element ) < 0 ) {
				current = current.left;
			}
			else if ( elem.compareTo( current.element ) > 0 ) {
				current = current.right;
			}
			else { 
				// elem matches current.element
				return true; // The node was found
			}
		}
		
		return false; // The node was not found
	} // END Search()

	@Override
	public boolean insert(E elem) {
		if ( root == null ) {
			root = createNewNode( elem ); // Create a new root, if one doesn't exist
		} else {
			
			// Find the parent node
			Node<E> parent = null;
			Node<E> current = root;
			
			// Iterate over the nodes, look for a duplicate
			while (current != null) {
				if ( elem.compareTo( current.element ) < 0 ) {
					parent = current;
					current = current.left;
				}
				else if ( elem.compareTo( current.element ) > 0 ) {
					parent = current;
					current = current.right;
				}
				else {
					return false; // Failed addition (a duplicate node)
				}
			}
			// Create the new node and attach it to the parent node
			if ( elem.compareTo( parent.element ) < 0 ) {
				parent.left = createNewNode( elem );
			} else {
				parent.right = createNewNode( elem );
			}
		}
		
		size++; // increase tracker of tree size
		return true; // successful addition to the tree
	} // END insert()

	@Override
	public boolean delete(E elem) {
		Node<E> parent = null;
		Node<E> current = root;
				
		while ( current != null ) {
			if ( elem.compareTo( current.element ) < 0 ) {
				parent = current;
				current = current.left;
			}
			else if ( elem.compareTo( current.element ) > 0 ) {
				parent = current;
				current = current.right;
			}
			else {
				break; // Element is in the tree pointed at by current
			}
		}
		
		if ( current == null ) {
			return false; // Element is not in the tree
		}
		
		// If the node does not have a LEFT child
		if ( current.left == null ) {
			// Connect the parent with the right child of the current node
			if ( parent == null ) {
				root = current.right;
			} else {
				if ( elem.compareTo( parent.element ) < 0 ) {
					parent.left = current.right;
				} else {
					parent.right = current.right;
				}
			}
		} else {
			// If the node has a LEFT child, find right
			Node<E> parentOfRightMost = current;
			Node<E> rightMost = current.left;
			
			// Find the right child, until you hit null.
			while ( rightMost.right != null ) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right; 
			}
			
			// The rightMost variable now contains the right-most child node
			current.element = rightMost.element;
			
			// Eliminate rightmost node
			if ( parentOfRightMost.right == rightMost ) {
				parentOfRightMost.right = rightMost.left;
			} else {
				// if parentOfRightMost == current
				parentOfRightMost.left = rightMost.left;
			}
		}
		
		size--; // reduce tracker of tree size
		return true; // The node was removed successfully
	} // END delete()

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public void clear() {
		// reset the values
		root = null;
		size = 0;
	}
	
	/*
	 * 
	 *  ITERATORS - Inorder, Preorder, Postorder
	 *  
	 */
	
	private void inorderHelper( Node<E> node ) {
		// LEFT
		if ( node.left != null ) {
			inorderHelper( node.left );
		}
		
		// ROOT
		treeOutput.add(node.element);
		
		// RIGHT
		if ( node.right != null ) {
			inorderHelper( node.right );
		}
	}

	public ArrayList<E> inorder() {
		treeOutput.clear(); // RESET
		// LEFT - ROOT - RIGHT
		if ( root != null ) {
			// Start recursive sorting
			inorderHelper( root );
		}
		
		return treeOutput;
		
	}
	
	private void preoderHelper( Node<E> node ) {
		// ROOT
		treeOutput.add(node.element);
		
		// LEFT
		if ( node.left != null ) {
			inorderHelper( node.left );
		}
		
		// RIGHT
		if ( node.right != null ) {
			inorderHelper( node.right );
		}
	}


	public ArrayList<E> preorder() {
		treeOutput.clear(); // RESET
		// ROOT - LEFT - RIGHT
		if ( root != null ) {
			// Start recursive sorting
			preoderHelper( root );
		}
		
		return treeOutput;
	}
	
	private void postoderHelper( Node<E> node ) {
		// LEFT
		if ( node.left != null ) {
			inorderHelper( node.left );
		}
		
		// RIGHT
		if ( node.right != null ) {
			inorderHelper( node.right );
		}
		
		// ROOT
		treeOutput.add(node.element);
	}

	public ArrayList<E> postorder() {
		treeOutput.clear(); // RESET
		// LEFT - RIGHT - ROOT
		if ( root != null ) {
			postoderHelper( root );
		}
		
		return treeOutput;
	}
	
	// TODO Successor Method
	public E getSuccessor( E elem ) {
		
		return null;
	}

	// TODO Predecessor Method
	public E getPredecessor( E elem ) {
		
		return null;
	}
}
