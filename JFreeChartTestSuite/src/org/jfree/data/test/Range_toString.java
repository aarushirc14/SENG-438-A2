package org.jfree.data.test;

import static org.junit.Assert.*; 

import org.jfree.data.Range; 

import org.junit.*;

public class Range_toString {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    }


    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    

    @Test
    public void testZeroPositive() {
        assertEquals("A String \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
        "0.0,1.0", exampleRange.toString());
        System.out.println(exampleRange.toString());
    }
    @Test
    public void edgecaseNegativePositive() {
    	assertEquals("A String \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
    	"-2.0,3.0", exampleRange.toString());
    	System.out.println(exampleRange.toString());
    }
    @Test
    public void edgecaseNegativeNegative() {
    	assertEquals("A String \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
    	"-2.0,-3.0", exampleRange.toString());
    	System.out.println(exampleRange.toString());
    }
    @Test
    public void edgecasePositivePositive() {
    	assertEquals("A String \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
    	"2.0,3.0", exampleRange.toString());
    	System.out.println(exampleRange.toString());
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}