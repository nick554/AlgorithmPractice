/*
Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.

Examples

A = {2, 1, 4}, the missing number is 3
A = {1, 2, 3}, the missing number is 4
A = {}, the missing number is 1
*/

/*
  Time:  O( n ) 
  Space: O( 1 )
*/

public class Solution {
  // assumption: array not null/N >= 1
  public int missing(int[] array) {
    //use the bit operation
    int result = 0;
    int N = array.length + 1;
    for (int i = 1; i <= N; i++) {
      result ^= i;
    }
    
    for (int i = 0; i < N - 1; i++) {
      result ^= array[i];
    }
    
    return result;
  }
}