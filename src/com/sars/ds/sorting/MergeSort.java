package com.sars.ds.sorting;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] a = {3,8,1,9,2,5,8,6,10,7,4};
		
		mergeSort(a);
		
		for(int ele : a) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}

	public static void mergeSort(int[] toSort) {
		if(toSort.length == 1) {
			return ;
		}
		int middleIndex = toSort.length / 2 + toSort.length % 2;
		int[] firstHalf = new int[middleIndex];
		int[] secondHalf = new int[toSort.length - middleIndex];
		split(toSort,firstHalf,secondHalf);
		mergeSort(firstHalf);
		mergeSort(secondHalf);
		merge(toSort,firstHalf, secondHalf);
		
	}
	
	public static void split(int[] toSplit, int[] firstHalf, int[] secondHalf) {
		int index =0 , secondHalfStartIndex = firstHalf.length;
		for(int eachElement : toSplit) {
			if(index < secondHalfStartIndex) {
				firstHalf[index] = eachElement;
			} else {
				secondHalf[index-secondHalfStartIndex] = eachElement;
			}
			index++;
		}
	}
	public static void merge(int[] toSort,int[] firstHalf, int[] secondHalf) {
		int mergeIndex=0 , firstHalfIndex = 0, secondHalfIndex =0;
		
		while(firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length) {
			if(firstHalf[firstHalfIndex] < secondHalf[secondHalfIndex]) {
				toSort[mergeIndex++] = firstHalf[firstHalfIndex++];
			} else if(secondHalfIndex < secondHalf.length) {
				toSort[mergeIndex++] = secondHalf[secondHalfIndex++];
			}		
		}
		if(firstHalfIndex < firstHalf.length) {
			while(firstHalfIndex < firstHalf.length) {
				toSort[mergeIndex++] = firstHalf[firstHalfIndex++];
			}
		}
		if(secondHalfIndex < secondHalf.length) {
			while(secondHalfIndex < secondHalf.length) {
				toSort[mergeIndex++] = secondHalf[secondHalfIndex++];
			}
		}
	}
	
}
