package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Less20Tests {
    private Less20 lessTests;

    @Before
    public void createLess20() {
        this.lessTests = new Less20();
    }

    @Test
    public void numbers_not_1_or_2_less_than_a_multiple_of_20_return_false() {
        //Arrange - @Before

        // act - declare numbers that are not 1 or 2 less than a multiple of 20
        boolean number17 = lessTests.isLessThanMultipleOf20(17);
        boolean number32 = lessTests.isLessThanMultipleOf20(32);
        boolean number40 = lessTests.isLessThanMultipleOf20(40);
        boolean number62 = lessTests.isLessThanMultipleOf20(62);

        // Assert - all should return false
        Assert.assertEquals(false, number17);
        Assert.assertEquals(false, number32);
        Assert.assertEquals(false, number40);
        Assert.assertEquals(false, number62);
    }

    @Test
    public void negatives_return_false() {
        // Arrange - @Before

        // Act - declare negative numbers
        boolean negative20 = lessTests.isLessThanMultipleOf20(-20);
        boolean negative19 = lessTests.isLessThanMultipleOf20(-19);

        // Assert - all should return false
        Assert.assertEquals(false, negative19);
        Assert.assertEquals(false, negative20);
    }

    @Test
    public void numbers_1_or_2_less_than_a_multiple_of_20_return_true() {
        // Arrange - @Before

        // Act - declare numbers 1 or 2 less than a multiple of 20
        boolean number19 = lessTests.isLessThanMultipleOf20(19);
        boolean number18 = lessTests.isLessThanMultipleOf20(18);
        boolean number39 = lessTests.isLessThanMultipleOf20(39);
        boolean number58 = lessTests.isLessThanMultipleOf20(58);

        // Assert - all should return true
        Assert.assertEquals(true, number18);
        Assert.assertEquals(true, number19);
        Assert.assertEquals(true, number39);
        Assert.assertEquals(true, number58);
    }
}
