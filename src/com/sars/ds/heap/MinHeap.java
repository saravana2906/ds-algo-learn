package com.sars.ds.heap;



public class MinHeap<T extends Comparable> extends Heap<T> {

	public MinHeap(Class<T> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void shiftUp(int index) {
		
		int parentIndex = getParentIndex(index);
		
		if(parentIndex!= -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0) {
			swap(index,parentIndex);
			shiftUp(parentIndex);
		}
		
	}

	@Override
	public void shiftDown(int index) {
		
		int leftChildIndex = this.getLeftChildindex(index);
		int rightChildIndex = this.getRightChildIndex(index);
		
		int smallerIndex = -1;
		if(leftChildIndex != -1 && rightChildIndex != -1) {
		smallerIndex=getElementAtIndex(leftChildIndex).compareTo(getElementAtIndex(rightChildIndex))<=0 ? leftChildIndex : rightChildIndex;
		} else if ( leftChildIndex != -1 ) {
			smallerIndex = leftChildIndex;
		} else if (rightChildIndex != -1) {
			smallerIndex = rightChildIndex;
		}
		
		if(smallerIndex == -1) {
			return;
		}
		
		if(getElementAtIndex(index).compareTo(getElementAtIndex(smallerIndex)) > 0) {
			swap(index,smallerIndex);
			shiftDown(smallerIndex);
		}
		
	}
	
	
	
	public static void main(String[] args) throws HeapFullException, HeapEmptyException {
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);

        minHeap.insert(9);
        minHeap.insert(4);
        minHeap.insert(17);
        minHeap.printHeapArray();
        minHeap.insert(6);
        minHeap.printHeapArray();

        minHeap.insert(100);
        minHeap.insert(20);
        minHeap.printHeapArray();
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.printHeapArray();

        minHeap.removeHighestPriority();
        minHeap.printHeapArray();
        minHeap.removeHighestPriority();
        minHeap.printHeapArray();
    }

}
