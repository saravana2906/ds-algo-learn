package com.sars.ds.sorting;

public class SelectionSort {
	
	
	public static void main(String args[]) {
		int[] list= {10,9,8,7,6,5,4,3,2,1} , list1= {3,6,1,2,9,7};
		
		int[] ans = selectionSort(list);
		for ( int no : ans) {
			System.out.print(no+" ");
		}
	}

	private static int[] selectionSort(int[] list) {
		int noofSwaps=0;
		for(int i=0;i<list.length;i++) {
			System.out.println("-----------"+i+"th position sorting intiated"+"------------------");
			for(int j=i+1;j<list.length;j++) {
				if(list[i]>list[j]) {
					list[i]=list[i]+list[j];
					list[j]=list[i]-list[j];
					list[i]=list[i]-list[j];
					noofSwaps++;
					for(int k=0;k<list.length;k++) {
						System.out.print(list[k]+" ");
					}
					System.out.println();
				}
			}
			System.out.println("-----------"+i+"th position sorting Ended"+"------------------");
		}
		
		System.out.println("selection sort - No of Swaps "+ noofSwaps);
		
		return list;
	}

}
