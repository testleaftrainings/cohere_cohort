package Week1.Day2.HW;

import org.junit.Test;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.*;

public class Practice {
    @Test
    public void test1(){
        int[] arr = {1, 1, 3, 3, 5, 5, 7, 7};
        int res = couuntX(arr);
        System.out.println(res);
    }

    public int couuntX(int arr[]) {
     Set<Integer> uniqueValue = new HashSet<>();
     int count = 0;
     for (int i = 0; i < arr.length; i++){
         uniqueValue.add(arr[i]);
     }
     for (int num : arr){
         int x = num + 1;
         if (uniqueValue.contains(x)){
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
