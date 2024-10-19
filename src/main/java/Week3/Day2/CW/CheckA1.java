package Week3.Day2.CW;

import org.junit.Test;

public class CheckA1 {

    @Test
    public void testCheckString1() {
        String input = "aaabbb";
        boolean result = checkString(input);
        System.out.println("Test 1 Result: " + result);  // Expected: true
    }

    @Test
    public void testCheckString2() {
        String input = "abab";
        boolean result = checkString(input);
        System.out.println("Test 2 Result: " + result);  // Expected: false
    }

    @Test
    public void testCheckString3() {
        String input = "bbb";
        boolean result = checkString(input);
        System.out.println("Test 3 Result: " + result);  // Expected: true
    }

    @Test
    public void testCheckString4() {
        String input = "aabbb";
        boolean result = checkString(input);
        System.out.println("Test 4 Result: " + result);  // Expected: true
    }

    @Test
    public void testCheckString5() {
        String input = "aaa";
        boolean result = checkString(input);
        System.out.println("Test 5 Result: " + result);  // Expected: true
    }
    public boolean checkString(String s) {
        int firstBIndex = s.indexOf('b'); // Find the index of the first 'b'

        // If there is no 'b', all 'a's are before any 'b'
        if (firstBIndex == -1) {
            return true;
        }

        // Check if there is any 'a' after the first 'b'
        for (int i = firstBIndex + 1; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                return false; // Found an 'a' after the first 'b'
            }
        }

        return true; // All 'a's are before 'b's
    }
}
