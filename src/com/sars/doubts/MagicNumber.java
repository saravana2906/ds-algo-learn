package com.sars.doubts;

public class MagicNumber implements Comparable<MagicNumber> {

	public Integer number;
	
	public  MagicNumber(Integer a) {
		this.number=a;
	}
	
	@Override
	public int compareTo(MagicNumber o) {
		// TODO Auto-generated method stub
		return this.number.compareTo(o.number);
	}
	
	public static void main(String[] args) {
		MagicNumber one = new MagicNumber(1);
		MagicNumber two = new MagicNumber(2);
		MagicNumber three = new MagicNumber(3);
		System.out.println("one object calling by passing two "+ one.compareTo(two));
		System.out.println("Two object calling by passing one "+ two.compareTo(one));
		System.out.println("one object calling by passing one "+ one.compareTo(one));
		if(one.compareTo(two) <=0) {
			System.out.println("One is less than or equal to two");
		}
		
	}
	
}
