package Week3.Day2.CW;

import org.junit.Test;

public class CheckA {
    @Test
    public void testCheckString1() {
        String input = "aaabbb";
        boolean result = checkString(input);
        System.out.println("Test 1 Result: " + result);
    }

    @Test
    public void testCheckString2() {
        String input = "abab";
        boolean result = checkString(input);
        System.out.println("Test 2 Result: " + result);
    }

    @Test
    public void testCheckString3() {
        String input = "bbb";
        boolean result = checkString(input);
        System.out.println("Test 3 Result: " + result);
    }

    @Test
    public void testCheckString4() {
        String input = "aabbb";
        boolean result = checkString(input);
        System.out.println("Test 4 Result: " + result);
    }

    @Test
    public void testCheckString5() {
        String input = "aaa";
        boolean result = checkString(input);
        System.out.println("Test 5 Result: " + result);
    }

    public boolean checkString(String s) {
        boolean seenB = false; // Flag to track if we've seen 'b'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'b') {
                seenB = true; // Mark that we've seen 'b'
            } else if (c == 'a' && seenB) {
                // If we see 'a' after 'b', return false
                return false;
            }
        }

        return true; // All 'a's are before 'b's
    }
}
