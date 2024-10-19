package Week1.Day2.CW;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Practice {

    @Test
    public void test1(){
        int arr[] = {1,1,1,3,3,4,3,2,4,2};
        boolean res = duplicate(arr);
        System.out.println(res);

    }

    public boolean duplicate(int arr[]){
        Set<Integer> duplicates = new HashSet<>();
        for (int i : arr){
            duplicates.add(i);
        }
        return duplicates.size()!=arr.length;
    }
}

/*
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true
Explanation: The element 1 occurs at the indices 0 and 3.

Example 2:
Input: nums = [1,2,3,4]
Output: false
Explanation:All elements are distinct.

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 */