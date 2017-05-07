package com.harrison.sort;

public class BubbleSort {
  
    public void swapValues(int a, int b, Integer[] arr) {
        Integer temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public Integer[] sort(Integer[] skills) {
        Integer[] sorted = new Integer[skills.length];
        for (int i=1;i<skills.length;i++) {
            for (int j=0;j<skills.length;j++) {
                if (skills[i] > skills[j]) {
                    swapValues(i, j, skills);
                }
            }
        }
        return sorted;
    }

}