package Week2.Day2.HW;


import org.junit.Test;

public class ClimbingStairs {

    @Test
    public void test1(){
        int n= 2;
        int stairCount =  climbingStairs(n);
        System.out.println(stairCount);
    }

    @Test
    public void test2(){
        int n= 3;
        int stairCount =  climbingStairs(n);
        System.out.println(stairCount);
    }

    public int climbingStairs(int n){
        int a = 0;
        int b = 1;

        for (int i = 0; i < n; i++){

          int  c = a + b;
             a = b; 
             b = c;
        }
return b;



//        if (n == 0) return 1; // One way to stay on the ground
//        if (n == 1) return 1; // One way to reach the first step
//
//        int first = 1; // This represents ways(1)
//        int second = 1; // This represents ways(0)
//
//        for (int i = 2; i <= n; i++) {
//            int current = first + second; // Current ways is the sum of the last two
//            second = first; // Move second to first
//            first = current; // Update first to current
//        }
//
//        return first; // This will be ways(n)
    }
    }




/*
You are climbing a staircase. It takes n steps to reach the top. fibonicci series
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints: 1 <= n <= 45
 */
