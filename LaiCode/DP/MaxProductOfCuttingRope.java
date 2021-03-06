/*
Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]p[1] ... p[m-1]? m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.

Examples

n = 12, the max product is 3 3 3 3 = 81(cut the rope into 4 pieces with length of each is 3).
*/

/*
  Time:  O( n ) 
  Space: O( n )
*/

public class Solution {
  // assumption: n >= 2
  public int maxProduct(int length) {
    int[] dp = new int[ length + 1 ];
    dp[1] = 1;
    dp[2] = 1;
    for ( int i = 3; i <= length; i++ ) {
      int result = 0;
      for ( int j = 2; j < i; j++ ) {
        int tmp = ( dp[j] > j ? dp[j] : j ) * ( dp[ i - j ] > i - j ? dp[ i - j] : i - j );
        result = tmp > result ? tmp : result;
      }
      dp[i] = result;
    }
    return dp[ length ];
  }
}