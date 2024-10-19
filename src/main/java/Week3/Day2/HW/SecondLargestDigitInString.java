package Week3.Day2.HW;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SecondLargestDigitInString {

    @Test
    public void test1() {
        String input = "dfa12321afd";
        int result = secondLargestDigit(input);
        System.out.println(result); // Output: 2
    }

    @Test
    public void test2() {
        String input = "abc1111";
        int result = secondLargestDigit(input);
        System.out.println(result); // Output: -1
    }

    @Test
    public void test3() {
        String input = "xyz987654321";
        int result = secondLargestDigit(input);
        System.out.println(result); // Output: 8
    }

    @Test
    public void test4() {
        String input = "a1b2c3d4";
        int result = secondLargestDigit(input);
        System.out.println(result); // Output: 3
    }

    @Test
    public void test5() {
        String input = "a0b";
        int result = secondLargestDigit(input);
        System.out.println(result); // Output: -1
    }

    public int secondLargestDigit(String s) {
        Set<Integer> digitsSet = new HashSet<>();

        // Collect unique digits in the set
        for (char c : s.toCharArray()) { //s.toCharArray converts String to Char[]
            if (Character.isDigit(c)) {  // isDigit checks c value is digit or not and return true or false
                // Character.getNumericValue(c) converts a character (representing a digit) into its corresponding integer value.
                digitsSet.add(Character.getNumericValue(c));
            }
        }

        // If the set contains less than 2 unique digits, return -1
        if (digitsSet.size() < 2) {
            return -1;
        }

        // Convert the set to an array and sort it
        Integer[] digitsArray = digitsSet.toArray(new Integer[0]); //to convert a collection to an array and The size will be determined dynamically
        Arrays.sort(digitsArray);

        // Return the second largest digit
        return digitsArray[digitsArray.length - 2];
    }

}
/*
Given an alphanumeric string s, return the second largest numerical digit that appears in s,
or -1 if it does not exist.
An alphanumeric string is a string consisting of lowercase English letters and digits.

Example 1:
Input: s = "dfa12321afd"
Output: 2
Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.

Example 2:
Input: s = "abc1111"
Output: -1
Explanation: The digits that appear in s are [1]. There is no second largest digit.
 */
