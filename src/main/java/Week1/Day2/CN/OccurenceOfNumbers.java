package Week1.Day2.CN;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class OccurenceOfNumbers {
    /*
	 * 1) Did I understand the problem? -> If yes, go to next step !!
	 *
	 * What is the input(s) type? int[]
	 * What is the expected output?
	 * Do I have constraints to solve the problem?
	 * Do I have all informations to go to next step!!
//	 * How big is your test data set will be?
	 *
	 * 2) Test data set
	 *
	 * Minimum of 3 data set !!
	 * P - {1,2,,3,3,5,5,6}
	 * N - {}
	 * E -
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
	 *
	 */

    public static void main(String[] args) {
        // Map <K, V>
        /* {1,2,3,3,5,5,6} --> 1 - 1
         * 						2 - 1
         * 						3 - 2
         * 						5 - 2
         * 						6 - 1
         *
         * 1. Create an empty map for storing the output Map<int, int> out
         * 2. Iterate through each element in array		 - 3
         * 3. If current element is present as a key in map,
         * 		take current value and increment else - 1 + 1
         * 		Add the current element as key and set the value to 1 - 3, 2
         * 4. Print the output map
         *
         */

        int[] input = {1,2,3,3,5,5,6};
        OccurenceOfNumbers occ = new OccurenceOfNumbers();
        Map<Integer, Integer> output = occ.findOccurence(input);
        System.out.println(output);
    }

    @Test
    public void test1() {
        int[] input = {1,2,3,3,5,5,6};
        Map<Integer, Integer> output = findOccurence(input);
        System.out.println(output);
    }

    @Test
    public void test2() {

        // 1 -1
        // 2 -1

    }

    @Test
    public void test3() {

    }

    public Map<Integer, Integer> findOccurence(int[] input) {
        // {1,2,3,3,5,5,6}
        Map<Integer, Integer> output = new HashMap<Integer, Integer>();
        // empty
        for (int i = 0; i < input.length; i++) {
//			if(output.containsKey(input[i])) {
//				int curValue = output.get(input[i]);
//				output.put(input[i], curValue+1);
//			} else {
//				output.put(input[i], 1);
//			}
            output.put(input[i], output.getOrDefault(input[i], 0) + 1);
            // 1 -> 1
            // 2 -> 1
            // 3 -> 1
            // 3 -> 2
        }

        return output;
    }


    /*
     * Ex: input = [2, 4, 6, 8]
     * 		target = 10
     * 1. Initialize a map
     * 2. Iterate through the array
     * 3. Get the difference of the current number from the target
     * 4. If the difference is present in the map as key,
     * 		a. return current index, index of difference from map
     * 5. Put the key as the current element and value as it's index
     * 6. if no matching target, return -1, -1
     */

}
