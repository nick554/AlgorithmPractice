/*
Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.

Assumptions

There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.
Examples

A = {1, 2, 3, 4, 5}, T = 3, 	return 2
A = {1, 2, 3, 4, 5}, T = 6, 	return -1
A = {1, 2, 2, 2, 3, 4}, T = 2, 	return 1 or 2 or 3
*/

/*
  Time:  O( log(n) ) 
  Space: O( 1 )
*/

public class Solution {
  // assumption: have duplicate numbers/ return -1 for null & len == 0
  
  public int binarySearch(int[] array, int target) {
    // corner case for null & 0
    if ( array == null || array.length == 0 ) return -1;
    
    // compare with the median/ left one when even to smaller the scope
    int left = 0;
    int right = array.length - 1;
    while ( left <= right ) {
      int mid = left + ( right - left )/2;
      int tmp = array[mid];
      if ( tmp > target ) {
        right = mid - 1;
      } else if ( tmp < target ) {
        left = mid + 1;
      } else {
        return mid;
      }
    }

    // no such index
    return -1;
  }
}