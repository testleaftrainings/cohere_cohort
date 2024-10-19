package Week1.Day2.HW;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    @Test
    public void test1() {
        int array[] = {3, 2, 3};
        int result = majorityElement(array);
        System.out.println(result);
    }

    @Test
    public void test2() {
        int array[] = {2, 2, 1, 1, 1, 2, 2};
        int result = majorityElement(array);
        System.out.println(result);
    }

    public int majorityElement(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int majorityCount = array.length / 2; // We need more than this count

        // Count occurrences of each number
        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            // Check if this number is the majority element
            if (countMap.get(num) > majorityCount) {
                return num; // Return the majority element as soon as we find it
            }
        }
        return -1;
    }
}

/*
    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times.
    You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

     */
