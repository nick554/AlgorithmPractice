/*
Given a target integer T and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to T.

Assumptions

There can be duplicate elements in the array, and we can return any of the indices with same value.
Examples

A = {1, 2, 3}, T = 2, 		return 1
A = {1, 4, 6}, T = 3, 		return 1
A = {1, 4, 6}, T = 5, 		return 1 or 2
A = {1, 3, 3, 4}, T = 2, 	return 0 or 1 or 2
*/

/*
  Time:  O( log(n) ) 
  Space: O( 1 )
*/

public class Solution {
  // assumption: can have duplicates/ null & len == 0 => return -1/ find itself: return itself
  public int closest(int[] array, int target) {
    // corner case: null
    if ( array == null ) return -1;
    // corner case: len <2;
    int right = array.length - 1;
    if ( right < 1 ) return right;
    
    // narrow the range to 2 elements
    int left = 0;
    while ( left+1 < right ) {
      int mid = left + ( right - left )/2;
      int tmp = array[ mid ];
      if ( tmp > target ) {
        right = mid;
      } else if ( tmp < target ) {
        left = mid;
      } else {
        return mid;
      }
    }
    
    // compare last two possible elements to find the result;
    // must use Math.abs in case the target is smaller/larger than all the elements in array
    return Math.abs( target - array[left] )
      > Math.abs( target - array[right] ) ? right : left;
  }
}