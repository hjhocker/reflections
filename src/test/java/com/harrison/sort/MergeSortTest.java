package com.harrison.sort;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MergeSortTest {

    private Integer[] skills;

    private int n = 5;
    
    private MergeSort mergeSort;
    
    @Before
    public void setup() {
        mergeSort = new MergeSort();
        skills = new Integer[n];
        skills[0] = 3;
        skills[1] = 1;
        skills[2] = 55;
        skills[3] = 23;
        skills[4] = 1669;
        skills[5] = 1664;
    }
    
    @Test
    @Ignore
    public void test() {
        mergeSort.sort(skills);
        for (int i=0;i<skills.length-2;i++) {
            assertTrue(skills[i].intValue() >= skills[i+1].intValue());
        }
    }

}
