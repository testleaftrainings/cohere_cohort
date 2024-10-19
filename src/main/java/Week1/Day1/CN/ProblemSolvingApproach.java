package Week1.Day1.CN;

import java.util.ArrayList;
import java.util.List;

public class ProblemSolvingApproach {

        // Find the duplicates in a integer array
        // {3, 2, 2, 3, 5, 4, 2}
        // Does the array have multiple duplicate numbers - yes
        // first matching duplicate - no, find all duplicates
        // duplicates in same order - no, any order
        // when should we print if duplicated? more than once or twice - even if it is once

	/*
	 * 1) Did I understand the problem? -> If yes, go to next step !!
	 *
	 * What is the input(s) type? int[]
	 * What is the expected output? print the duplicate numbers
	 * Do I have constraints to solve the problem?
	 * Do I have all informations to go to next step!!
//	 * How big is your test data set will be?
	 *
	 * 2) Test data set
	 *
	 * Minimum of 3 data set !!
	 * Positive - {3, 2, 2, 3, 5, 4, 2} - 3, 2
	 * , Edge - {1, 1, 1, 1} - 1
	 * , Negative - {1, 2, 3, 4} -
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

        /* {3, 2, 2, 3, 5, 4, 2} Bruteforce
         * 1. Traverse through each element in the array
         * 2. Traverse through the remaining elements in the array
         * 3. Check if the number is present again
         * 		a. print the number
         * 		b. do not print if it not present
         *
         */

        public static void main(String[] args) {
            int[] input = {1, 1, 1};
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < input.length; i++) { //i=1 --> 2
                for (int j = i+1; j < input.length; j++) { //j=2 --> 2
                    if (input[i] == input[j]) {
                        if(!list.contains(input[i])) {
                            System.out.println(input[i]);
                            list.add(input[i]); //list - [2]
                        }
//					break;
                    }
                }

            }
        }
















    }

