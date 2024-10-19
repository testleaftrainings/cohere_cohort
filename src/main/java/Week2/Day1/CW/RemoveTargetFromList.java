package Week2.Day1.CW;
import java.util.ArrayList;
import java.util.List;

public class RemoveTargetFromList {
        public static void main(String[] args) {

            List<Integer> input1 = List.of(2, 3, 3, 4, 5);
            int target1 = 3;
            System.out.println("Output: " + removeTarget(input1, target1));

            List<Integer> input2 = List.of(2, 2);
            int target2 = 2;
            System.out.println("Output: " + removeTarget(input2, target2));
        }

        public static List<Integer> removeTarget(List<Integer> input, int target) {

            List<Integer> result = new ArrayList<>();

            for (int num : input) {

                if (num != target) {
                    result.add(num);
                }
            }
            return result;
        }
    }

