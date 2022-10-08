package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTests {
    private WordCount wordCount;

    @Before
    public void createWordCount() {
        this.wordCount = new WordCount();
    }

    @Test
    public void stringArray_shouldReturn_aMapWithAKeyForEachString_andValueOfTheNumberOfTimesEachStringAppears() {
        // Arrange - declare string arrays - and correct maps
        String[] sheepTest = new String[]{"ba", "ba", "black", "sheep"};
        String[] basicTest = new String[]{"basic"};
        String[] cowTest = new String[]{"The", "cow", "goes", "moo"};
        String[] repeatedTest = new String[]{"a", "a", "a", "a", "b", "b", "c", "c", "c"};

        Map<String, Integer> providedSheepMap = new HashMap<>();
        Map<String, Integer> providedBasicMap = new HashMap<>();
        Map<String, Integer> providedCowMap = new HashMap<>();
        Map<String, Integer> providedRepeatedMap = new HashMap<>();
        providedSheepMap.put("ba", 2);
        providedSheepMap.put("black", 1);
        providedSheepMap.put("sheep", 1);
        providedBasicMap.put("basic", 1);
        providedCowMap.put("The", 1);
        providedCowMap.put("cow", 1);
        providedCowMap.put("goes", 1);
        providedCowMap.put("moo", 1);
        providedRepeatedMap.put("a", 4);
        providedRepeatedMap.put("b", 2);
        providedRepeatedMap.put("c", 3);

        // Act - run getCount
        Map<String, Integer> sheepMap = wordCount.getCount(sheepTest);
        Map<String, Integer> basicMap = wordCount.getCount(basicTest);
        Map<String, Integer> cowMap = wordCount.getCount(cowTest);
        Map<String, Integer> repeatedMap = wordCount.getCount(repeatedTest);

        // Assert - a map of string and their values should be returned from the array of strings
        Assert.assertEquals(providedSheepMap, sheepMap);
        Assert.assertEquals(providedBasicMap, basicMap);
        Assert.assertEquals(providedCowMap, cowMap);
        Assert.assertEquals(providedRepeatedMap, repeatedMap);
    }

    @Test
    public void emptyArrayShould_returnEmptyMap() {
        // Arrange - declare empty arrays and maps
        String[] noStringTest = new String[0];


        Map<String, Integer> answerMap = new HashMap<>();

        // act - run getCount
        Map<String, Integer> noStringMap = wordCount.getCount(noStringTest);


        // Assert - all maps should be empty
        Assert.assertEquals(answerMap, noStringMap);

    }
}
