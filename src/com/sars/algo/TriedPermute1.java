package com.sars.algo;

public class TriedPermute1 {

	public static void main(String[] args) {
		String word ="abcd";
		startPermute(word);
	}

	private static void startPermute(String word) {
		permute(0,word);
		
	}

	private static void permute(int index,String word) {
		if(index==word.length()) {
			System.out.println(word);
			return;
		}
		
		for(int i=index;i<word.length();i++) {
			word=swap(index,i,word);
			permute(index+1,word);
			word=swap(index,i,word);
		}
		
	}

	private static String swap(int index, int i, String word) {
		char temp = word.charAt(index);
		char tempi = word.charAt(i);
		char[] wordArray = word.toCharArray();
		wordArray[index]=tempi;
		wordArray[i]=temp;
		word = new String(wordArray);
		return word;
	}
	
	
}
