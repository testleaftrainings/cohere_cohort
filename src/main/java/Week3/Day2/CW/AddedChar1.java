package Week3.Day2.CW;

import org.junit.Test;

public class AddedChar1 {

        public char findTheDifference(String s, String t) {

            for (char tChar : t.toCharArray()) {

                if (s.indexOf(tChar) == -1) {

                    return tChar;
                }
            }

            return ' ';
        }

        @Test
        public void test1() {
            String s = "abcd";
            String t = "absscde";
            char result = findTheDifference(s, t);
            System.out.println("Test 1 Result: " + result);
        }

        @Test
        public void test2() {
            String s = "";
            String t = "y";
            char result = findTheDifference(s, t);
            System.out.println("Test 2 Result: " + result);
        }

}
