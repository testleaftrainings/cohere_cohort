package Week2.Day2.CW;

public class TwoSum {
        public static void main(String[] args) {
            // Example input
            int[] nums = {2, 7, 11, 15};
            int target = 9;

            // Find the indices
            int[] result = twoSum(nums, target);

            // Output the result
            if (result != null) {
                System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
            } else {
                System.out.println("No solution found.");
            }
        }

        public static int[] twoSum(int[] nums, int target) {
            // Iterate through each element in the array
            for (int i = 0; i < nums.length; i++) {
                // Check the rest of the array for a pair that sums to target
                for (int j = i + 1; j < nums.length; j++) {
                    // If the pair sums to target, return the indices
                    if (nums[i] + nums[j] == target) {
                        return new int[] { i, j };
                    }
                }
            }

            // If no solution is found
            return null;
        }
    }

/*
Given an array of integers nums and an integer target, return indices of the two numbers
such that they add up to target.
You may assume that each input would have exactly one solution,
and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 */