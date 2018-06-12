/*
Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). Determine the minimum number of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.

Examples

{3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)

{2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
*/

/*
  Time:  O( n^2 ) 
  Space: O( n )
*/

public class Solution {
  // assumption: array not null; array.length > 1
  public int minJump(int[] array) {
    int[] MinStep = new int[ array.length ];
    MinStep[0] = 0;
    for ( int i = 0; i < array.length - 1; i++ ) {
      int step = array[i];
      int min = MinStep[i] + 1;
      if ( min == 1 && i != 0 ) {  // this block is unreachable
        continue;
      }
      for ( int j = 1; j <= step && i + j < array.length; j++ ) {
        int tmp = MinStep[ i + j ];
        if ( tmp == 0 || tmp > min ) {
          MinStep[ i + j ] = min;
        }
      }
    }
    int result = MinStep[ array.length - 1 ];
    if ( result == 0 && array.length != 1 ) {
      return -1;
    } else {
      return result;
    }
  }
}