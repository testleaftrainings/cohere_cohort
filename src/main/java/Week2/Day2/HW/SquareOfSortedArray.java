//package Week2.Day2.HW;
//
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SquareOfSortedArray {
//
//    @Test
//    public void test1(){
//        int array[] = {-4,-1,0,3,10};
//        List<Integer> result = sortedArray(array);
//        System.out.println(result);
//    }
//
//    @Test
//    public void test2(){
//        int array[] = {-7,-3,2,3,11};
//        List<Integer> result = sortedArray(array);
//        System.out.println(result);
//    }
//
//    public List<Integer> sortedArray(int array){
//        List<Integer> square = new ArrayList<>();
//        for (int i = 0; i < array.length; i++){
//            int n = n*n;
//            square.add(array[i]);
//
//        }
//        square.sort(array[i]);
//        return square;
//    }
//
//}
//
///*
//Given an integer array nums sorted in non-decreasing order,
//return an array of the squares of each number sorted in non-decreasing order.
//
//Example 1:
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
//
//Example 2:
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
//
//Follow up: Squaring each element and sorting the new array is very trivial,
//could you find an O(n) solution using a different approach?
// */
