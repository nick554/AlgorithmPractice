/*
Given an array of integers, sort the elements in the array in ascending order. The merge sort algorithm should be used to solve this problem.

Examples

{1}			is sorted to {1}
{1, 2, 3}		is sorted to {1, 2, 3}
{3, 2, 1} 		is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} 	is sorted to {-3, 1, 2, 4, 6}
*/

public class Solution {
  public int[] mergeSort(int[] array) {
    // assumption: 
    // corner case: null, len < 2
    if ( array != null && array.length > 1 ) {
      int len = array.length;
      int[] helper = new int[len];
      mergeSortHelper( array, helper, 0, len );
    }
    return array;
  }
  private void mergeSortHelper( int[] array, int[] helper, int start, int end ) {
    // helper£ºadditional place for merge
    
    // base case:
    if ( end - 1 <= start ) return;
    
    // devide one array into two smaller one
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
    while ( left < mid && right < end ) {
      if ( array[left] <= array[right] ) {
        helper[index++] = array[left++];
      } else {
        helper[index++] = array[right++];
      }
    }
    while ( left < mid ) {
      helper[index++] = array[left++];
    }
    for ( int i = start; i < right; i++ ) {
      array[i] = helper[i];
    }
		return;
  }
}