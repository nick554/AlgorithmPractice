/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value do not keep any of them. Do this in-place, using the left side of the original array and and maintain the relative order of the elements of the array. Return the array after deduplication.

Examples

{1, 2, 2, 3, 3, 3} ¡ú {1}
*/

/*
  Time:  O( n ) 
  Space: O( 1 )
*/

public class Solution {
  // assumption: array != null
  public int[] dedup(int[] array) {
    // base case
    if ( array.length < 2 ) {
      return array;
    }
    
    // use two pointer: the first part as a stack
    int end = 1; // last element needed + 1
    boolean duplicate = false;
    for ( int i = 1; i < array.length; i++ ) {
      if ( array[i-1] == array[i] ) {
        duplicate = true;
      } else if ( duplicate ) {
        array[end-1] = array[i];
        duplicate = false;
      } else {
        array[end++] = array[i];
      }
    }
    if ( duplicate == true ) {
      end--;
    }
    
    return Arrays.copyOfRange( array, 0, end );
  }
}