package Week2.Day1.CW;

import org.junit.Test;

public class ArrangeCoins {

    @Test
    public void test1(){
        int n = 5;
        int completeRows = buildStaircase(n);
        System.out.println("Number of complete rows: " + completeRows);
    }

    @Test
    public void test2(){
        int n = 8;
        int completeRows = buildStaircase(n);
        System.out.println("Number of complete rows: " + completeRows);
    }

        public static int buildStaircase(int n) {
                int x = 0;
                int count = 0;
                int coins = 0;
                for (int i = 1; i<=n; i++){
                    coins = coins + i;
                    x = x+1;
                    count++;
                    if (coins>n){
                        break;
                    }
                }
                return count-1;

        }
}

/*
You have n coins and you want to build a staircase with these coins.
The staircase consists of k rows where the ith row has exactly i coins.
The last row of the staircase may be incomplete.
Given the integer n, return the number of complete rows of the staircase you will build.

Example 1:
Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.

Example 2:
Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.

 */