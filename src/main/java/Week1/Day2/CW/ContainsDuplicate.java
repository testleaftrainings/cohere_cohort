package Week1.Day2.CW;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    @Test
    public void test1(){
        int array[] = {1,2,3,1};
        boolean bool = containsDuplicate(array);
        System.out.println(bool);
    }

    @Test
    public void test2(){
        int array[] = {1,2,3};
        boolean bool = containsDuplicate(array);
        System.out.println(bool);
    }

    @Test
    public void test3(){
        int array[] = {};
        boolean bool = containsDuplicate(array);
        System.out.println(bool);
    }

    public boolean containsDuplicate(int array[]){
        Set<Integer> uniqueValue = new HashSet<>();
        for (int num : array) {
            uniqueValue.add(num);
        }
        if(uniqueValue.size() != array.length){
            return true;
        }
        return false;
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