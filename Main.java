package bst;

/**
 * 
 * @author Brandt Jorgensen
 * SEIS 602, Spring 2016
 *
 */

public class Main {

	public static void main(String[] args) {
		
		Tree<Integer> test = new Tree<Integer>();
		
		test.insert( 13 );
		test.insert( 3 );
		test.insert( 4 );
		test.insert( 12 );
		test.insert( 14 );
		test.insert( 10 );
		test.insert( 5 );
		test.insert( 1 );
		test.insert( 8 );
		test.insert( 2 );
		test.insert( 15 );
		test.insert( 7 );
		test.insert( 9 );
		test.insert( 11 );
		test.insert( 6 );
		test.insert( 18 );
		
		System.out.println( "2a) Tree inorder: " + test.inorder() );
		System.out.println( "2b) Tree preorder: " + test.preorder() );
		System.out.println( "2c) Tree postorder: " + test.postorder() );
		System.out.println( "3) Size: " + test.getSize() );
		System.out.println( "4) Predecessor of 15: " + test.getPredecessor( 15 ));
		System.out.println( "5) Predecessor of 25: " + test.getPredecessor( 25 ));

	}

}
