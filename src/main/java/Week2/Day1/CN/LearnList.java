package Week2.Day1.CN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LearnList {

    public static void main(String[] args) {
        /*
         * List is an interface
         * It is dynamic in nature
         * It allows duplicate values
         * Maintains Order of insertion
         *
         * - ArrayList
         * - LinkedList
         */

        List<String> mentors = new ArrayList<String>();
        mentors.add("Haja");
        mentors.add("Hari");
        mentors.add("Arvind");

        // identify items count in list
        int size = mentors.size();
        System.out.println(size);

        // get first item from list
        System.out.println(mentors.get(0));

        // print all items
        System.out.println(mentors);

        // remove an item from list
        mentors.remove(0);
        System.out.println(mentors);
//		System.out.println(mentors.get(2));

        // to check if an element is present in list
        boolean isPresent = mentors.contains("Haja");
        System.out.println(isPresent);

        // to remove all the elements
//		mentors.clear();
//		System.out.println(mentors);

        // convert list to array
        Object[] array = mentors.toArray();
        System.out.println(array.length);

        // Sort a list
        Collections.sort(mentors);
        System.out.println(mentors);

        // Sort in reverse
        Collections.reverse(mentors);
        System.out.println(mentors);

        for (int i = 0; i < mentors.size(); i++) {
            System.out.println(mentors.get(i));
        }

        for (String eachMentor : mentors) {
            System.out.println(eachMentor);
        }


    }
}
