/*
Given an array of integers, sort the elements in the array in ascending order. The merge sort algorithm should be used to solve this problem.

Examples

{1}			is sorted to {1}
{1, 2, 3}		is sorted to {1, 2, 3}
{3, 2, 1} 		is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} 	is sorted to {-3, 1, 2, 4, 6}
*/

public class Solution {
  // assumption: ascending order/ limited length/ no need to deal with null or length == 0

  public int[] mergeSort(int[] array) {
    // corner case: null, len < 2
    if ( array != null && array.length > 1 ) {
      int len = array.length;
      // helper array£ºadditional place for merge
      int[] helper = new int[len];
      mergeSortHelper( array, helper, 0, len );
    }
    return array;
  }

  private void mergeSortHelper( int[] array, int[] helper, int start, int end ) {
    // base case: when length <= 1
    if ( end - 1 <= start ) return;
    
    // devide one array into two smaller one & solve for both
    int mid = start + (end - start)/2;
    mergeSortHelper( array, helper, start, mid );
    mergeSortHelper( array, helper, mid, end );
    
    // merge two result for bigger array
    merge( array, helper, start, end );
    
    return;
  }
  private void merge( int[] array, int[] helper, int start, int end ) {
    // devide the array
    int mid = start + (end - start)/2;

    // create two pointer for both part and one index for helper array
    int index = start;
    int left = start;
    int right = mid;
    // put every element into helper array from small to large until reach the end of one array
    while ( left < mid && right < end ) {
      // when equal, choose the one from left array to make the sorting stable
      if ( array[left] <= array[right] ) {
        helper[index++] = array[left++];
      } else {
        helper[index++] = array[right++];
      }
    }

    // deal with the remaining element in left array; the ones in right array will remain their position => no need to do anything
    while ( left < mid ) {
      helper[index++] = array[left++];
    }
    // put back from helper to origin one
    for ( int i = start; i < right; i++ ) {
      array[i] = helper[i];
    }
    return;
  }
}