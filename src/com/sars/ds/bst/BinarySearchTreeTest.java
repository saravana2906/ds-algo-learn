package com.sars.ds.bst;



public class BinarySearchTreeTest {

	public static void main(String[] args) throws Exception {

        Node<Integer> five = new Node<>(5);
     
        
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(five);
        
        bst.insert(4);
        bst.insert(6);
        bst.insert(9);
        bst.insert(1);
        bst.insert(2);
        bst.insert(10);
        bst.insert(3);
        bst.insert(7);
        bst.insert(8);
        bst.insert(5);
        
        bst.inOrder();
        
        System.out.println("--------");
        System.out.println(bst);
	}
}
