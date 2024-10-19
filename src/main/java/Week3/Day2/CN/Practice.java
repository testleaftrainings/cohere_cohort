package Week3.Day2.CN;

import org.junit.Test;

import java.util.Arrays;

public class Practice {
    @Test
    public void test1(){
        String s = "anagram", t = "nagaram";
        boolean result = anagram(s,t);
        System.out.println(result);
    }
    @Test
    public void test2(){
        String s = "rat", t = "car";
        boolean result = anagram(s,t);
        System.out.println(result);
    }
    public boolean anagram(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }
}
