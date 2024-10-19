package org.example;

import java.util.*;

public class containsDuplicate {
 /*
    1) Did I understand the problem? -> If yes, go to next step !!
            *
            * What is the input(s) type?
            * What is the expected output?
            * Do I have constraints to solve the problem?
            * Do I have all informations to go to next step!!
//	 * How big is your test data set will be?
            *
            * 2) Test data set
	 *
             * Minimum of 3 data set !!
            * Positive, Edge, Negative
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
             * 10) If it fails, debug them to solve it !!
*/


    public boolean occurence() {
        int[] arr = {1, 2, 3};
        Map<Integer, Integer> output = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (output.containsKey(arr[i])) {
                int curValue = output.get(arr[i]);
                output.put(arr[i], curValue + 1);
            } else {
                output.put(arr[i], 1);
            }
        }
        System.out.println(output);
        Set<Integer> set = new HashSet<>((Collection) output);
        return false;
    }

}

