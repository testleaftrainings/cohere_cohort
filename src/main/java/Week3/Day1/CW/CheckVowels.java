package Week3.Day1.CW;

import org.junit.Test;

public class CheckVowels {


        @Test
        public void testOne()
        {
            String inputString="book";
            boolean isHalvesAreAlike=isHalvesAreAlike(inputString);
            System.out.println(isHalvesAreAlike);
        }

        @Test
        public void testTwo()
        {
            String inputString="Textbook";
            boolean isHalvesAreAlike=isHalvesAreAlike(inputString);
            System.out.println(isHalvesAreAlike);
        }

//        private boolean isHalvesAreAlike(String inputString) {
//            int mid=inputString.length()/2;
//            String newStr1=inputString.substring(0,mid).toLowerCase();
//            String newStr2=inputString.substring(mid).toLowerCase();
//            int newStr1Counter=0;
//            int newStr2Counter=0;
//            for(int i=0;i<newStr1.length();i++)
//            {
//                if(newStr1.charAt(i)=='a'||newStr1.charAt(i)=='e'||newStr1.charAt(i)=='o'
//                        ||newStr1.charAt(i)=='u'||newStr1.charAt(i)=='i')
//                {
//                    newStr1Counter++;
//                }
//            }
//            for(int i=0;i<newStr2.length();i++)
//            {
//                if(newStr2.charAt(i)=='a'||newStr2.charAt(i)=='e'||newStr2.charAt(i)=='o'
//                        ||newStr2.charAt(i)=='u'||newStr2.charAt(i)=='i')
//                {
//                    newStr2Counter++;
//                }
//            }
//
//            if(newStr2Counter==newStr1Counter)
//            {
//                return  true;
//            }
//            else {
//                return  false;
//            }
//        }

    private boolean isHalvesAreAlike(String inputString) {
        int midStringVal = inputString.length() / 2;
        String newStr1 = inputString.substring(0, midStringVal).toLowerCase();
        String newStr2 = inputString.substring(midStringVal).toLowerCase();

        // Count vowels in both halves
        return countVowels(newStr1) == countVowels(newStr2);
    }

    private int countVowels(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
}

 /*
         * 1) Did I understand the problem? -> If yes, go to next step !!
         *
         * What is the input(s) type?
         * String (upper and lowers case)
         * What is the expected output?
         * boolean
         * Do I have constraints to solve the problem?
         * s.length is even.
         * s consists of uppercase and lowercase letters.
         * Do I have all informations to go to next step!!
         * How big is your test data set will be?
         *
         * 2) Test data set
         *
         * Minimum of 3 data set !!
         * Positive,
         * book
         * Edge,
         *  empty
         * Negative
         * textbook
         * Validate with the interviewer if the data set is fine by his/her assumptions
         *
         * 3) Do I know how to solve it?
         *
         * Yes - great, is there an alternate?
         *
         * 4) Ask for hint (If you do not know how to solve)
         *
         * 5) Do I know alternate solutions as well?
         *
         * No - That is still fine, proceed to solve by what you know !!
         *
         * 6) If you know alternate solutions -> find out the O Notations
         * (Performance)
         *
         * Then, explain either both or the best (depends on the time)
         *
         * Approach 1: Start with worst -> Improve (Optimize) -> End up with the best
         * Approach 2: Write down the options and benefits and code the best
         *
         * 7) Start always with Psuedo code // Bruteforce
         *
         * 8) Implement them in the code (editor)
         *
         * 9) Test against the different data set
         *
         * 10) If it fails, debug t

    * Psudo Code
        1. Find the length of string
        * find the mid string value
        * create new two new string
        * user the sub string, mid value. split the input string and assign
        * the new string values.

         ns1=s.substring(0,mid) == bo
         ns2=s.substring(mid)
         count=0
        ns1
        for(int i=0;i<ns1.lenth;i++)
         {
        if(ns1.contains("a")|ns1.contains("e")&&ns1.contains("A")|
        {
           count++;
        * }
        *
         ns1
        for(int i=0;i<ns1.lenth;i++)
         {
        if(ns1.contains("a")|ns1.contains("e")&&ns1.contains("A")|
        {
           count++;
        * }
        *
        * if(str1count==cunt2)
        * {
        * true
        * }else
        * {
        * fasle)
        *

    */