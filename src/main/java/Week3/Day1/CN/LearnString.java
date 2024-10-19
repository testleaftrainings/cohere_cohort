package Week3.Day1.CN;

public class LearnString {

    public static void main(String[] args) {
        /*
         *  Sequence of characters
         *  Non primitive datatype
         */

        // String literal (String pool memory)
        String name = "Haja";

        // String Object (Heap memory)
        String comName = new String("Welcome to TestLeaf  ");

        System.out.println(name);
        System.out.println(comName);

        // String comparision
        System.out.println(name.equals(comName));
        System.out.println(name == comName);
        System.out.println(name.equalsIgnoreCase(comName));

        // convert to character array
        char[] charArray = name.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]);
        }

        // To get the number of characters in String
        int length = name.length();
        System.out.println(length);

        // to get a particular character
        System.out.println(name.charAt(0));

        // get an index of a character
        System.out.println(name.indexOf('a'));

        // convert the case of String
        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());

        System.out.println(name.contains("al"));

        // to get a partial string
        String substring = comName.substring(4);
        System.out.println(substring);
        String substring2 = comName.substring(0, 4);
        System.out.println(substring2);

        // removing leading or trailing spaces
        System.out.println(comName.trim());

        // to split a string
        String[] split = comName.split(" ");



    }

}

