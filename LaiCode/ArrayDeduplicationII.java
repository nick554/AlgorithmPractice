/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep at most two of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.

Examples

{1, 2, 2, 3, 3, 3} ¡ú {1, 2, 2, 3, 3}
*/

/*
  Time:  O( n ) 
  Space: O( 1 )
*/

public class Solution {
  // assumption: array != null
  public int[] dedup(int[] array) {
    // base case
    int len = array.length;
    if ( len < 3 ) {
      return array;
    }
    
    // use two pointer to solve this problem
    int end = 2;  // == last element + 1
    for ( int i = end; i < len; i++ ) {
      if ( array[i] != array[ end - 2 ] ) {
        array[end++] = array[i];
      }
    }
    
    return Arrays.copyOfRange( array, 0, end );
  }
}