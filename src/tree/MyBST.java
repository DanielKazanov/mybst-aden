package tree;

import java.util.LinkedList;
import java.util.Queue;

// TODO: Auto-generated Javadoc
/**
 * The Class MyBST.
 *
 * @param <E> the element type
 */
public class MyBST<E extends Comparable<E>> {
	
	/** The root of the BST. */
	private BSTNode<E> root;
	
	/** The size of the BST. */
	int size;
	
	/** The str order. */
	String strOrder;

	/**
	 * Instantiates a new MyBST .
	 */
	public MyBST() {
		this.root = null;
	}
	
	// Part 1 - code and validate the insert and search methods
	
	/**
	 * Gets the root.
	 *
	 * @return the root node of the Binary Search Tree
	 */
	public BSTNode<E> getRoot() {
		return root;
	}

	
	/**
	 * Gets the size of the Binary Search Tree.
	 *
	 * @return the size of the Binary Search Tree
	 */
	public int getSize() {
		return size;
	}
	/**
	 * Insert.
	 *
	 * @param e the element to insert into the BST
	 * @return true, if successful; false if e already exists in the BST
	 */
	public boolean insert(E e) {
		if (root == null) { // BST is empty, no root exists --> create new node
			root = new BSTNode<E>(e, null);
			size++;
			return true;
		}
		
		BSTNode<E> counterNode = root;
		int counter = e.compareTo(counterNode.getData());
				
		while ((counter < 0 && counterNode.hasLeft()) || (counter > 0 && counterNode.hasRight())) { // Iterating to correct e location in BST
			if (counter < 0) {
				counterNode = counterNode.getLeftChild();
			} else {
				counterNode = counterNode.getRightChild();
			}
			counter = e.compareTo(counterNode.getData());
		}
		
		if (counter < 0) {
			counterNode.setLeftChild(new BSTNode<E>(e, counterNode));
		} else if (counter > 0) {
			counterNode.setRightChild(new BSTNode<E>(e, counterNode));
		} else {
			return false; // e already exists in the BST
		}
		
		size++;
		return true;
	}
	
	/**
	 * Search the BST.
	 *
	 * @param e the element to search for
	 * @return true, if the element was found in the list...
	 */
	public boolean search(E e) {
		BSTNode<E> counterNode = root;
		int counter = e.compareTo(counterNode.getData());
		
		while ((counter < 0 && counterNode.hasLeft()) || (counter > 0 && counterNode.hasRight())) {
			if (counter < 0) {
				counterNode = counterNode.getLeftChild();
			} else {
				counterNode = counterNode.getRightChild();
			}
			counter = e.compareTo(counterNode.getData());
		}
		
		if (counter == 0) {
			return true;
		} else {
			return false;
		}
		
	}
	

	// Part 2: Pre/Post/In order traversals
	
	/**
	 * Debug method to dump the results of a traversal as a string
	 *
	 * @return the str order
	 */
	public String getStrOrder() {
		return(strOrder);
	}
	
	/**
	 * Preorder - traverse the BST using the preorder search algorithm.
	 * This should be written recursively, and will require two overloaded
	 * methods
	 */
	public void preorder() {
		strOrder = "";
		preorder(root);
	}
	
	/**
	 * Preorder traversal - process node, then left then right.
	 * Update strOrder with node.getData() when processed
	 *
	 * @param node the node
	 */
	private void preorder(BSTNode<E> node) {
		if (node == null) { // end of tree branch
			return;
		}
		
		strOrder += node.getData() + ",";
		preorder(node.getLeftChild());
		preorder(node.getRightChild());
	}

	/**
	 * Inorder - traverse the BST using the inorder search algorithm.
	 * This should be written recursively, and will require two overloaded
	 * methods
	 */
	public void inorder() {
		strOrder = "";
		inorder(root);
	}
	
	/**
	 * Inorder traversal - process left, node, then right
	 * Update strOrder with node.getData() when processed
	 *
	 * @param node the node being traversed
	 */
	private void inorder(BSTNode<E> node) {
		if (node == null) { // end of tree branch
			return;
		}
		
		inorder(node.getLeftChild());
		strOrder += node.getData() + ",";
		inorder(node.getRightChild());
	}
	
	/**
	 * Postorder - traverse the BST using the postorder search algorithm.
	 * This should be written recursively, and will require two overloaded
	 * methods
	 */
	public void postorder() {
		strOrder = "";
		postorder(root);
	}
	
	/**
	 * Postorder traversal - process left, then right then node.
	 * Update strOrder with node.getData() when processed
	 *
	 * @param node the node being traversed
	 */
	private void postorder(BSTNode<E> node) {
		if (node == null) { // end of tree branch
			return;
		}
		
		postorder(node.getLeftChild());
		postorder(node.getRightChild());
		strOrder += node.getData() + ",";
	}
	
	// Part 3: Level order Traversal and node removal

	/**
	 * Levelorder. Processes the nodes of a binary tree by level, starting at the root. 
	 * Note that this is not recursive. Update strOrder when a node is removed from the
	 * queue.
	 */
	public void levelorder() {
		strOrder = "";
		Queue<BSTNode<E>> levelQ = new LinkedList<BSTNode<E>>();
		levelQ.add(root);
		
		while (!levelQ.isEmpty()) {
			BSTNode<E> counterNode = levelQ.remove();
			
			if (counterNode != null) {
				strOrder += counterNode.getData() + ",";
				
				if (counterNode.hasLeft()) {
					levelQ.add(counterNode.getLeftChild());
				}
				if (counterNode.hasRight()) {
					levelQ.add(counterNode.getRightChild());
				}
			}
		}
	}
	
	/**
	 * Returns the BSTNode whose data contains the given element.
	 *
	 * @param e the element to be matched
	 * @return the matching BSTNode if element was found; null otherwise.
	 */
	private BSTNode<E> getMatchingNode(E e) {
		BSTNode<E> counterNode = root;
		int counter = e.compareTo(counterNode.getData());
		
		while ((counter < 0 && counterNode.hasLeft()) || (counter > 0 && counterNode.hasRight())) { // Iterating to correct e location in BST
			if (counter < 0) {
				counterNode = counterNode.getLeftChild();
			} else {
				counterNode = counterNode.getRightChild();
			}
			counter = e.compareTo(counterNode.getData());
		}
		
		if (counter == 0) {
			return counterNode;
		} else {
			return null; // No matching node found
		}
	}

	/**
	 * Connect to parent node to the child node in both directions.
	 * Must handle the case where the parent is null - connect to root
	 * Must handle the case where the child is null and NOT attempt to
	 * set the parent of the child!
	 *
	 * @param e the element value used to determine if connecting child to 
	 *          left or right branch of the parent
	 * @param parent the parent
	 * @param child the child
	 */
	private void connectToParent(boolean left, BSTNode<E> parent, BSTNode<E> child) {
		if (parent == null) {
			root = child;
			
			if (child != null) {
				child.setParent(null);
			}
			return;
		}

		if (left) {
			parent.setLeftChild(child);
		} else {
			parent.setRightChild(child);
		}
		
		if (child == null) {
			return;
		}
		
		child.setParent(parent);
	}
	
	/**
	 * Finds left-most node in the right child of the specified node.
	 *
	 * @param node the node
	 * @return the BST node
	 */
	private BSTNode<E> findLeftMostNode(BSTNode<E> node) {
		while (node.hasLeft()) {
			node = node.getLeftChild();
		}
		return node;
	}

	/**
	 * Remove the BST node that contains the supplied element
	 *
	 * @param e the element to be searched for in the BST
	 * @return true if the element was found and deleted; false otherwise
	 */
	public boolean remove(E e) {
		BSTNode<E> nodeToRemove = getMatchingNode(e);
		boolean hasLeft = false;
		
		if (nodeToRemove == null) {
			return false;
		}
		
		if (nodeToRemove.getParent() != null) {
			hasLeft = checkLeftNode(nodeToRemove);
		}
		
		if (!nodeToRemove.hasLeft() && !nodeToRemove.hasRight()) {
			connectToParent(hasLeft, nodeToRemove.getParent(), null);
		} else {
			if (nodeToRemove.hasLeft() && !nodeToRemove.hasRight()) {
				connectToParent(hasLeft, nodeToRemove.getParent(), nodeToRemove.getLeftChild());
			} else if (!nodeToRemove.hasLeft() && nodeToRemove.hasRight()) {
				connectToParent(hasLeft, nodeToRemove.getParent(), nodeToRemove.getRightChild());
			} else if (nodeToRemove.hasLeft() && nodeToRemove.hasRight()) {
				BSTNode<E> leftMostNode = findLeftMostNode(nodeToRemove.getRightChild());
				removeHasLeftAndRightNode(nodeToRemove, leftMostNode, hasLeft);
			}
		}
		
		size--;
		return true;
	}
	
	/**
	 * Check whether the node to remove has a left node in the BST
	 * 
	 * @param nodeToRemove the node to remove from the BST
	 * @return true if has a left node; false otherwise
	 */
	private boolean checkLeftNode(BSTNode<E> nodeToRemove) {
		return (nodeToRemove.getParent().getData().compareTo(nodeToRemove.getData()) > 0);
	}
	
	/**
	 * Cases for when the nodeToRemove has both left and right nodes in the BST branch
	 * 
	 * @param nodeToRemove the node to remove from the BST
	 * @param leftMostNode the left most node in the BST branch
	 * @param hasLeft the boolean whether or not nodeToRemove has a left node in the BST
	 */
	private void removeHasLeftAndRightNode(BSTNode<E> nodeToRemove, BSTNode<E> leftMostNode, boolean hasLeft) {
		if (nodeToRemove == leftMostNode.getParent()) {
			connectToParent(true, leftMostNode, nodeToRemove.getLeftChild());
			connectToParent(hasLeft, nodeToRemove.getParent(), leftMostNode);
		} else {
			connectToParent(true, leftMostNode, nodeToRemove.getLeftChild());
			connectToParent(true, leftMostNode.getParent(), leftMostNode.getRightChild());
			connectToParent(false, leftMostNode, nodeToRemove.getRightChild());
			connectToParent(hasLeft, nodeToRemove.getParent(), leftMostNode);
		}
	}
}