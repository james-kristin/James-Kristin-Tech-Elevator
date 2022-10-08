package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTests {
    private CigarParty squirrelParty;

    @Before
    public void createCigarParty() {
        this.squirrelParty = new CigarParty();
    }

    @Test
    public void cigar_party_happy_tests() {
        // Arrange - @Before

        // Act - get party information
        Boolean hasParty = squirrelParty.haveParty(50, false);
        Boolean noParty = squirrelParty.haveParty(30, false );

        // Assert - have party returns correctly
        Assert.assertEquals(true, hasParty);
        Assert.assertEquals(false, noParty);
    }
    @Test
    public void cigar_party_edge_tests() {
        // Arrange - @Before

        // Act - get party info at edges
        boolean cigars40 = squirrelParty.haveParty(40, false);
        boolean cigars39 = squirrelParty.haveParty(39, false);
        boolean cigars60 = squirrelParty.haveParty(60, false);
        boolean cigars61 = squirrelParty.haveParty(61, false);

        // Assert - have party returns correctly
        Assert.assertEquals(true, cigars40);
        Assert.assertEquals(false, cigars39);
        Assert.assertEquals(true, cigars60);
        Assert.assertEquals(false, cigars61);
    }

    @Test
    public void cigar_party_weekend_tests() {
        // Arrange - @Before

        // Act - get party information
        boolean over60Weekend = squirrelParty.haveParty(80, true);
        boolean over60NotWeekend = squirrelParty.haveParty(90, false);
        boolean under40Weekend = squirrelParty.haveParty(30, true);
        boolean under40NotWeekend = squirrelParty.haveParty(30, false);
        boolean happyWeekend = squirrelParty.haveParty(50, true);

        // Assert - have party returns correctly
        Assert.assertEquals(true, over60Weekend);
        Assert.assertEquals(false, over60NotWeekend);
        Assert.assertEquals(false, under40Weekend);
        Assert.assertEquals(false, under40NotWeekend);
        Assert.assertEquals(true, happyWeekend);
    }
}