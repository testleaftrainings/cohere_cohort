package Week3.Day2.CW;

import org.junit.Test;

public class CheckA2 {
    public boolean checkString(String s) {
        // If the string contains "ba", return false
        return !s.contains("ba");
    }

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
}
