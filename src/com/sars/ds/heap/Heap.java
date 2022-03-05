package com.sars.ds.heap;

import java.lang.reflect.Array;



public abstract class Heap<T extends Comparable> {
	
    private static int MAX_SIZE = 40;
    private T[] array;
    private int count = 0;
    
    public Heap(Class<T> clazz) {
    	this.array = (T[]) Array.newInstance(clazz, Heap.MAX_SIZE);
    }
    
    public Heap(Class<T> clazz,int maxSize) {
    	this.array = (T[]) Array.newInstance(clazz,maxSize);
    }
    
    public int getCount() {
    	return this.count;
    }
    
    public T getElementAtIndex(int index) {
    	return array[index];
    }
    
    public T getHighestPriority() throws HeapEmptyException {    	
    	if(count==0) {
    		throw new HeapEmptyException();
    	}
    	return array[0];
    }
    
    
    public int getLeftChildindex(int parentIndex) {
    	int leftChildIndex = (2*parentIndex) + 1;
    	if(leftChildIndex >= count) {
    		leftChildIndex = -1;
    	}
    	return leftChildIndex;
    }
    
    public int getRightChildIndex(int parentIndex) {
    	int rightChildIndex = (2*parentIndex) + 2;
    	if(rightChildIndex >= count) {
    		rightChildIndex = -1;
    	}
    	return rightChildIndex;
    }
    
    public int getParentIndex(int childIndex) {
    	int parentIndex = (childIndex-1)/2;
    	if(parentIndex>=count) {
    		parentIndex = -1;
    	}
    	return parentIndex;
    }
    
    public void insert(T element) throws HeapFullException {
    	if (count >= array.length) {
            throw new HeapFullException();
        }
    	this.array[count]= element;
    	this.shiftUp(count);;
    	count++;
    }
    
    public boolean isEmpty() {
     return count==0;
    }
    
    public boolean isFull() {
    	return count == this.array.length;
    }
    
    public void printHeapArray() {
    	for(int i=0;i<count;i++) {
    		System.out.print(this.array[i].toString()+" ");
    	}
    	System.out.println();
    }
    
    public void removeHighestPriority() throws HeapEmptyException {
    	if(count==0) {
    		throw new HeapEmptyException();
    	}
    	swap(0,this.count-1);
    	this.shiftDown(0);
    	count--;
    	System.out.println("new Highest priority "+ this.array[0].toString());
    }
    
   
    
    public void swap(int i, int j) {
		T temp=this.array[i];
		this.array[i] = this.array[j];
		this.array[j]= temp;
		
	}

	public abstract void shiftUp(int index);
    
    public abstract void shiftDown(int index);
    
    public static class HeapEmptyException extends Exception {
    	
    }
    
 public static class HeapFullException extends Exception {
    	
    }

}
