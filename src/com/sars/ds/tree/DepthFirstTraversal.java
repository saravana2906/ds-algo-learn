package com.sars.ds.tree;

public class DepthFirstTraversal {
	
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
		
		//preOrderTraversal(root);
//		postOrderTraversal(root);
		inOrderTraversal(root);
	}
	public static <T>void preOrderTraversal(Node<T> element){
		if(element == null) {
			return;
		}
		System.out.print(" "+element.getData()+"-->");
		preOrderTraversal(element.getLeftChild());
		preOrderTraversal(element.getRightChild());
	}
	public static <T>void postOrderTraversal(Node<T> element){
		if(element == null) {
			return;
		}
		postOrderTraversal(element.getLeftChild());
		postOrderTraversal(element.getRightChild());
		System.out.print(" "+element.getData()+"-->");
	}
	
	public static <T>void inOrderTraversal(Node<T> element){
		if(element == null) {
			return;
		}
		inOrderTraversal(element.getLeftChild());
		System.out.print(" "+element.getData()+"-->");
		inOrderTraversal(element.getRightChild());
		
	}
	
	
	

}
