/*
Given an array of integers, sort the elements in the array in ascending order. The quick sort algorithm should be used to solve this problem.

Examples

{1} 			is sorted to {1}
{1, 2, 3} 		is sorted to {1, 2, 3}
{3, 2, 1} 		is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} 	is sorted to {-3, 1, 2, 4, 6}
*/

/*
  Time:  O( nlog(n) ) 
  Space: O( log(n) )
*/

public class Solution {
  // assumption: ascending order/ len < INT_MAX/ no need to deal with null or length == 0

  public int[] quickSort(int[] array) {
    // corner case
    if ( array != null && array.length > 1 ) {
      quickSortHelper( array, 0, array.length );
    }
    return array;
  }

  private void quickSortHelper( int[] array, int start, int end ) {
    // base case: when length <= 1
    if ( end <= start+1 ) return;
    
    // choose a pivot: randomly choose
    int pivot_index = (int)(Math.random() * (end - start - 1)) + start;
    // put pivot at head
    swap( array, start, pivot_index );
    int pivot = array[start];
    
    // partition: put smaller to left, larger to right
    int index = start+1;   //left element smaller than pivot
    for ( int i = index; i < end; i++ ) {
      if ( array[i] < pivot ) {
        swap( array, index++, i );
      }
    }
    swap( array, index-1, start ); 
    
    // deal with the smaller array
    quickSortHelper( array, start, index-1);
    quickSortHelper( array, index, end);
    
    return;
  }
  private void swap( int[] a, int i, int j ) {
    // not working when i == j
    if ( i != j ) {
      a[i] ^= a[j];
      a[j] ^= a[i];
      a[i] ^= a[j];
    }
  }
}
