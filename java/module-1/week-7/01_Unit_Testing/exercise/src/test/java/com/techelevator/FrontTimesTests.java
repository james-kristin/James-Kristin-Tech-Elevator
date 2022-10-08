package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTests {
    private FrontTimes frontTest;

    @Before
    public void createFrontTimes() {
        this.frontTest = new FrontTimes();
    }

    @Test
    public void string_returns_string_n_times_if_less_than_3() {
        // Arrange - @Before

        // Act - declare strings less than length 3
        String length2 = frontTest.generateString("is", 2);
        String length1 = frontTest.generateString("a", 4);
        String length0 = frontTest.generateString("", 3);
        String lengthNull = frontTest.generateString(null, 5);

        // Assert - strings repeat front n times
        Assert.assertEquals("isis", length2);
        Assert.assertEquals("aaaa", length1);
        Assert.assertEquals("", length0);
        Assert.assertEquals("", lengthNull);
    }

    @Test
    public void string_does_not_accept_negative_n() {
        // Arrange - @Before

        // Act - declare negative n
        String negativeNStr4 = frontTest.generateString("abcd", -4);
        String negativeNStr2 = frontTest.generateString("is", -2);
        String zeroN = frontTest.generateString("The", 0);

        // Assert - all should return ""
        Assert.assertEquals("", negativeNStr4);
        Assert.assertEquals("", negativeNStr2);
        Assert.assertEquals("", zeroN);
    }

    @Test
    public void string_repeats_first_3_chars_n_times() {
        // Arrange - @Before

        // Act - declare string 3 or more
        String length3 = frontTest.generateString("abc", 3);
        String length4 = frontTest.generateString("well", 2);
        String length6 = frontTest.generateString("kansas", 5);

        // Assert - all should repeat first 3 chars n times
        Assert.assertEquals("abcabcabc", length3);
        Assert.assertEquals("welwel", length4);
        Assert.assertEquals("kankankankankan", length6);
    }
}
