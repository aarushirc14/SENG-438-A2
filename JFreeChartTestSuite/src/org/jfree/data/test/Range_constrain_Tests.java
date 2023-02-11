package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

// Author: Luke
// Test cases testing constrain() function in Range class

public class Range_constrain_Tests {
    public Range exampleRange;

    @Before
    public void setUp() throws Exception { 
        exampleRange = new Range(-1, 1);
    }

    @Test
    public void constrainedInRange() {
        assertEquals("Constrained value should be 0", 0, exampleRange.constrain(0), 0.0001d);
    }

    @Test
    public void constrainedUpperBound() {
        assertEquals("Constrained value should be 1", 1, exampleRange.constrain(1), 0.0001d);
    }

    @Test
    public void constrainedLowerBound() {
        assertEquals("Constrained value should be -1", -1, exampleRange.constrain(-1), 0.0001d);
    }

    @Test
    public void constrainedTowardLowerBound() {
        assertEquals("Constrained value should be -1", -1, exampleRange.constrain(-51239.34), 0.0001d);
    }

    @Test
    public void constrainedTowardUpperBound() {
        assertEquals("Constrained value should be 1", 1, exampleRange.constrain(51239.34), 0.0001d);
    }
}