package Week3.Day2.CN;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfAnagrams {
    @Test
    public void test1() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        System.out.println(result); // Output: [0, 6]
    }

    @Test
    public void test2() {
        String s = "abab";
        String p = "ab";
        List<Integer> result = findAnagrams(s, p);
        System.out.println(result); // Output: [0, 1, 2]
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>(); // To store starting indices
        int pLength = p.length();

        // Loop through s to get all substrings of length pLength
        for (int i = 0; i <= s.length() - pLength; i++) {
            String substring = s.substring(i, i + pLength); // Get substring
            if (isAnagram(substring, p)) { // Check if it's an anagram
                result.add(i); // Add starting index to result
            }
        }

        return result; // Return all starting indices of anagrams
    }

    // Helper method to check if two strings are anagrams
    private boolean isAnagram(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1); // Sort the first string
        Arrays.sort(arr2); // Sort the second string
        return Arrays.equals(arr1, arr2); // Compare sorted arrays
    }
}
