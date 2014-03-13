package com.test;

import  static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import com.controller.impl.CntrlAfficherListeHotels;

public class Test {
	
		
		
	public static void main(String args[]) throws ParseException{
//		System.out.println(Test.story);
//		String st="03/18/2014"; 
//		Date d=new SimpleDateFormat("MM/dd/yyyy").parse(st);
//		System.out.println(d);
		int[][] a = {{1,2,}, {3,4}};
		int[] b = (int[]) a[1];
		 Object o1 = a;
		 int[][] a2 = (int[][]) o1;
		 int[] b2 = (int[]) o1;
		System.out.println(b[1]);
	}

}
