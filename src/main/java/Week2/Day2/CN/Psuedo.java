package Week2.Day2.CN;
/*
 * Ex: 0, 1, 0, 3, 12 --> 1, 3, 12, 0, 0
 *
 * 1. Initialize an index variable
 * 2. Iterate through each element in array
 * 3. Compare each element with 0
 * 4. If current is not 0,
 * 		a. take that element and put in the first index
 * 		b. increment current index
 * 5. Iterate from current index till end of array
 * 6. assign the current value with 0
 * 7. increment the current index
 *
 *
 *
 * 1, 1, 0, 3, 12
 * 1, 3, 0, 3, 12
 * 1, 3, 12, 3, 12
 * 1, 3, 12, 0, 12
 * 1, 3, 12, 0, 0
 */

/*
 * Ex: input = [2, 4, 6, 8]
 * 		target = 10
 * 1. Initialize a map
 * 2. Iterate through the array
 * 3. Get the difference of the current number from the target
 * 4. If the difference is present in the map as key,
 * 		a. return current index, index of difference from map
 * 5. Put the key as the current element and value as it's index
 * 6. if no matching target, return -1, -1
 */
public class Psuedo {
}
