package Week3.Day2.CW;

import org.junit.jupiter.api.Test;

public class LastWordLengthArray {

    @Test
    public void lastWord1() {
        String input = "Hello World";
        int result = lengthOfLastWord(input);
        System.out.println("Test 1 Result: " + result);
    }

    @Test
    public void lastWord2() {
        String input = "   fly me   to   the moon  ";
        int result = lengthOfLastWord(input);
        System.out.println("Test 2 Result: " + result);
    }

    @Test
    public void lastWord3() {
        String input = "luffy is still joyboy";
        int result = lengthOfLastWord(input);
        System.out.println("Test 3 Result: " + result);
    }

    @Test
    public void lastWord4() {
        String input = "   ";
        int result = lengthOfLastWord(input);
        System.out.println("Test 4 Result: " + result);
    }
    public int lengthOfLastWord(String s) {
        // Split the string by spaces
        String[] words = s.trim().split(" ");

        // Check if there are any words
        if (words.length == 0) {
            return 0; // No words present
        }

        // Return the length of the last word
        return words[words.length - 1].length();
    }
}
