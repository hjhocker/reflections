package com.harrison.sort;

import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

    private String[] skills;

    private int n = 5;
    
    private BubbleSort bubbleSort;
    
    @Before
    public void setup() {
        bubbleSort = new BubbleSort();
        skills = new String[n];
        skills[0] = "f";
        skills[1] = "d";
        skills[2] = "a";
        skills[3] = "c";
        skills[4] = "z";
    }
    
    @Test
    public void test() {
        bubbleSort.sort(skills);
        for (String skill : skills) {
            System.out.println(skill);
        }
    }

}
