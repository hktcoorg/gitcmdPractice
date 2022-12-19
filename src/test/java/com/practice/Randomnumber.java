package com.practice;

import java.util.Random;

public class Randomnumber {
	
	public static void main(String[] args) {
		 Random rm=new Random();
		 int randomNumber = rm.nextInt(100);   //0 to 100 number it will generate
		 System.out.println(randomNumber);
		 
		 int rm1=new Random().nextInt(100);
		    //0 to 100 number it will generate
		 System.out.println(rm1);
	}

}
