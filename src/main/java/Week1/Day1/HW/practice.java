package Week1.Day1.HW;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static Week1.Day1.HW.PrimeOrNot.isPrime;

public class practice {

    @Test
    public void test1(){
      int n = 11;
      boolean res = prime(n);
        System.out.println(res);
    }

    public boolean prime(int n){
        if (n<=1){
            return false;
        } else if (n==2) {
            return true;
        } else if (n%2==0||n%3==0) {
            return false;
        }for (int i = 5; i*i <= n; i+=6){
            if (i%2==0||i%3==0){
                return false;
            }
        }
        return true;
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