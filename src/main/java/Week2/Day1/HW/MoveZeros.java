package Week2.Day1.HW;

import java.util.ArrayList;
import java.util.List;

public class MoveZeros {

    public static List<Integer> moveZeros(int[] nums) {
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            result.add(num);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        List<Integer> result = moveZeros(nums);
        System.out.println(result);
    }
}

/*
public List<Integer> moveZeros(int arr[]){
        List<Integer> result = new ArrayList<>();
        int length = arr.length;
        for (int num : arr){
            if (num != 0){
               result.add(num);
            }
        }
        for (int i = result.size(); i<length; i++){
            if (result.size()!=length){
                result.add(0);
            }
        }

        return result;
    }

 */




/*
Given an integer array nums, move all 0's to the end of it while maintaining
the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
 */