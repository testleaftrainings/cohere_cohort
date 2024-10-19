package Week3.Day2.HW;

import org.junit.Test;

public class ReplaceAllDigitsWithChar {
    /*
      public static void main(String[] args) {
        ReplaceAllDigitsWithChar sc = new ReplaceAllDigitsWithChar();
        // Test cases
        System.out.println(sc.replaceDigits("a1c1e1")); // Output: "abcdef"
        System.out.println(sc.replaceDigits("a1b2c3d4e")); // Output: "abbdcfdhe"
    }
     */
    public String replaceDigits(String s) {
        char[] result = new char[s.length()]; // Array to hold the result
        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) { // Even index: copy character directly
                result[i] = s.charAt(i);
            } else { // Odd index: perform shift operation and replace
                char charBefore = s.charAt(i - 1); // Character before digit
                char digitChar = s.charAt(i); // Digit at odd index
                int shiftValue = Character.getNumericValue(digitChar); // Convert char digit to int
                // Replace with the shifted character
                result[i] = (char) (charBefore + shiftValue);
            }
        }
        return new String(result); // Convert char array back to String
    }

    @Test
    public void test1() {
        String s = "a1c1e1";
        String res = replaceDigits(s);
        System.out.println(res); // Expected Output: "abcdef"
    }

    @Test
    public void test2() {
        String s = "a1b2c3d4e";
        String res = replaceDigits(s);
        System.out.println(res); // Expected Output: "abbdcfdhe"
    }

}

/*
You are given a 0-indexed string s that has lowercase English letters in its even indices
and digits in its odd indices.
You must perform an operation shift(c, x), where c is a character and x is a digit,
that returns the xth character after c.
For example, shift('a', 5) = 'f' and shift('x', 0) = 'x'.
For every odd index i, you want to replace the digit s[i] with the result of the shift(s[i-1],
s[i]) operation.
Return s after replacing all digits. It is guaranteed that shift(s[i-1], s[i]) will never exceed 'z'.
Note that shift(c, x) is not a preloaded function, but an operation to be implemented as part of the
solution.

Example 1:
Input: s = "a1c1e1"
Output: "abcdef"
Explanation: The digits are replaced as follows:
- s[1] -> shift('a',1) = 'b'
- s[3] -> shift('c',1) = 'd'
- s[5] -> shift('e',1) = 'f'

Example 2:
Input: s = "a1b2c3d4e"
Output: "abbdcfdhe"
Explanation: The digits are replaced as follows:
- s[1] -> shift('a',1) = 'b'
- s[3] -> shift('b',2) = 'd'
- s[5] -> shift('c',3) = 'f'
- s[7] -> shift('d',4) = 'h'
 */
