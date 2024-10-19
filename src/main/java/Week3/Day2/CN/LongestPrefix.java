package Week3.Day2.CN;

import org.junit.Test;

public class LongestPrefix {
    @Test
    public void test1() {
        String[] strs = {"flower", "flow", "flight"};
        String result = longestCommonPrefix(strs);
        System.out.println("\"" + result + "\""); // Expected output: "fl"
    }

    @Test
    public void test2() {
        String[] strs = {"dog", "racecar", "car"};
        String result = longestCommonPrefix(strs);
        System.out.println("\"" + result + "\""); // Expected output: ""
    }

    @Test
    public void test3() {
        String[] strs = {"", "b", "c"};
        String result = longestCommonPrefix(strs);
        System.out.println("\"" + result + "\""); // Expected output: ""
    }

    @Test
    public void test4() {
        String[] strs = {"interspecies", "interstellar", "interstate"};
        String result = longestCommonPrefix(strs);
        System.out.println("\"" + result + "\""); // Expected output: "inters"
    }

    @Test
    public void test5() {
        String[] strs = {"abc", "ab", "a"};
        String result = longestCommonPrefix(strs);
        System.out.println("\"" + result + "\""); // Expected output: "a"
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // Start with the prefix as the first string
        String prefix = strs[0];
        // Compare the prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // Reduce the prefix by one character until it matches
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
