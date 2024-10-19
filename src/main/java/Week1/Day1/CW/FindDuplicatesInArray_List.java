package Week1.Day1.CW;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInArray_List {

    /*public static void main(String[] args) {
        int array[] = {3,5,9,1,2,5,7,5,3,7};
        List<Integer> result = findDuplicates(array);
        System.out.println(result);
    }*/

    @Test
    public void test1() {
        int array[] = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = findDuplicates(array);
        System.out.println("Test 1 Result: " + result);
    }

    @Test
    public void test2() {
        int array[] = {1,1,2};
        List<Integer> result = findDuplicates(array);
        System.out.println("Test 1 Result: " + result);
    }

    @Test
    public void test3() {
        int array[] = {1};
        List<Integer> result = findDuplicates(array);
        System.out.println("Test 1 Result: " + result);
    }

    @Test
    public void testWithNoDuplicates() {
        int array[] = {1, 2, 3, 4, 5};
        List<Integer> result = findDuplicates(array);
        System.out.println("Test with No Duplicates Result: " + result);
    }

    @Test
    public void testWithEmptyArray() {
        int array[] = {};
        List<Integer> result = findDuplicates(array);
        System.out.println("Test with Empty Array Result: " + result);
    }

    public static List<Integer> findDuplicates(int array[]){
        List<Integer> duplicates = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
              if(array[i] == array[j] && !duplicates.contains(array[i])){
                  duplicates.add(array[i]);
              }
            }
        }
        return duplicates;
    }

}

/*
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and
each integer appears once or twice, return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant auxiliary space,
excluding the space needed to store the output

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]

Example 2:
Input: nums = [1,1,2]
Output: [1]

Example 3:
Input: nums = [1]
Output: []

 */