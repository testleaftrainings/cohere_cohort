package Week2.Day2.HW;

public class PowerOfThree {
    public static boolean isPowerOfThree(int n) {
        // If n is less than or equal to 0, it can't be a power of three
        if (n <= 0) {
            return false;
        }

        // Calculate the maximum power of 3 that fits within the integer limit
        int maxPowerOfThree = 1162261467; // 3^19

        // Check if n is a divisor of the maximum power of 3
        return maxPowerOfThree % n == 0;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isPowerOfThree(27));  // Output: true
        System.out.println(isPowerOfThree(0));   // Output: false
        System.out.println(isPowerOfThree(-1));  // Output: false
        System.out.println(isPowerOfThree(9));   // Output: true
        System.out.println(isPowerOfThree(10));  // Output: false
    }
}

/*
Given an integer n, return true if it is a power of three. Otherwise, return false.
An integer n is a power of three, if there exists an integer x such that n == 3x.

Example 1:
Input: n = 27
Output: true
Explanation: 27 = 33

Example 2:
Input: n = 0
Output: false
Explanation: There is no x where 3x = 0.

Example 3:
Input: n = -1
Output: false
Explanation: There is no x where 3x = (-1).

Follow up: Could you solve it without loops/recursion?
 */

