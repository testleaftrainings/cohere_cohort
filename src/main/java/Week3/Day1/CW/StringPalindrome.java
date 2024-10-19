package Week3.Day1.CW;

import org.junit.Test;

public class StringPalindrome {
        // 1. convert to lower case
        //2. remove all the non albha-numeric char replaceAll("[^A-Za-z0-9]","");
        //3  iterate the old string in reverse order and store in the new string
        //4 now compare the old string and new string return  true /false

        @Test
        public void testOne()
        {
            String str="A man, a plan, a canal: Panama";
            boolean palindrome = isPalindrome(str);
            System.out.println("Is Palidrome-->"+palindrome);
        }

        @Test
        public void testTwo()
        {
            String str="race a car";
            boolean palindrome = isPalindrome(str);
            System.out.println("Is Palidrome-->"+palindrome);
        }
        @Test
        public void testThree()
        {
            String str="";
            boolean palindrome = isPalindrome(str);
            System.out.println("Is Palidrome-->"+palindrome);
        }

        private boolean isPalindrome(String str) {
            String convertedStr= str.toLowerCase().replaceAll("[^A-Za-z0-9]","");
            char[] charArray = convertedStr.toCharArray();
            String newStr = "";
            for(int i=charArray.length-1;i>=0;i--)
            {
                // newStr= newStr+String.valueOf(convertedStr.charAt(i));
                newStr= newStr+charArray[i];
            }

            System.out.println("new Str-->"+newStr);
            return convertedStr.equalsIgnoreCase(newStr);
        }

}
