package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxEnd3Tests {
    private MaxEnd3 maxEndTests;

    @Before
    public void createMaxEnd() {
        this.maxEndTests = new MaxEnd3();
    }

    @Test
    public void  returns_larger_number_3_times() {
        // Arrange - declare int arrays length 3
        int[] nums1 = new int[]{1,5,9};
        int[] nums2 = new int[]{7, 4, 6};
        int[] nums3 = new int[]{4, 5, 5};

        // Act - run makeArray
        int[] array1 = maxEndTests.makeArray(nums1);
        int[] array2 = maxEndTests.makeArray(nums2);
        int[] array3 = maxEndTests.makeArray(nums3);

        // Assert - new array should return the larger value 3 times
        Assert.assertArrayEquals(new int[]{9, 9, 9}, array1);
        Assert.assertArrayEquals(new int[]{7, 7, 7}, array2);
        Assert.assertArrayEquals(new int[]{5, 5, 5}, array3);
    }

    @Test
    public void array_should_be_length_3() {
        // Arrange - declare int arrays different from 3
        int[] numsLength1 = new int[]{1};
        int[] numsLength0 = new int[0];
        int[] numsLength4 = new int[]{1, 2, 3, 4};

        // Act - run makeArray
        int[] arrayLength1 = maxEndTests.makeArray(numsLength1);
        int[] arrayLength0 = maxEndTests.makeArray(numsLength0);
        int[] arrayLength4 = maxEndTests.makeArray(numsLength4);

        // Assert - new array should return nothing
        Assert.assertArrayEquals(new int[]{1}, arrayLength1);
        Assert.assertArrayEquals(new int[0], arrayLength0);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, arrayLength4);
    }
}
