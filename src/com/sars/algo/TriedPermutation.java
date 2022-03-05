package com.sars.algo;
import java.util.ArrayList;

public class TriedPermutation {
	
	
	
	public static void main(String[] args) {
		
		String word ="abcd";
		startPermutation(word);
	}
	
	
	
	
	private static void startPermutation(String word) {
		
		ArrayList<String> allPermutation = new ArrayList<String>();
		boolean[] selectedStringPositions = new boolean[word.length()];
		String baseWord ="";
		permutation(word,allPermutation,selectedStringPositions,baseWord);
		System.out.println("--------------------------------");
		allPermutation.forEach(System.out::println);
	}




	private static void permutation(String word, ArrayList<String> allPermutation, boolean[] selectedStringPositions,
			String baseWord) {
		if(baseWord.length()==word.length()) {
			allPermutation.add(baseWord);
			return;
		}
		for(int i=0;i<word.length();i++) {
			if(!selectedStringPositions[i]) {
				String tmpBaseWord = baseWord;
				baseWord = baseWord + word.charAt(i);
				System.out.println("tmpBaseWord "+ tmpBaseWord + "baseWord "+ baseWord);
				selectedStringPositions[i]=true;
				permutation(word,allPermutation,selectedStringPositions,baseWord);
				baseWord = tmpBaseWord;
				selectedStringPositions[i]=false;
			}
		}
		
	}




}
