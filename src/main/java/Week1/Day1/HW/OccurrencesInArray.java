package Week1.Day1.HW;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OccurrencesInArray {

    @Test
    public  void test1(){
        int array[] = {3, 5, 2, 1, 3, 7, 5, 2, 1, 6};
       boolean count = countOccurrences(array);
        System.out.println("Occurrences: " + count);
    }

    @Test
    public  void test2(){
        int array[] = {1,2};
        boolean count = countOccurrences(array);
        System.out.println("Occurrences: " + count);
    }

    @Test
    public  void test3(){
        int array[] = {-3,0,1,-3,1,1,1,-3,10,0};
        boolean count = countOccurrences(array);
        System.out.println("Occurrences: " + count);
    }

    public boolean countOccurrences(int array[]) {
        Map<Integer, Integer> occurrences = occurrences(array);
        Set<Integer> counts = new HashSet<>();
        for (int count : occurrences.values()) {
            if (!counts.add(count)) {
                return false;
            }
        }
        return true;
    }

    public static Map<Integer, Integer> occurrences(int array[]){
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : array){
            if (occurrences.containsKey(num)){
                occurrences.put(num, occurrences.get(num)+1);
            }else {
                occurrences.put(num, 1);
            }
        }
        return occurrences;
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