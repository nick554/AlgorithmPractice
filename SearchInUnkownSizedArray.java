/*
Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order, determine if a given target integer T is in the dictionary. Return the index of T in A, return -1 if T is not in A.

Examples

A = {1, 2, 5, 9, ......}, 	T = 5, return 2
A = {1, 2, 5, 9, 12, ......}, 	T = 7, return -1
*/

/*
  Time:  O( log(n) ) 
  Space: O( 1 )
*/


public class Solution {
  // assumption: dictionary not null/ words are all numbers/ size < INT_MAX
  /*
     interface Dictionary {
       public Integer get(int index);  // return null if out of bounds
     }
  */

  public int search(Dictionary dict, int target) {
    // initialize range with [0,2) -- index
    int left = 0;
    int right = 2;
    
    // increasing the range until find the index out of bounds
    Integer end = dict.get(right);
    while ( end != null && end < target ) {
      left = right;
      right = right << 1;   // rate = 2;
      end = dict.get(right);
    }
    
    // find the target using binary search
    while ( left <= right ) {
      int mid = left + ( right - left )/2;
      Integer tmp = dict.get( mid );
      if ( tmp == null || tmp > target ) {
        right = mid - 1;
      } else if ( tmp < target ) {
        left = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}