package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateFashionTests {
    private DateFashion groupFashion;

    @Before
    public void createDateFashion() {
        this.groupFashion = new DateFashion();
    }

    @Test
    public void no_fashion_gets_no_table() {
        // Arrange - @Before

        // Act - set both as having no fashion
        int noFashion = groupFashion.getATable(0, 0);
        int fashionableDate = groupFashion.getATable(0, 10);
        int unfashionableDate = groupFashion.getATable(10, 0);

        // Assert - all pairs should get no table
        Assert.assertEquals(0, noFashion);
        Assert.assertEquals(0, fashionableDate);
        Assert.assertEquals(0, unfashionableDate);
    }

    @Test
    public void fashion_gets_table() {
        // Arrange - @Before

        // Act - set one or both as being very fashionable
        int allFashion = groupFashion.getATable(10, 10);
        int someFashion = groupFashion.getATable(10, 5);
        int dateOutOfLeague = groupFashion.getATable(3, 9);

        // Assert - all pairs should get a table
        Assert.assertEquals(2, allFashion);
        Assert.assertEquals(2, someFashion);
        Assert.assertEquals(2, dateOutOfLeague);
    }

    @Test
    public void average_fashion_might_get_a_table() {
        // Arrange - @Before

        // Act - set both values between 2 & 8
        int averageFashion = groupFashion.getATable(5, 5);
        int lowFashion = groupFashion.getATable(4, 4);
        int almostFashionable = groupFashion.getATable(6, 7);

        // Assert - all paris may get a table
        Assert.assertEquals(1, averageFashion);
        Assert.assertEquals(1, lowFashion);
        Assert.assertEquals(1, almostFashionable);
    }

    @Test
    public void fashion_edge_cases() {
        //Arrange - @Before

        // Act - set all groups to edge cases
        int almostAverage = groupFashion.getATable(2, 1);
        int barelyAverage = groupFashion.getATable(3, 3);
        int borderAverage = groupFashion.getATable(2, 3);
        int barelyFashionable = groupFashion.getATable(8, 7);
        int extremeDifference = groupFashion.getATable(2, 8);
        int almostFashionable = groupFashion.getATable(7, 7);
        int fashionableDate = groupFashion.getATable(3, 8);
        int averageFashion = groupFashion.getATable(3, 7);

        // Assert - only fashionable people are guaranteed tables
        Assert.assertEquals(0, almostAverage);
        Assert.assertEquals(1, barelyAverage);
        Assert.assertEquals(0, borderAverage);
        Assert.assertEquals(2, barelyFashionable);
        Assert.assertEquals(0, extremeDifference);
        Assert.assertEquals(1, almostFashionable);
        Assert.assertEquals(2, fashionableDate);
        Assert.assertEquals(1, averageFashion);
    }
}
