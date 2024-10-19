package Week1.Day2.CN;

import java.util.Arrays;

public class LearnArrays {

    private String name = "Haja";

    public static void main(String[] args) {

        // literal way of creation
        int[] marks = {91, 85, 76, 89, 69};

        int[] mark = new int[5];
        mark[0] = 91;
        mark[1] = 85;
//		for (int i = 0; i < mark.length; i++) {
//			System.out.println(mark[i]);
//		}

        Arrays.sort(marks);
        for (int i = marks.length-1; i >= 0; i--) {
            System.out.println(marks[i]);
        }

    }
}
