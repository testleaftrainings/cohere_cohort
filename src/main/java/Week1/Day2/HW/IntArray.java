package Week1.Day2.HW;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class IntArray {

    @Test
    public void test1() {
        int[] input = {1, 2, 3};
        int result = countElements(input);
        System.out.println(result); // Expected: 2
    }

    @Test
    public void test2() {
        int[] input = {1, 1, 3, 3, 5, 5, 7, 7};
        int result = countElements(input);
        System.out.println(result); // Expected: 0
    }

    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int count = 0;

        // Add all elements to the set
        for (int num : arr) {
            set.add(num);
        }

        // Check each element to see if x + 1 exists in the set
        for (int num : arr) {
            if (set.contains(num + 1)) {
                count++;
            }
        }
        return count;
    }
}

/*
Given an integer array arr, count how many elements x there are,
   such that x + 1 is also in arr. If there are duplicates in arr, count them separately.

   example 1: input = [1, 2, 3]
			  output = 2
			explanation: when x is 1, we see x+1 (2) is present in input
						 when x is 2, we see x+1 (3) is present in input
						 when x is 3, we see x+1 (4) is not present in input
						so no of presence of x+1 is 2

   example 2: input = [1, 1, 3, 3, 5, 5, 7, 7]
			  output = 0
			  explanation: no occurence of x+1 for x

   example 3: input = [1, 1, 2]
			  output = 2
			  explanation: when x is 1, we see x+1 (2) is present in input
						   when x is 1, we see x+1 (2) is present in input
						   when x is 2, we see x+1 (3) is not present in input
 */

