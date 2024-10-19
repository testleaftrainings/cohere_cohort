package Week3.Day2.CW;

import org.junit.Test;

public class NumberOfSeniorCitizens {
    @Test
    public void testCountPassengersOver60_Example1() {
        String[] details = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
        int result = countPassengersOver60(details);
        System.out.println("Test 1 Result: " + result); // Expected: 2
    }

    @Test
    public void testCountPassengersOver60_Example2() {
        String[] details = {"1313579440F2036", "2921522980M5644"};
        int result = countPassengersOver60(details);
        System.out.println("Test 2 Result: " + result); // Expected: 0
    }

    @Test
    public void testCountPassengersOver60_Additional() {
        String[] details = {"0000000000M6100", "1111111111F6101", "2222222222M6200", "3333333333F5900"};
        int result = countPassengersOver60(details);
        System.out.println("Test 3 Result: " + result); // Expected: 2
    }

    public int countPassengersOver60(String[] details) {
        int count = 0;

        for (String detail : details) {
            // Extract the age from the string
            String ageString = detail.substring(13, 15); // Characters at index 13 and 14
            int age = Integer.parseInt(ageString); // Convert age to an integer

            // Check if the age is greater than 60
            if (age > 60) {
                count++;
            }
        }

        return count; // Return the total count
    }
}

/*
/*
     * 1) Did I understand the problem? -> If yes, go to next step !!
     *
     * What is the input(s) type?
     * string of array
     * What is the expected output?
     * int
     * Do I have constraints to solve the problem?
     * no constraints
     * Do I have all informations to go to next step!!
     * How big is your test data set will be?
     * 2) Test data set
     *
     * Minimum of 3 data set !!
     * Positive,
     * 7868190130M6122
     *
     * Edge,
     * 7868190130M6022
     *
     * Negative
     * 7868190130M5822
     *
     *
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

     *  initialize the counter
     *  iterate the string array values and get the age value by using substring
     *  convert the age values to integer and check its > 60
     *  if its > 60 add increase the counter value
     *  finally return the counter
     *
     *
     *
     *
     *
     */



