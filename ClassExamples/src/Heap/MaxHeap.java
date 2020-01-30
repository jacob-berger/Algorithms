package Heap;

public class MaxHeap {

	/*
	 * a complete binary tree with its nodes containing Comparable objects and are organized as either a minheap or maxheap
	 * min - smallest node is at the top with increasing values as you descend
	 * max - largest node is at the top
	 * 
	 * the subtree of any node in a min or maxheap is also the corresponding heap
	 * left child of an index (3) is 2 * index + 1, right is 2 * index + 2, parent is (index - 1) / 2
	 * 
	 * siftdown algorithm
	 * input: a complete binary tree with left/right subtrees having been maxheaps already, except for the root that violates the maxheap property
	 * output: a maxheap
	 * 
	 * if root is not greater than both children, swap root data with larger child
	 * reapply the operation on the modified subtree until you reach the bottom of the tree or until no subtree is modified
	 */
	
	class Node {
		Node left, right;
		Comparable data;
		
		private Node(Comparable data) {
			this.data = data;
		}
	}
	
	Node root;
	
	public MaxHeap() {
		root = null;
	}
	
	public void add(Comparable element) {
		
	}
	
	public Comparable getMax() { //return the largest element in the heap
		return null;
	}
	
	public Comparable removeMax() { //remove the largest element in the heap
		return null;
	}
	
}
