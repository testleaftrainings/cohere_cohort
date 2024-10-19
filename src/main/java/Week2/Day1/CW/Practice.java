package Week2.Day1.CW;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {

    @Test
    public void test1(){
           int[] arr = {2, 2};
           int target = 3;
           List<Integer> res = removeTarget(arr, target);
        System.out.println(res);

    }

    public List<Integer> removeTarget(int[] arr, int target){
        List<Integer> result = new ArrayList<>();
        for (int num = 0; num < arr.length; num++){
            if (arr[num]!=target){
                result.add(arr[num]);
            }
        }
        return result;
    }


}

   /*Remove the target element in the array

example 1: input = [2, 3, 3, 4, 5], target=3
		  output = [2, 4, 5]
		  explanation: when 3 is removed from input array,
						output is [2, 4, 5]

example 2: input = [2, 2], target=2
		  output = []
		  explanation: when 2 is removed, output would be empty array?

     */