package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTests {

    private AnimalGroupName animals;

    @Before
    public void createAnimalGroup() {
        this.animals = new AnimalGroupName();
    }

    @Test
    public void get_herd_animal_name_returns_animal_herd() {
        // Arrange - @Before


        // Act - get herd for animal name
        String herd = animals.getHerd("crow");

        // Assert - make sure the herd is correct
        Assert.assertEquals("Murder", herd);

    }

    @Test
    public void get_herd_is_case_insensitive() {
        // Arrange - @Before

        // Act - get herd for animal name
        String herd = animals.getHerd("ElEphANt");

        // Assert - make sure the herd is correct
        Assert.assertEquals("Herd", herd);
    }

    @Test
    public void get_herd_unknown_animal_returns_unknown() {
        // Arrange - @Before

        // Act - get herd for animal name
        String herd = animals.getHerd("Zebra");

        // Assert - make sure the herd is unknown
        Assert.assertEquals("unknown", herd);
    }

    @Test
    public void get_herd_empty_returns_unknown() {
        // Arrange - @before

        // Act - get herd for ""
        String herd = animals.getHerd("");

        // Assert - make sure the herd is unknown
        Assert.assertEquals("unknown", herd);
    }

    @Test
    public void get_herd_null_returns_unknown() {
        // Arrange - @Before

        // Act - get herd for null
        String herd = animals.getHerd("null");

        // Assert - make sure herd is unknown
        Assert.assertEquals("unknown", herd);
    }
}
