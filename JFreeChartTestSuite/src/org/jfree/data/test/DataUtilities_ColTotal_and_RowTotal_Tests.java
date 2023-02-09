package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.*;
import org.junit.*;

//These tests are for the calculateColumnTotal() and calculateRowTotal() methods in DataUtilities.

//Author: Aarushi

public class DataUtilities_ColTotal_and_RowTotal_Tests {

	private Values2D values;
  
	
    @Before
    public void setUp() throws Exception { 
	    Mockery mockingContext = new Mockery();
	    values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	        	//Make a 4x4 table with random values

				// -7,   0,     6.5,   9
				// 56,   82.5,  31,    100
				// 3,   -25.6,  2589,  90
				// -6.5, 33,    1,     -9


	            one(values).getRowCount();
	            will(returnValue(4));
	            one(values).getColumnCount();
	            will(returnValue(4));
	            
	           //populating data for row 0
	            one(values).getValue(0, 0);
	            will(returnValue(-7));
	            one(values).getValue(0, 1);
	            will(returnValue(0));
	            one(values).getValue(0, 2);
	            will(returnValue(6.5));
				one(values).getValue(0, 3);
	            will(returnValue(9));
	            
	           //populating data for row 1
	            one(values).getValue(1, 0);
	            will(returnValue(56));
	            one(values).getValue(1, 1);
	            will(returnValue(82.5));
	            one(values).getValue(1, 2);
	            will(returnValue(31));
				one(values).getValue(1, 3);
	            will(returnValue(100));
	            
	            //populating data for row 2
	            one(values).getValue(2, 0);
	            will(returnValue(3));
	            one(values).getValue(2, 1);
	            will(returnValue(-25.6));
	            one(values).getValue(2, 2);
	            will(returnValue(2589));
				one(values).getValue(2, 3);
	            will(returnValue(90));

				//populating data for row 3
	            one(values).getValue(3, 0);
	            will(returnValue(-6.5));
	            one(values).getValue(3, 1);
	            will(returnValue(33));
	            one(values).getValue(3, 2);
	            will(returnValue(1));
				one(values).getValue(3, 3);
	            will(returnValue(-9));


				//populating invalid row and column index

				//negative row index
	            one(values).getValue(-5, 0);
	            will(returnValue(1));
	            one(values).getValue(-5, 1);
	            will(returnValue(2));
	            one(values).getValue(-5, 2);
	            will(returnValue(3));
				one(values).getValue(-5, 3);
	            will(returnValue(4));
	            
	            //negative column index
	            one(values).getValue(0, -5);
	            will(returnValue(1));
	            one(values).getValue(1, -5);
	            will(returnValue(2));
	            one(values).getValue(2, -5);
	            will(returnValue(3));
				one(values).getValue(3, -5);
	            will(returnValue(4));
	
	            
	            //out of bounds row index
	            one(values).getValue(4, 0);
	            will(returnValue(1));
	            one(values).getValue(4, 1);
	            will(returnValue(2));
	            one(values).getValue(4, 2);
	            will(returnValue(3));
				one(values).getValue(4, 3);
	            will(returnValue(4));
	            
	         
	            //out of bounds column index
	            one(values).getValue(0, 4);
	            will(returnValue(1));
	            one(values).getValue(1, 4);
	            will(returnValue(2));
	            one(values).getValue(2, 4);
	            will(returnValue(3));
				one(values).getValue(3, 4);
	            will(returnValue(4));
	        }
	    });
    }



// ==================================================================== calculateColumnTotal ============================================================================

// public static double calculateColumnTotal(Values2D data, int column)
// Returns the sum of the values in one column of the supplied data table. With invalid input, a total of zero will be returned.
// Parameters:
// data - the table of values (null not permitted).
// column - the column index (zero-based).
// Returns:
// The sum of the values in the specified column.
// Throws:
// InvalidParameterException - if invalid data object is passed in.


	//This test is for summing the values of the column at index 0. Index 0 is the first one so it's a boundary value. Expected sum is 45.5
	@Test 
   	public void calculateColumnTotal_firstColumnIndex() {
    	double result= DataUtilities.calculateColumnTotal(values, 0);
    	assertEquals("Sum of the column at the first index is",  45.5, result, .000000001d);
    }

	//This test is for summing the values of the column at index 2. Index 2 is a sample within the equivalence class and not a boundary value. Expected sum is 2627.5
	@Test 
   	public void calculateColumnTotal_middleColumnIndex() {
    	double result= DataUtilities.calculateColumnTotal(values, 2);
    	assertEquals("Sum of the column is",  2627.5, result, .000000001d);
    }

	//This test is for summing the values of the column at index 3. Index 3 is the last one so it's a boundary value. Expected sum is 190
	@Test 
   	public void calculateColumnTotal_lastColumnIndex() {
    	double result= DataUtilities.calculateColumnTotal(values, 3);
    	assertEquals("Sum of the column at the last index is",  190, result, .000000001d);
    }
    
   
	//This test is for an out of bounds column index input so the sum is expected to be 0.
    @Test 
   	public void calculateColumnTotal_outOfBoundsColumnIndex() {
    	double result= DataUtilities.calculateColumnTotal(values, 4);
    	assertEquals("Sum of a column with an out of bounds index is",  0, result, .000000001d);
    }

    //This test is for a negative (invalid) column index input so the sum is expected to be 0.
    @Test 
   	public void calculateColumnTotal_negativeColumnIndex() {
    	double result= DataUtilities.calculateColumnTotal(values, -5);
    	assertEquals("Sum of a column with a negative index is",  0, result, .000000001d);
    }

	 //This test is for a null object passed in for the first parameter. Expected to throw IllegalArgumentException.
	 @Test (expected = IllegalArgumentException.class)
	 public void calculateColumnTotal_nullDataObject() {
	  DataUtilities.calculateColumnTotal(null, 1);
  }
   

 // ==================================================================== calculateRowTotal ============================================================================   

// public static double calculateRowTotal(Values2D data, int row)
// Returns the sum of the values in one row of the supplied data table. With invalid input, a total of zero will be returned.
// Parameters:
// data - the table of values (null not permitted).
// row - the row index (zero-based).
// Returns:
// The total of the values in the specified row.
// Throws:
// InvalidParameterException - if invalid data object is passed in.
  

	//This test is for summing the values of the row at index 0. Index 0 is the first one so it's a boundary value. Expected sum is 8.5
	@Test 
   	public void calculateRowTotal_firstRowIndex() {
    	double result= DataUtilities.calculateRowTotal(values, 0);
    	assertEquals("Sum of the row at the first index is",  8.5, result, .000000001d);
    }

	//This test is for summing the values of the row at index 2. Index 2 is a sample within the equivalence class and not a boundary value. Expected sum is 2656.4
	@Test 
   	public void calculateRowTotal_middleRowIndex() {
    	double result= DataUtilities.calculateRowTotal(values, 2);
    	assertEquals("Sum of the row is",  2656.4, result, .000000001d);
    }

	//This test is for summing the values of the row at index 3. Index 3 is the last one so it's a boundary value. Expected sum is 18.5
	@Test 
   	public void calculateRowTotal_lastRowIndex() {
    	double result= DataUtilities.calculateRowTotal(values, 3);
    	assertEquals("Sum of the row at the last index is",  18.5, result, .000000001d);
    }
    
   
	//This test is for an out of bounds row index input so the sum is expected to be 0.
    @Test 
   	public void calculateRowTotal_outOfBoundsRowIndex() {
    	double result= DataUtilities.calculateRowTotal(values, 4);
    	assertEquals("Sum of a row with an out of bounds index is",  0, result, .000000001d);
    }

    //This test is for a negative (invalid) row index input so the sum is expected to be 0.
    @Test 
   	public void calculateRowTotal_negativeRowIndex() {
    	double result= DataUtilities.calculateRowTotal(values, -5);
    	assertEquals("Sum of a row with a negative index is",  0, result, .000000001d);
    }

	 //This test is for a null object passed in for the first parameter. Expected to throw IllegalArgumentException.
	 @Test (expected = IllegalArgumentException.class)
	 public void calculateRowTotal_nullDataObject() {
	  DataUtilities.calculateRowTotal(null, 1);
  }


   

   
}
