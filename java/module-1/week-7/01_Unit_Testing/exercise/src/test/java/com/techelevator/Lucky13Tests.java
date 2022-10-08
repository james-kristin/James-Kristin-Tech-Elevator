package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lucky13Tests {
    private Lucky13 lucky13Test;

    @Before
    public void createLucky13() {
        this.lucky13Test = new Lucky13();
    }

    @Test
    public void array_returns_true_if_there_are_no_1_or_3() {
        // Arrange - declare num arrays with no 1s or 3s
        int[] nums1 = new int[]{0, 2, 4, 6};
        int[] nums2 = new int[]{2, 4, 5};

        // Act - run get lucky
        boolean doesArrayContain3 = lucky13Test.getLucky(nums1);
        boolean doesArrayContain1 = lucky13Test.getLucky(nums2);

        // Assert - both arrays should return true
        Assert.assertEquals(true, doesArrayContain3);
        Assert.assertEquals(true, doesArrayContain1);
    }

    @Test
    public void array_returns_false_if_there_is_1_or_3() {
        // Arrange - decalare num arrays with 1s or 3s
        int[] nums1 = new int[]{0,4,2,3};
        int[] nums2 = new int[]{1, 8, 7, };
        int[] nums3 = new int[]{1, 3, 5, 7, 9};

        // Act - run get lucky
        boolean arrayContains3 = lucky13Test.getLucky(nums1);
        boolean arrayContains1 = lucky13Test.getLucky(nums2);
        boolean arrayContainsBoth = lucky13Test.getLucky(nums3);

        // Assert - all arrays should return false
        Assert.assertEquals(false, arrayContains3);
        Assert.assertEquals(false, arrayContains1);
        Assert.assertEquals(false, arrayContainsBoth);
    }
}
