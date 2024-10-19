package Week2.Day1.CN;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LearnSet {

    public static void main(String[] args) {

        /*
         * Set is an interface
         * It doesn't allow duplicates
         * It doesn't maintain order of insertion
         * HashSet (random order), TreeSet (ASCII order),
         * LinkedHashSet (insertion order)
         */

        Set<Integer> empIds = new HashSet<Integer>();

        // to add items to set
        empIds.add(1001);
        empIds.add(1002);
        empIds.add(1003);
        boolean isAdded = empIds.add(1004);

        System.out.println(empIds);
        System.out.println(isAdded);

        // to convert it to list

        List<Integer> ids = new ArrayList<Integer>(empIds);
        System.out.println(ids.get(0));



    }

}
