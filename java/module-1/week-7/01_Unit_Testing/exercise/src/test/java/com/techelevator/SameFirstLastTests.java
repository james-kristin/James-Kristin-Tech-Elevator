package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SameFirstLastTests {
    private SameFirstLast sameFirstLast;

    @Before
    public void createSameFirstLast() {
        this.sameFirstLast = new SameFirstLast();
    }

    @Test
    public void sameFirstLast_shouldReturnFalse_ifLengthLessThanOne() {
        // Arrange - set array length 0
        int[] nums = new int[0];
        // Act - run isItTheSame
        boolean falseTest = sameFirstLast.isItTheSame(nums);

        // Assert - isItTheSame should return false
        Assert.assertEquals(false, falseTest);
    }

    @Test
    public void ifTheFirstAndLastElementsAreEqual_sameFirstLastShould_returnTrue() {
        // Arrange - set int arrays
        int[] numsOneValue = new int[]{1};
        int[] numsTwoValues = new int[]{2, 2};
        int[] numsThreeValues = new int[]{3, 4, 3};
        int[] numsFourValues = new int[]{4, 5, 6, 4};

        // Act - run isItTheSame
        boolean firstTestValue = sameFirstLast.isItTheSame(numsOneValue);
        boolean secondTestValue = sameFirstLast.isItTheSame(numsTwoValues);
        boolean thirdTestValue = sameFirstLast.isItTheSame(numsThreeValues);
        boolean fourthTestValue = sameFirstLast.isItTheSame(numsFourValues);

        // Assert - all arrays should return true
        Assert.assertEquals(true, firstTestValue);
        Assert.assertEquals(true, secondTestValue);
        Assert.assertEquals(true, thirdTestValue);
        Assert.assertEquals(true, fourthTestValue);
    }

    @Test
    public void ifTheFirstAndLastElementsAreNotEqual_sameFirstLastShould_returnFalse() {
        // Arrange - set int arrays
        int[] arrayNums = new int[]{1, 2, 3};
        int[] testArray = new int[]{1, 2, 3, 4, 5};

        // Act - run isItTheSame
        boolean firstTestValue = sameFirstLast.isItTheSame(arrayNums);
        boolean secondTestValue = sameFirstLast.isItTheSame(testArray);

        // Assert - both arrays should return false
        Assert.assertEquals(false, firstTestValue);
        Assert.assertEquals(false, secondTestValue);
    }
}
