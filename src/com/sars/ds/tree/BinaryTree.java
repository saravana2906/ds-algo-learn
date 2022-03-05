package com.sars.ds.tree;

public class BinaryTree<T> {
	
	private Node<T> root;
	
	public BinaryTree(Node<T> root) {
		this.root = root;
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	public static void main(String[] args) {
		Node<Character> root = new Node<Character>(Character.valueOf('A'));
		BinaryTree<Character> btree = new BinaryTree<Character>(root);
		Node<Character> leftChild = new Node<Character>(Character.valueOf('B'));
		Node<Character> rightChild = new Node<Character>(Character.valueOf('C'));
		Node<Character> D = new Node<Character>(Character.valueOf('D'));
		Node<Character> E = new Node<Character>(Character.valueOf('E'));
		Node<Character> F = new Node<Character>(Character.valueOf('F'));
		Node<Character> G = new Node<Character>(Character.valueOf('G'));
		root.setLeftChild(leftChild);
		root.setRightChild(rightChild);
		leftChild.setLeftChild(D);
		leftChild.setRightChild(E);
		rightChild.setLeftChild(F);
		rightChild.setRightChild(G);
		
		System.out.println(btree);
	}

	@Override
	public String toString() {
		return "BinaryTree [root=" + root + "]";
	}
	
	
}
