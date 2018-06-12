/*
Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.

Examples

string one: ¡°sigh¡±, string two : ¡°asith¡±

the edit distance between one and two is 2 (one insert ¡°a¡± at front then replace ¡°g¡± with ¡°t¡±).
*/

/*
  Time:  O( m*n ) 
  Space: O( m*n )
*/

public class Solution {
  // one not null and two not null
  public int editDistance(String one, String two) {
    // Dp solution
    // DP[m][n] = # of operations needed when one(0, m] ==two(0,n]
    int m = one.length();
    int n = two.length();
    int[][]  DP = new int[m+1][n+1];
    
    // initialize the table
    for ( int i = 0; i <= m; i++ ) {
      DP[i][0] = i;
    }
    for ( int i = 1; i <= n; i++ ) {
      DP[0][i] = i;
    }
    
    for ( int i = 1; i <= m; i++ ) {
      for ( int j = 1; j <= n; j++ ) {
        // two ways to get the resultDP[i][j]:
        // 1. from DP[i-1][j-1]
        if ( one.charAt(i-1) == two.charAt(j-1) ) {
          DP[i][j] = DP[i-1][j-1];
        } else {
          DP[i][j] = DP[i-1][j-1] + 1;
        }
        // 2. from DP[i-1][j] or DP[i][j-1]
        int tmp = Math.min( DP[i-1][j], DP[i][j-1] ) + 1;
        DP[i][j] = DP[i][j] > tmp ? tmp : DP[i][j];
      }
    }
    return DP[m][n];
  }
}