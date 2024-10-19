package Week3.Day2.HW;

public class PivotIndex {
    public static int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // Iterate through the array to find the pivot index
        for (int i = 0; i < nums.length; i++) {
            // Calculate the right sum
            int rightSum = totalSum - leftSum - nums[i];

            // Check if the left sum equals the right sum
            if (leftSum == rightSum) {
                return i; // Return the pivot index
            }

            // Update the left sum for the next iteration
            leftSum += nums[i];
        }

        return -1; // If no pivot index exists
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums1)); // Output: 3

        int[] nums2 = {1, 2, 3};
        System.out.println(pivotIndex(nums2)); // Output: -1

        int[] nums3 = {2, 1, -1};
        System.out.println(pivotIndex(nums3)); // Output: 0

        int[] nums4 = {0, 0}; // Special case for two zeros
        System.out.println(pivotIndex(nums4)); // Output: 0

        int[] nums5 = {2, -2}; // No valid pivot index
        System.out.println(pivotIndex(nums5)); // Output: -1
    }
}

/*
Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index
is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because
there are no elements to the left. This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.

Example 1:
Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11

Example 2:
Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.

Example 3:
Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0

left sum                  right sum
add 0 1    check ==      add last and last -1
if left sum < then right sum then
add 0 1 2 and check with right sum
if right sum < left sum then add last 3 and check with left sum if matches break else continue
if last two sum is 0 and the array size is 2 then pivot index is 0

 */
