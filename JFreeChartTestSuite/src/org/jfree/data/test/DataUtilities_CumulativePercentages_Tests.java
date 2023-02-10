package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.*;
import org.junit.*;
import java.util.ArrayList;

//These tests are for the getCumulativePercentages method in DataUtilities.

//Author: Jonathan 

public class DataUtilities_CumulativePercentages_Tests {

	private KeyedValues values;
	
    @Before
    public void setUp() throws Exception { 
	    Mockery mockingContext = new Mockery();
	    values = mockingContext.mock(KeyedValues.class);
		ArrayList<Integer> keys = new ArrayList<Integer>();  
		keys.add(0);
		keys.add(1);
		keys.add(2);
	    mockingContext.checking(new Expectations() {
	        {
	        	//getItemCount
	        	allowing(values).getItemCount();
	        	will(returnValue(3));
	        	
				// getKeys
                allowing(values).getKeys();
				will(returnValue(keys));
				
				//getIndex
				allowing(values).getIndex(0);
				will(returnValue(0));
				allowing(values).getIndex(1);
				will(returnValue(1));
				allowing(values).getIndex(2);
				will(returnValue(2));

				//getValue
				allowing(values).getValue(0);
				will(returnValue(5));
				allowing(values).getValue(1);
				will(returnValue(9));
				allowing(values).getValue(2);
				will(returnValue(2));


				//getKey
				allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getKey(1);
				will(returnValue(1));
				allowing(values).getKey(2);
				will(returnValue(2));
	        }
	    });
    }



	//This test is for verifying the cumulative average found is accurate and between 0:1 for the first value. Expected sum is 0.3125 (5/16)
	@Test 
   	public void getCumulativePercentages_firstValue() {
    	KeyedValues result = DataUtilities.getCumulativePercentages(values);
    	assertEquals("Resulting keys is", result.getKeys(), values.getKeys());
		assertEquals("Cumulative percentage for element 0 is", 0.3125, result.getValue(result.getKey(0)));
    }

	//This test is for verifying the cumulative average found is accurate for the last value is 1.0 (16/16)
	@Test
   	public void getCumulativePercentages_lastValue() {
    	KeyedValues result = DataUtilities.getCumulativePercentages(values);
    	assertEquals("Resulting keys is", result.getKeys(), values.getKeys());
		assertEquals("Cumulative percentage for element 0 is", 1.0, result.getValue(result.getKey(result.getKeys().size()-1)));
    }
	
	 //This test is for a null object passed in for the first parameter. Expected to throw IllegalArgumentException.
	@Test (expected = IllegalArgumentException.class)
	public void getCumulativePercentages_nullDataObject() {
		DataUtilities.getCumulativePercentages(null);
	}
   
}
