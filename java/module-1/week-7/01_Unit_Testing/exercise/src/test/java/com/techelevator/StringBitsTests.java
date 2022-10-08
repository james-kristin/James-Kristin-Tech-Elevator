package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBitsTests {
    private StringBits stringBits;

    @Before
    public void createStringBits() {
        this.stringBits = new StringBits();
    }

    @Test
    public void stringShould_returnNewString_ofEveryOtherCharacter() {
        // Arrange - declare test strings
        String testHello = "hello";
        String testOther = "other";
        // Act - run getBits
        String testHelloBits = stringBits.getBits(testHello);
        String testOtherBits = stringBits.getBits(testOther);

        // Assert - new string should return every other character of the initial string
        Assert.assertEquals("hlo", testHelloBits);
        Assert.assertEquals("ohr", testOtherBits);
    }

    @Test
    public void emptyStringShould_returnEmptyString() {
        // arrange - declare empty and null string
        String testNothing = "";
        String testNull = null;

        // act - run getBits
        String nothingTestBits = stringBits.getBits(testNothing);
        String nullTestBits = stringBits.getBits(testNull);

        // Assert - new string should return nothing
        Assert.assertEquals("", nothingTestBits);
        Assert.assertEquals("", nullTestBits);
    }
}
