/*
Given a matrix that contains integers, find the submatrix with the largest sum.

Return the sum of the submatrix.

Examples

{ {1, -2, -1, 4},

  {1, -1,  1, 1},

  {0, -1, -1, 1},

  {0,  0,  1, 1} }

the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
*/

/*
  Time:  O( n^3 ) 
  Space: O( n^2 )
*/

public class Solution {
  // assumption: matrix size > 0
  public int largest(int[][] matrix) {
    // use dp to reduce time complexity
    int row = matrix.length;
    int col = matrix[0].length;
    // initialize DP matrix. DP[i][j] = sum of the first i elements in column j
    int[][] DP = colSum( matrix, row, col );
      
    // search for every possible result
    return search( DP, row, col );
  }
  
  private int search( int[][] m, int row, int col ) {
    int result = m[0][0];
    
    for ( int i = 0; i < row; i++ ) {  // bottom row
      result = Math.max( LargestSum( m[i] ), result );
      int[] tmp = new int[col];
      for ( int j = 0; j < i; j++ ) {  // top row
        for ( int index = 0; index < col; index++ ) {
          tmp[index] = m[i][index] - m[j][index];
          result = Math.max( LargestSum( tmp ), result );
        }
      }
    }
    return result;
  }
  
  private int LargestSum( int[] array ) {
    int n = array.length;
    int result = array[0];
    int[] tmp = new int[2];
    tmp[0] = result;
    int index = 0;
    for ( int i = 1; i < n; i++ ) {
      tmp[ 1 - index ] = tmp[index] > 0 ? tmp[index] + array[i] : array[i];
      result = Math.max( result, tmp[ index = 1 - index ] );
    }
    return result;
  }
  
  private int[][] colSum( int[][] m, int row, int col ) {
    // initialize
    int[][] DP = new int[row][col];
    DP[0][0] = m[0][0];
    for ( int j = 1; j < col; j++ ) {
      DP[0][j] = m[0][j];
    }
    // calculate DP[i][j]
    for ( int i = 1; i < row; i++ ) {
      for ( int j = 0; j < col; j++ ) {
        DP[i][j] = DP[i-1][j] + m[i][j];
      }
    }
    return DP;
  }
}