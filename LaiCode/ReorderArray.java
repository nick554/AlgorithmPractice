/*
Given an array of elements, reorder it as follow:

{ N1, N2, N3, бн, N2k } б· { N1, Nk+1, N2, Nk+2, N3, Nk+3, бн , Nk, N2k }

{ N1, N2, N3, бн, N2k+1 } б· { N1, Nk+1, N2, Nk+2, N3, Nk+3, бн , Nk, N2k, N2k+1 }

Try to do it in place.

Examples

{ 1, 2, 3, 4, 5, 6} б· { 1, 4, 2, 5, 3, 6 }

{ 1, 2, 3, 4, 5, 6, 7, 8 } б· { 1, 5, 2, 6, 3, 7, 4, 8 }

{ 1, 2, 3, 4, 5, 6, 7 } б· { 1, 4, 2, 5, 3, 6, 7 }
*/

/*
  Time:  O( nlogn ) 
  Space: O( logn )
*/

public class Solution {
  // assumption: array not null
  public int[] reorder(int[] array) {
    // corner case
    if ( array.length < 3 ) {
      return array;
    }
    
    //deal with the case with odd elements
    if ( ( array.length & 1 ) == 0 ) {
      reorderHelper( array, 0, array.length);
    } else {
      reorderHelper( array, 0, array.length - 1);
    }
    
    return array;
  }
  
  private void reorderHelper( int[] array, int start, int end ) {
    // base case
    if ( end - start < 3 ) return;
    
    // recursion rule
    // 1 2 3 4 -> 1 3 2 4 length: 1=3, 2=4
    int half = ( end - start ) / 2;
    int qurt = half / 2;
    int mid = half + start;
    int left = qurt + start;
    int right = left + half;
    reverse( array, left, mid );
    reverse( array, mid, right );
    reverse( array, left, right );
    
    reorderHelper( array, start, mid );
    reorderHelper( array, mid, end );
  }
  
  private void reverse( int[] a, int s, int e) {
    e--;
    while ( s < e ) {
      swap( a, s++, e-- );
    }
  }
  
  private void swap( int[] a, int s, int e ) {
    a[s] ^= a[e];
    a[e] ^= a[s];
    a[s] ^= a[e];
  }
}