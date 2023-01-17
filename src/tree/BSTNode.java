package tree;

// TODO: Auto-generated Javadoc
/**
 * The Class BSTNode. This is a Generic Binary Search Tree, and includes the methods for operating on 
 * that tree
 *
 * @param <E> the element type
 */
public class BSTNode<E> {
	
	/** The data. */
	private E data;
	
	/** The parent. */
	private BSTNode<E> parent;
	
	/** The left. */
	private BSTNode<E> left;
	
	/** The right. */
	private BSTNode<E> right;
	

	/**
	 * Instantiates a new BST node.
	 *
	 * @param e the e
	 * @param parent the parent
	 */
	public BSTNode(E e, BSTNode<E> parent) {
		// TODO: Complete the constructor
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	E getData() {
		// TODO: Complete this method
		return null;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	void setData(E data) {
		// TODO: Complete this method
	}
	
	/**
	 * Sets the parent to node
	 *
	 * @param node the new parent
	 */
	void setParent(BSTNode<E> node) {
		// TODO: Complete this method
	}
	
	/**
	 * Gets the parent node
	 *
	 * @return the parent
	 */
	BSTNode<E> getParent() {
		// TODO: Complete this method
		return null;
	}
	
	/**
	 * Gets the left child.
	 *
	 * @return the left child
	 */
	 BSTNode<E> getLeftChild() {
		// TODO: Complete this method
		return null;
	}

	/**
	 * Gets the right child.
	 *
	 * @return the right child
	 */
	BSTNode<E> getRightChild() {
		// TODO: Complete this method
		return null;
	}
	
	/**
	 * Sets the left child to the passed in node.
	 *
	 * @param node the new left child
	 */
	void setLeftChild(BSTNode<E> node) {
		// TODO: Complete this method
	}
	
	/**
	 * Sets the right child to the passed in node.
	 *
	 * @param node the new right child
	 */
	void setRightChild(BSTNode<E> node) {
		// TODO: Complete this method
	}
	
	
	/**
	 * Creates and initializes a new left child.
	 *
	 * @param element the new left child
	 */
	void addLeftChild(E element) {
		// TODO: Complete this method
	}

	/**
	 * Creates and initializes a new right child.
	 *
	 * @param element the new right child
	 */
	void addRightChild(E element) {
		// TODO: Complete this method
	}
	
	/**
	 * Checks if the current node is a leaf node.
	 *
	 * @return true, if is leaf
	 */
	// Part 2
	public boolean isLeaf() {
		return((left == null) && (right == null));
	}
	
	/**
	 * Checks if the current node has a left child
	 *
	 * @return true, if the current node has a left child; otherwise false
	 */
	public boolean hasLeft() {
		return (left != null);
	}

	/**
	 * Checks for right.
	 *
	 * @return true, if the current node has a right child; otherwise false
	 */
	public boolean hasRight() {
		return (right != null);
	}
}
