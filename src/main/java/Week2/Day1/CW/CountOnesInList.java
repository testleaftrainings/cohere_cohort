package Week2.Day1.CW;

import java.util.List;

public class CountOnesInList {
    public static void main(String[] args) {
        List<Integer> list = List.of(0, 0, 1, 1, 1, 1);
        int countOfOnes = countOnes(list);
        System.out.println("Number of 1s: " + countOfOnes);
    }

    public static int countOnes(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                // Return the count of 1s from the first occurrence
                return list.size() - i;

            }
        }
        return 0;
    }
}