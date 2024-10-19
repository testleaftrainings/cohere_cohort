package Week3.Day2.HW;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Check if all elements are 9
        boolean allNines = true;
        for (int digit : digits) {
            if (digit != 9) {
                allNines = false;
                break; // If we find a digit that's not 9, we can break early
            }
        }

        // If all digits are 9, create a new array
        if (allNines) {
            int[] result = new int[n + 1];
            result[0] = 1; // Set the first element to 1
            return result; // The rest will be 0s by default
        }

        // Check the last digit
        if (digits[n - 1] < 9) {
            // If the last digit is less than 9, simply increment it
            digits[n - 1]++;
            return digits;
        } else {
            // If the last digit is 9, set it to 0
            digits[n - 1] = 0;

            // Now we need to check the previous digits
            for (int i = n - 2; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    break; // Increment this digit and break the loop
                }
                // If it was 9, set it to 0 and continue to the next digit
                digits[i] = 0;
            }
        }

        return digits; // Return the modified digits array
    }

    public static void main(String[] args) {
        // Test cases
        int[] digits1 = {1, 2, 3};
        System.out.println(Arrays.toString(plusOne(digits1))); // Output: [1, 2, 4]

        int[] digits2 = {4, 3, 2, 1};
        System.out.println(Arrays.toString(plusOne(digits2))); // Output: [4, 3, 2, 2]

        int[] digits3 = {9};
        System.out.println(Arrays.toString(plusOne(digits3))); // Output: [1, 0]

        int[] digits4 = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits4))); // Output: [1, 0, 0, 0]
    }
}
/*
You are given a large integer represented as an integer array digits, where each digits[i] is the
ith digit of the integer. The digits are ordered from most significant to least significant
in left-to-right order. The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:
Input: digits = [4,3,2,1]   129 == 130 999 = 1000
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 */
