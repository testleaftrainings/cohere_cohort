package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Occurence {
    public static void main(String args[]){
        int[] arr = {1,2,3};
        Map<Integer, Integer> output = new HashMap<Integer, Integer>();
        for (int i = 0; i< arr.length; i++){
            if(output.containsKey(arr[i])){
                int curValue = output.get(arr[i]);
                output.put(arr[i], curValue+1);
            }else{
                output.put(arr[i], 1);
            }
        }
        System.out.println(output);



       /* // Step 1: Count occurrences of each number
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check if all counts are unique
        Set<Integer> frequencySet = new HashSet<>();
        for (int count : countMap.values()) {
            if (!frequencySet.add(count)) {
                // If add returns false, it means the count already exists in the set
                System.out.println("True");
                return;
            }
        }

        // All counts are unique
        System.out.println("False");*/
    }
}
