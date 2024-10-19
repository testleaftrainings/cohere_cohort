package Week3.Day2.CW;

import org.junit.Test;

public class JewelStones {

    @Test
    public void testNumJewelsInStones_Example1() {
        String jewels = "aA";
        String stones = "aAAbbbb";
        int result = numJewelsInStones(jewels, stones);
        System.out.println("Test 1 Result: " + result); // Expected: 3
    }

    @Test
    public void testNumJewelsInStones_Example2() {
        String jewels = "z";
        String stones = "ZZ";
        int result = numJewelsInStones(jewels, stones);
        System.out.println("Test 2 Result: " + result); // Expected: 0
    }

    @Test
    public void testNumJewelsInStones_Additional() {
        String jewels = "abc";
        String stones = "aabbccAA";
        int result = numJewelsInStones(jewels, stones);
        System.out.println("Test 3 Result: " + result); // Expected: 6
    }
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0; // Initialize counter

        // Loop through each stone
        for (char stone : stones.toCharArray()) {
            // Check if the current stone is a jewel
            if (jewels.indexOf(stone) != -1) {
                count++; // Increment the counter
            }

        }

        return count; // Return the total count of jewels in stones
    }

}
