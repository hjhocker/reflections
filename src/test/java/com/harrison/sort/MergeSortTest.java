package com.harrison.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

    private int[] skills;

    private int n = 6;
    
    private MergeSort mergeSort;
    
    @Before
    public void setup() {
        mergeSort = new MergeSort();
        skills = new int[n];
        skills[0] = 3;
        skills[1] = 1;
        skills[2] = 55;
        skills[3] = 23;
        skills[4] = 1669;
        skills[5] = 1664;
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
