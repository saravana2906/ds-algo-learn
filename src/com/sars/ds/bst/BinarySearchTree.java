package com.sars.ds.bst;


public class BinarySearchTree<T extends Comparable> {

	private Node<T> root;
	
	@Override
	public String toString() {
		return "BinarySearchTree [root=" + root + "]";
	}

	public BinarySearchTree(Node<T> rootNode) {
		this.root = rootNode;
	}
	
	public Node<T> insert(Node<T> currentNode, T element) throws Exception {
		if(currentNode==null) {
			return new Node<T>(element);
		}
		
		if(currentNode.getData().compareTo(element)>=0) {
			currentNode.setLeftChild(this.insert(currentNode.getLeftChild(), element));
		} else {
			currentNode.setRightChild(this.insert(currentNode.getRightChild(), element));
		}
		return currentNode;
	}
	
	public Node<T> lookup(Node<T> head,T value){
		
		if(head==null) {
			return null;
		}
		
		if(head.getData().compareTo(value)==0) {
			return head;
		}
		
		if(head.getData().compareTo(value)>=0) {
			return this.lookup(head.getLeftChild(), value);
		} else {
			return this.lookup(head.getRightChild(),value);
		}
		
	}
	
	public void delete(T value) {
		
	}
	
	public Node<T> insert(T element) throws Exception {
		return this.insert(this.root, element);
	}
	
	public Node<T> lookup(T element){
		return this.lookup(this.root, element);
	}
	
	  public static void print(Node node) {
	        System.out.print(node.getData().toString() + "->");
	    }
	  
	  public void inOrder() {
		  this.inOrder(this.root);
	  }
	  public void inOrder(Node<T> element) {
		  if(element==null) {
			  return ;
		  }
		  inOrder(element.getLeftChild());
		  print(element);
		  inOrder(element.getRightChild());
	  }
	  
	  
}
