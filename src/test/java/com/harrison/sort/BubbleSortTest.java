package com.harrison.sort;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

    private Integer[] skills;

    private int n = 5;
    
    private BubbleSort bubbleSort;
    
    @Before
    public void setup() {
        bubbleSort = new BubbleSort();
        skills = new Integer[n];
        skills[0] = 3;
        skills[1] = 1;
        skills[2] = 55;
        skills[3] = 23;
        skills[4] = 1669;
    }
    
    @Test
    public void test() {
        bubbleSort.sort(skills);
        for (Integer skill : skills) {
            System.out.println(skill);
        }
        for (int i=0;i<3;i++) {
            assertThat(skills[i] <= skills[i+1]);
        }
    }
    
    @Test
    public void test_swap() {
        Integer[] input = new Integer[2];
        input[0] = 1;
        input[1] = 2;
        bubbleSort.swapValues(0, 1, input);
        assertThat(input[0].equals(2));
        assertThat(input[1].equals(1));
    }

}
