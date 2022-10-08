package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NonStartTests {
    private NonStart nonStartTest;

    @Before
    public void createNonStart() {
        this.nonStartTest = new NonStart();
    }

    @Test
    public void null_returns_nothing() {
        // Arrange - declare 2 null strings
        String a = null;
        String b = null;

        // Act - run getPartialString
        String partial = nonStartTest.getPartialString(a, b);

        // Assert - verify partial returns nothing
        Assert.assertEquals("", partial);
    }

    @Test
    public void partial_string_returns_strings_concatenated_without_first_char() {
        // Arrange - declare strings
        String a = "hello";
        String b = "there";
        String c = "friend";
        String d = "buddy";

        // Act - run getPartialString
        String partial1 = nonStartTest.getPartialString(a, b);
        String partial2 = nonStartTest.getPartialString(a, c);
        String partial3 = nonStartTest.getPartialString(c, d);

        // Assert - partial strings return concatenated string
        Assert.assertEquals("ellohere", partial1);
        Assert.assertEquals("elloriend", partial2);
        Assert.assertEquals("rienduddy", partial3);
    }
}
