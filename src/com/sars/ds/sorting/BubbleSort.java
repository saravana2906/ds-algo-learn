package com.sars.ds.sorting;

public class BubbleSort {
	
	public static void main(String args[]) {
		int[] list= {10,9,8,7,6,5,4,3,2,1} , list1= {3,6,1,2,9,7};
		
		int[] ans = bubbleSort(list);
		for ( int no : ans) {
			System.out.print(no+" ");
		}
	}

	private static int[] bubbleSort(int[] list) {
		int noOfSwaps = 0;
		boolean swap = true;
		for(int j=0;j<list.length;j++) {
//			System.out.println("Iteration "+ j + "started");
			if(!swap)
				break;
			swap=false;
			for(int i=list.length-1; i>j;i--) {
				if(list[i]<list[i-1]) {
					list[i]=list[i]+list[i-1];
					list[i-1]=list[i]-list[i-1];
					list[i]=list[i]-list[i-1];
					swap=true;
					noOfSwaps++;
					/*
					 * for(int k=0;k<list.length;k++) { System.out.print(list[k]+" "); }
					 * System.out.println();
					 */
				}
			}
//			System.out.println("Iteration "+ j + "Ended");
		}
		System.out.println("No of swaps "+ noOfSwaps);
		return list;
	}
	
}
