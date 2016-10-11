package bst;

// Nodes
public class Node<E>  {
	private E element;
	private Node<E> left;
	private Node<E> right;
	
	public Node( E elem ) {
		element = elem;
	}
	
	public E getElement() {
		return element;
	}
	
	public void setElement( E elem ) {
		element = elem;
	}
	
	public Node<E> getLeft() {
		return left;
	}
	
	public void setLeft( Node<E> newLeft ) {
		left = newLeft;
	}
	
	public Node<E> getRight() {
		return right;
	}
	
	public void setRight( Node<E> newRight ) {
		right = newRight;
	}
}
