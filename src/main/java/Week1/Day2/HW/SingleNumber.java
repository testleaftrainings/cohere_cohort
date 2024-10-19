package Week1.Day2.HW;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class SingleNumber {

    @Test
    public void test1(){
        int array[] = {2,2,1};
        int result = singleNum(array);
        System.out.println(result);
    }

    @Test
    public void test2(){
        int array[] = {4,1,2,1,2};
        int result = singleNum(array);
        System.out.println(result);
    }

    @Test
    public void test3(){
        int array[] = {1};
        int result = singleNum(array);
        System.out.println(result);
    }

    public int singleNum(int arr[]){
        Map<Integer, Integer> singleNum = new HashMap<>();

        for (int num : arr){
            singleNum.put(num, singleNum.getOrDefault(num, 0)+1);
        }
        for (Map.Entry<Integer,Integer> entry : singleNum.entrySet()){
            if (entry.getValue()==1){
                return entry.getKey();
            }
        }
        return 0;
    }

}
/*
    Given a non-empty array of integers nums, every element appears twice except for one.
    Find that single one. You must implement a solution with a linear runtime complexity and
    use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1
     */