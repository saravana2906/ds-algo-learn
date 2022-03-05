package com.sars.algo;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {

	public static List<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		
		int[] nums = {1,2,9,4,6};
		startCombinations(nums);
	}

	private static void startCombinations(int[] nums) {	
		Stack<Integer> stack = new Stack<Integer>();
		combinations(0,stack,nums);
	}

	private static void combinations(int index, Stack<Integer> stack, int[] nums) {
		
		if(index==nums.length) {
			stack.stream().forEach(System.out::print);
			System.out.println();
			return;
		}
		
		stack.add(nums[index]);
		combinations(index+1,stack,nums);
		stack.pop();
		combinations(index+1, stack, nums);
	}
	

}
