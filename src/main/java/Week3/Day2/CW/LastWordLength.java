package Week3.Day2.CW;

import org.junit.Test;

public class LastWordLength {
    @Test
    public void testLengthOfLastWord1() {
        String input = "Hello World";
        int result = lengthOfLastWord(input);
        System.out.println("Test 1 Result: " + result);
    }

    @Test
    public void testLengthOfLastWord2() {
        String input = "   fly me   to   the moon  ";
        int result = lengthOfLastWord(input);
        System.out.println("Test 2 Result: " + result);
    }

    @Test
    public void testLengthOfLastWord3() {
        String input = "luffy is still joyboy";
        int result = lengthOfLastWord(input);
        System.out.println("Test 3 Result: " + result);
    }

    public int lengthOfLastWord(String s) {
        // Trim the string to remove leading and trailing spaces
        s = s.trim();

        int length = 0;
        // Start from the end of the string and count the length of the last word
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (length > 0) {
                    break; // We found the end of the last word
                }
            } else {
                length++;
            }
        }
        return length;
    }


}
