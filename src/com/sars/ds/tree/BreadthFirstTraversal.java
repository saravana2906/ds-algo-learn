package com.sars.ds.tree;

import java.util.LinkedList;

import com.sars.ds.queue.Queue;

public class BreadthFirstTraversal {

	public static void main(String[] args) {
		LinkedList<Node<Character>> processingQueue = new LinkedList<Node<Character>>();
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
		processingQueue.add(root);
		while(!processingQueue.isEmpty()) {
			Node<Character> element = processingQueue.poll();
			if(null != element.getLeftChild())
			processingQueue.add(element.getLeftChild());
			if(null != element.getRightChild())
			processingQueue.add(element.getRightChild());
			System.out.print(" "+element.getData().charValue()+"-->");
		}
		
		
	}
	
}
