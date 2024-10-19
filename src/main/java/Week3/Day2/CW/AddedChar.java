package Week3.Day2.CW;

import org.junit.Test;

public class AddedChar {
    public char findTheDifference(String s, String t) {
        // Loop through each character in string t
        for (char tChar : t.toCharArray()) {
            // Check if the character exists in string s
            if (s.indexOf(tChar) == -1) {
                // If not found in s, return this character
                return tChar; // This is the added character
            }
        }

        return ' '; // Placeholder, should never reach here
    }

    @Test
    public void testFindTheDifference_Example1() {
        String s = "abcd";
        String t = "abcde";
        char result = findTheDifference(s, t);
        System.out.println("Test 1 Result: " + result);
    }

    @Test
    public void testFindTheDifference_Example2() {
        String s = "";
        String t = "y";
        char result = findTheDifference(s, t);
        System.out.println("Test 2 Result: " + result);
    }

    @Test
    public void testFindTheDifference_Additional() {
        String s = "xyz";
        String t = "xyza";
        char result = findTheDifference(s, t);
        System.out.println("Test 3 Result: " + result);
    }
}
