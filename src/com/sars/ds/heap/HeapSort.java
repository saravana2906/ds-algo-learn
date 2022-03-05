package com.sars.ds.heap;

public class HeapSort {

	public static void main(String[] args) throws Exception {
		
		int[] array= {23,45,1,8,2,90,17,11,6,27,35};
		
		print(array);
		heapSort(array);
		print(array);
	}

	private static void heapSort(int[] array) throws Exception {
		
		heapify(array,array.length-1,array.length-1);
		print(array);
		arrangeAsSorted(array);
				
	}

	private static void arrangeAsSorted(int[] array) {
		
		int endIndex = array.length-1;
		
		while(endIndex > 0) {
			int temp = array[endIndex];
			array[endIndex]=array[0];
			array[0]=temp;
			percolateDown(array, 0, --endIndex);
		}
		
	}

	private static void heapify(int[] array,int index, int endIndex) throws Exception {
		
		int parentIndex = getParentIndex(index,endIndex);
		
		while(parentIndex >=0 ) {
			percolateDown(array,parentIndex,endIndex);
			parentIndex --;
		}
		
	}
	
	

	private static void percolateDown(int[] array, int parentIndex, int endIndex) {
		
		int leftChildIndex = getLeftChildIndex(parentIndex, endIndex);
		int rightChildIndex = getRightChildIndex(parentIndex, endIndex);
		
		int largerIndex = -1;
		if(leftChildIndex != -1 && rightChildIndex != -1) {
			largerIndex = array[leftChildIndex]>array[rightChildIndex] ? leftChildIndex : rightChildIndex; 
		} else if (leftChildIndex != -1 ){
			largerIndex = leftChildIndex;
		} else if (rightChildIndex != -1 ) {
			largerIndex = rightChildIndex;
		}
		
		if(largerIndex == -1) {
			return;
		}
		
		if(array[largerIndex] > array[parentIndex]) {
			int temp = array[largerIndex];
			array[largerIndex] = array[parentIndex];
			array[parentIndex] = temp;
			
			percolateDown(array, largerIndex, endIndex);
		}
		
	}

	private static int getParentIndex(int index, int endIndex) throws Exception {
		if(index < 0 || endIndex < index) {
			return -1;
		}
		return ((index-1) /2);
	}
	
	private static int getLeftChildIndex(int parentIndex,int endIndex) {
		
		int leftChildIndex = (2*parentIndex)+1;
		
		if(parentIndex < 0 || endIndex < parentIndex || leftChildIndex>endIndex) {
			return -1;
		}
		
		return leftChildIndex;
	}
	
	private static int getRightChildIndex(int parentIndex,int endIndex) {
                 int rightChildIndex = (2*parentIndex)+2;
		
				if(parentIndex < 0 || endIndex < parentIndex || rightChildIndex>endIndex) {
					return -1;
				}
				return rightChildIndex;
	}
	
	

	private static void print(int[] array) {
		for(int each: array) {
			System.out.print(each+" ");
		}
		System.out.println();	
	}
	
	
	
	
	
	
}
