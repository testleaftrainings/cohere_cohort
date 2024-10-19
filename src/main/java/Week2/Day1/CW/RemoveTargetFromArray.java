package Week2.Day1.CW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveTargetFromArray {

    public static void main(String[] args) {
        int[] input1 = {2, 3, 3, 4, 5};
        int target1 = 3;
        System.out.println("Output: " + Arrays.toString(removeTarget(input1, target1))); // Expected: [2, 4, 5]

        int[] input2 = {2, 2};
        int target2 = 2;
        System.out.println("Output: " + Arrays.toString(removeTarget(input2, target2))); // Expected: []
    }

    public static int[] removeTarget(int[] array, int target) {
        // Convert array to List
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }

        // Remove target elements
        list.removeIf(num -> num == target);

        // Convert List back to array
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();

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