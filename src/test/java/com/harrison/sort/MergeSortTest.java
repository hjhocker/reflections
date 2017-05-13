package com.harrison.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

    private int[] skills;

    private int n = 3;
    
    private MergeSort mergeSort;
    
    @Before
    public void setup() {
        Random random = new Random();
        mergeSort = new MergeSort();
        skills = new int[n];
        for (int i=0;i<n;i++) {
            skills[i] = random.nextInt(1000);
        }
    }
    
    @Test
    public void test() {
        mergeSort.sort(skills);
        for (int i : skills) {
            System.out.println(i);
        }
        for (int i=0;i<skills.length-2;i++) {
            assertTrue(skills[i] <= skills[i+1]);
        }
    }

}
