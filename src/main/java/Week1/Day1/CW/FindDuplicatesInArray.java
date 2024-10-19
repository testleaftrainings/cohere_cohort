package Week1.Day1.CW;

import org.junit.Test;

import java.util.Arrays;

public class FindDuplicatesInArray {

    @Test
    public void testFindDuplicates() {
        System.out.println("Running testFindDuplicates1:");
        int[] input = {4, 3, 2, 7, 8, 4, 4, 2, 3, 1};
        int[] duplicates = findDuplicates(input);
        System.out.println("Duplicates: " + Arrays.toString(duplicates));
    }

    @Test
    public void test2() {
        System.out.println("Running testFindDuplicates2:");
        int[] input = {1, 1, 2};
        int[] duplicates = findDuplicates(input);
        System.out.println("Duplicates: " + Arrays.toString(duplicates));
    }

    @Test
    public void testNoDuplicates() {
        System.out.println("Running testNoDuplicates3:");
        int[] input = {1, 2, 3, 4, 5};
        int[] duplicates = findDuplicates(input);
        System.out.println("Duplicates: " + Arrays.toString(duplicates));
    }

    @Test
    public void testAllDuplicates() {
        System.out.println("Running testAllDuplicates4:");
        int[] input = {1, 1, 1, 1};
        int[] duplicates = findDuplicates(input);
        System.out.println("Duplicates: " + Arrays.toString(duplicates));
    }

    @Test
    public void testEmptyArray() {
        System.out.println("Running testEmptyArray5:");
        int[] input = {};
        int[] duplicates = findDuplicates(input);
        System.out.println("Duplicates: " + Arrays.toString(duplicates));
    }

    @Test
    public void testSingleElementArray() {
        System.out.println("Running testSingleElementArray6:");
        int[] input = {1};
        int[] duplicates = findDuplicates(input);
        System.out.println("Duplicates: " + Arrays.toString(duplicates));
    }

    public static int[] findDuplicates(int[] input) {
        int length = input.length;

        // Array to track duplicates (using a temporary array)
        int[] tempDuplicates = new int[length]; // Maximum size of duplicates can be length of input
        int index = 0;

        // Check for duplicates
        for (int i = 0; i < length; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < length; j++) {
                if (input[i] == input[j]) {
                    // Check if already added to tempDuplicates
                    isDuplicate = true;
                    boolean alreadyAdded = false;
                    for (int k = 0; k < index; k++) {
                        if (tempDuplicates[k] == input[i]) {
                            alreadyAdded = true;
                            break;
                        }
                    }
                    if (!alreadyAdded) {
                        tempDuplicates[index++] = input[i];
                    }
                    break; // Found a duplicate, break inner loop
                }
            }
        }

        // Create a final array with the exact size of duplicates found
        int[] duplicates = new int[index];
        for (int i = 0; i < index; i++) {
            duplicates[i] = tempDuplicates[i];
        }
        return duplicates;
    }
}


    /*
     public static void findDuplicates(int[] input) {
        int length = input.length;
        // Iterate through each element
        for (int i = 0; i < length; i++) {
            // Compare it with every subsequent element
            for (int j = i + 1; j < length; j++) {
                // Check if a duplicate is found
                if (input[i] == input[j]) {
                    // Check if this duplicate has been printed before
                    boolean alreadyPrinted = false;
                    for (int k = 0; k < i; k++) {
                        if (input[i] == input[k]) {
                            alreadyPrinted = true;
                            break;
                        }
                    }
                    if (!alreadyPrinted) {
                        // Print the duplicate value
                        System.out.println("Duplicate found: " + input[i]);
                    }
                    break; // Stop checking for further duplicates of this element
                }
            }
        }
    }

     */








/*
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and
each integer appears once or twice, return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant auxiliary space,
excluding the space needed to store the output

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]

Example 2:
Input: nums = [1,1,2]
Output: [1]

Example 3:
Input: nums = [1]
Output: []

 */
