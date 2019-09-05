
/*
 * Daily Coding Problem #8
 * Source: dailycodingproblem.com
 * Author: Cole Thomson
 * Date: 09/04/2019
 * TTS: 120
 */

// A unival tree (which stands for "universal value") is a tree where all nodes
// under it have the same value.
//
// Given the root to a binary tree, count the number of unival subtrees.
//
// For example, the following tree has 5 unival subtrees:
//   0
//  / \
// 1   0
//    / \
//   1   0
//  / \
// 1   1

/**
 * Main class that contains all fields and methods for solving the proposed
 * problem.
 * @author Cole Thomson
 *
 */
public class DCP8 {
	
	/**
	 * Main method to test methods that solve problem
	 * @param args - unused
	 */
	public static void main(String[] args) {
		
		// Nodes (bottom-up)
		Node n1 = new Node(1, null, null);
		Node n2 = new Node(1, null, null);
		Node n3 = new Node(1, n1, n2);
		Node n4 = new Node(0, null, null);
		Node n5 = new Node(0, n3, n4);
		Node n6 = new Node(1, null, null);
		Node root = new Node(0, n6, n5);	// root of binary tree

		System.out.println("test01countUnivalTrees \n"  
				+ "-Expected: 5 \n"
				+ "-Actual: " + countUnivalTrees(root));
		

 	}

	/**
	 * Counts the number of unival subtrees that exist in the binary tree. 
	 * Traverses the binary tree in-order and checks if each node is a unival
	 * tree.
	 * @param node - current node to traverse or check if is a subtree. 
	 * @return num - number of unival subtrees in the binary tree.
	 */
	public static int countUnivalTrees(Node node) {
		int num = 0; // number of subtrees
		
		// Traverse the tree (in order)
		if (node == null) {
			return 0;
		}
		// Traverse Left
		num += countUnivalTrees(node.left);
		
		// Visit Node - check if node meets unival tree criteria
		if (isUnivalTree(node)) {
			num += 1;
		}
		
		// Traverse Right
		num += countUnivalTrees(node.right);
		
		return num;
		
	}
	
	/**
	 * Determines if the subtree is a (binary) unival tree or not. If the 
	 * subtree has no children, then it is a unival tree. If the subtree has 
	 * two children and they both match the value of the parent, then it is a
	 * unival tree. If the subtree has one child and its value matches the value
	 * of the parent, then it is a unival tree. Otherwise the subtree is not a
	 * unival tree. 
	 * @param root - root of the binary subtree
	 * @return true of the subtree is a unival tree
	 */
	static boolean isUnivalTree(Node root) {
		boolean temp = false;
		
		// Base case
		if (root.right == null && root.left == null) {
			return true;
		}
		// If right and left node are not null
		if (root.left != null && root.right != null) {
			// If the root matches the children
			if (root.value == root.left.value
					&& root.value == root.right.value) {
			
				temp = isUnivalTree(root.left);
				// If left is not a unival tree, return false
				if (!temp) {
					return false;
				}
				// else check the right subtree
				else {
					return (isUnivalTree(root.right));
				}
			}
			// Else not a unival tree
			else {
				return false;
			}
		}
		// Else If the left node is not null
		else if (root.left != null) {
			// if the root and the left match
			if (root.value == root.left.value) {
				// traverse left subtree
				return isUnivalTree(root.left);
			}
			// Else not a unival tree
			else {
				return false;
			}
		}
		// Else the right node is not null
		else {
			// if the root and the left match
			if (root.value == root.right.value) {
				// traverse right subtree
				return isUnivalTree(root.right);
			}
			// Else not a unival tree
			else {
				return false;
			}
		}
}		
}
/**
 * Binary node class. Contains fields for value at node, left child, and right
 * child. Contains a constructor for making node and initializing fields.
 * @author Cole Thomson
 *
 */
class Node {
		int value;
		Node left;
		Node right;
		
		/**
		 * Constructor for initializing node.
		 * @param value - value of node
		 * @param left - left child of node
		 * @param right - right child of node
		 */
		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
}