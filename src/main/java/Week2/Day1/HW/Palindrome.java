package Week2.Day1.HW;

import org.junit.Test;

public class Palindrome {

    @Test
    public void test1(){
        int x = 121;
        boolean result = isPalindrome(x);
        System.out.println(result);
    }
    @Test
    public void test2(){
        int x = -121;
        boolean result = isPalindrome(x);
        System.out.println(result);
    }
    @Test
    public void test3(){
        int x = 10;
        boolean result = isPalindrome(x);
        System.out.println(result);
    }

    public static boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) return false;

        // Numbers ending in 0 (but not 0 itself) cannot be palindromes
        if (x % 10 == 0 && x != 0) return false;

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        // When the length of the number is odd, we can get rid of the middle digit by reversed / 10
        return x == reversed || x == reversed / 10;
    }
}

/*
Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */