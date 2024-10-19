package Week1.Day1.HW;

import org.junit.Test;

import java.util.*;

public class UniqueOccurences {

    @Test
    public void test1() {
        int array[] = {1,2,2,1,1,3};
        boolean result = uniqueOccurence(array);
        System.out.println(result);
    }

    @Test
    public void test2() {
        int array[] = {1,2};
        boolean result = uniqueOccurence(array);
        System.out.println(result);
    }

    @Test
    public void test3() {
        int array[] = {-3,0,1,-3,1,1,1,-3,10,0};
        boolean result = uniqueOccurence(array);
        System.out.println(result);
    }

    public boolean uniqueOccurence(int array[]){
        Map<Integer, Integer> uniqueOccurences = new HashMap<>();

        for(int num : array){
            uniqueOccurences.put(num, uniqueOccurences.getOrDefault(num, 0) + 1);
        }

        Set<Integer> valueSet = new HashSet<>(uniqueOccurences.values());
        return valueSet.size() == uniqueOccurences.size();

  }

}

/*
Given an array of integers arr, return true if the number of occurrences of
each value in the array is unique or false otherwise.

Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1.
No two values have the same number of occurrences.

Example 2:
Input: arr = [1,2]
Output: false

Example 3:
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 */
