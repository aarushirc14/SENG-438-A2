package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;


//These tests are for the getLength() method in Range.

//Author: Aarushi

public class Range_getLength_Tests {
	
	//This test is for getting the length of the range between two positve integers. Expected length = 5
	@Test 
   	public void getLength_positiveIntegers() {
        Range range= new Range(31,36);
    	double result= range.getLength();
    	assertEquals("Length between 31 and 36 is",  5, result, .000000001d);
    }

    //This test is for getting the length of the range between a negative and positive integer. Expected length = 200
	@Test 
    public void getLength_negativeAndPositiveIntegers() {
     Range range= new Range(-100,100);
     double result= range.getLength();
     assertEquals("Length between -100 and 100 is",  200, result, .000000001d);
 }

    //This test is for getting the length of the range between a negative integer and positive double. Expected length = 440.5
    @Test 
    public void getLength_negativeAndPositiveDoubles() {
    Range range= new Range(-28,440.5);
    double result= range.getLength();
    assertEquals("Length between -28 and 440.5 is",  468.5, result, .000000001d);
    }

    //This test is for getting the length of the range between a large negative and large positive. Expected length = 2000000
    @Test 
    public void getLength_largeNegativeAndPositive() {
    Range range= new Range(-1000000,1000000);
    double result= range.getLength();
    assertEquals("Length between -1000000 and 1000000 is",  2000000, result, .000000001d);
    }
    
    //This test is for getting the length of 0. Expected length = 0
    @Test 
    public void getLength_zero() {
    Range range= new Range(2,2);
    double result= range.getLength();
    assertEquals("Length between 2 and 2 is",  0, result, .000000001d);
    }
}
    
