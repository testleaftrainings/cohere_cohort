package Week3.Day2.CN;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstLastIndex {

    @Test
    public void test1(){
        int array[] = {5,7,7,8,8,10};
        List<Integer> result = firstLastIndex(array,8);
        System.out.println(result);

    }
    @Test
    public void test2(){
        int array[] = {5,7,7,8,8,10};
        List<Integer> result = firstLastIndex(array,6);
        System.out.println(result);

    }
    @Test
    public void test3(){
        int array[] = {};
        List<Integer> result = firstLastIndex(array,0);
        System.out.println(result);

    }
    @Test
    public void test4(){
        int array[] = {5,6,7,7,8,8,10};
        List<Integer> result = firstLastIndex(array,6);
        System.out.println(result);
    }

    public List<Integer> firstLastIndex(int array[], int target){
        List<Integer> fstLstInd = new ArrayList<>();
        int first = -1, last = -1;
        for (int i = 0; i < array.length; i++){
            if (array[i] == target){
                if (first == -1){
                    first=i;
                }
                last = i;
            }
        }
        if (first == -1){
            return Arrays.asList(-1, -1);
        }
        fstLstInd.add(first);
        fstLstInd.add(last);
        return fstLstInd;
    }

}

/*
Find first and last position of element in sorted array Given an array of integers nums sorted
in non-decreasing order,
find the starting and ending position of a given target value. If target is not found in the array,
 return [-1, -1].
Example 1: Input: nums = {5,7,7,8,8,10}, target = 8
Output: {3,4}
Example 2: Input: nums = {5,7,7,8,8,10}, target = 6
Output: [-1,-1]
Example 3: Input: nums = [], target = 0
Output: [-1,-1]
Example4: Input: nums = {5,6,7,7,8,8,10}, target = 6
Output: [1,1]
 */