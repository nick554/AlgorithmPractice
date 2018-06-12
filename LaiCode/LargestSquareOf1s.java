/*
Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.

Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1}}

the largest square of 1s has length of 2
*/

/*
  Time:  O( n^2 ) 
  Space: O( n^2 )
*/

public class Solution {
  // assumption: matrix not null, matrix.length == matrix[0].length != 0
  public int largest(int[][] matrix) {
    // Use DP here, DP[i][j]= the biggest square use i,j as the botton0right corner
    int N = matrix.length;
    int[][] DP = new int[N][N];
    int result = 0;
    
    // initialize:
    for ( int i = 0; i < N; i++ ) {
      DP[0][i] = matrix[0][i];
      DP[i][0] = matrix[i][0];
      result = Math.max( DP[0][i], result );
      result = Math.max( DP[i][0], result );
    }
    
    // DP[i][j] = min( i-1,j &i,j & i,j-1 ) + 1 if matrix[i][j] == 1
    for ( int i = 1; i < N; i++ ) {
      for ( int j = 1; j < N; j++ ) {
        DP[i][j] = matrix[i][j] * ( min( DP, i, j ) + matrix[i][j] );
        result = Math.max( DP[i][j], result );
      }
    }
    
    return result;
  }
  private int min( int[][] DP, int i, int j) {
    int tmp = Math.min( DP[i-1][j], DP[i][j-1] );
    return Math.min( tmp, DP[i-1][j-1] );
  }   
}