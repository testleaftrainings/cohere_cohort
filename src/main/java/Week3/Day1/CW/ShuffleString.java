package Week3.Day1.CW;

import org.junit.Test;

public class ShuffleString {

    @Test
    public  void test1() {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        String result = restoreString(s, indices);
        System.out.println(result);
    }

    @Test
    public  void test2() {
        String s = "abc";
        int[] indices = {0,1,2};
        String result = restoreString(s, indices);
        System.out.println(result);
    }

    public String restoreString(String s, int[] indices) {
        char[] shuffled = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            shuffled[indices[i]] = s.charAt(i);
        }
        return new String(shuffled);
    }
}