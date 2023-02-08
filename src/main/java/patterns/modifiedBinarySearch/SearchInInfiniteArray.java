package patterns.modifiedBinarySearch;

/**
 * Problem Statement #
 * Given an infinite sorted array (or an array with unknown size),
 * find if a given number ‘key’ is present in the array.
 * Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
 *
 * Since it is not possible to define an array with infinite (unknown) size,
 * you will be provided with an interface ArrayReader to read elements of the array.
 * ArrayReader.get(index) will return the number at index; if the array’s size is smaller than the index,
 * it will return Integer.MAX_VALUE.
 *
 * Example 1:
 *
 * Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 16
 * Output: 6
 * Explanation: The key is present at index '6' in the array.
 */
public class SearchInInfiniteArray {
    /**
     * Exponentially increase the length of array if nums[i] < k
     * beginning l = 2 then start from s = 2, l = (prevEnd - prevStart + 1) * 2
     */
}
