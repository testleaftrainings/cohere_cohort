package Week3.Day1.HW;

import org.junit.Test;

public class FirstPalindromeString {

    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i])) {
                return words[i];
            }
        }
        return ""; // Return empty string if no palindromic string is found
    }

    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        // Check if the word is a palindrome using a for loop
        for (; left < right; left++, right--) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testFirstPalindrome1() {
        String[] words = {"abc", "car", "ada", "racecar", "cool"};
        String result = firstPalindrome(words);
        System.out.println("Test 1 Result: " + result);  // Expected: "ada"
    }

    @Test
    public void testFirstPalindrome2() {
        String[] words = {"notapalindrome", "racecar"};
        String result = firstPalindrome(words);
        System.out.println("Test 2 Result: " + result);  // Expected: "racecar"
    }

    @Test
    public void testFirstPalindrome3() {
        String[] words = {"def", "ghi"};
        String result = firstPalindrome(words);
        System.out.println("Test 3 Result: " + result);  // Expected: ""
    }
}

/*
Given an array of strings words, return the first palindromic string in the array.
If there is no such string, return an empty string "".
A string is palindromic if it reads the same forward and backward.

Example 1:
Input: words = ["abc","car","ada","racecar","cool"]
Output: "ada"
Explanation: The first string that is palindromic is "ada".
Note that "racecar" is also palindromic, but it is not the first.

Example 2:
Input: words = ["notapalindrome","racecar"]
Output: "racecar"
Explanation: The first and only string that is palindromic is "racecar".

Example 3:
Input: words = ["def","ghi"]
Output: ""
Explanation: There are no palindromic strings, so the empty string is returned.
 */
