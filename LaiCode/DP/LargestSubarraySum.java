/*
Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.

Examples

{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5

{-2, -1, -3}, the largest subarray sum is -1
*/

/*
  Time:  O( n ) 
  Space: O( n )
*/

public class Solution {
  // assumption: array.length >= 1
  public int largestSum(int[] array) {
    // use DP to handle this: DP[i] = the biggest sum with a substring ending at index i
    int[] DP = new int[ array.length ];
    
    // initialize
    int result = array[0];
    DP[0] = array[0];
    
    // DP[i] = ...
    for ( int i = 1; i < array.length; i++ ) {
      if ( DP[i-1] > 0 ) {
        DP[i] = array[i] + DP[i-1];
        result = Math.max( result, DP[i] );
      } else {
        DP[i] = array[i];
        result = Math.max( result, DP[i] );
      }
    }
    
    return result;
  }
}