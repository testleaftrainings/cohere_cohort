package Week2.Day2.CN;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LearnMap {

    public static void main(String[] args) {

        /*
         * List, Set --> Interfaces (collection)
         * Single dimensional
         *
         * when we need to store the date in 2 dimension,
         * like a pair
         *
         * Map --> interface
         * Can i create object for Map --> No
         * How to use Map?
         * 	- HashMap --> random order --> faster
         * 	- TreeMap --> ASCII
         * 	- LinkedHashMap --> Insertion order (key)
         */

        Map<Integer, String> mentors = new HashMap<Integer, String>();

        // to add a pair to the map
        mentors.put(1001, "Haja");
        mentors.put(1002, "Hari");

        System.out.println(mentors);
        System.out.println(mentors.size());

        // to get the value of particular key
        System.out.println(mentors.get(1002));

        //to get each pair
        Set<Map.Entry<Integer, String>> entrySet = mentors.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet) {
            System.out.println(entry.getValue());
            System.out.println(entry.getKey());
        }

        // to check if a key is present
        boolean containsKey = mentors.containsKey(1003);
        System.out.println(containsKey);

    }

}
