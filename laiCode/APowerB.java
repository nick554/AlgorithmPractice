/*
Evaluate a to the power of b, assuming both a and b are integers and b is non-negative. 

Examples

power(2, 0) = 1
power(2, 3) = 8
power(0, 10) = 0
power(-2, 5) = -32
*/

/*
  Time:  O( log(b) ) 
  Space: O( log(b) )
*/

public class Solution {
  // assumption: long is enough for the result
  // no need to consider a == 0 and b == 0
  public long power(int a, int b) {
    //corner case: 0,1, no need to consider INT_MAX
    if ( a == 0 && b != 0 ) return 0;
    if ( a == 1 || b == 0 ) return 1;
    
    return powerHelper( a, b );
  }
  private long powerHelper( int a, int b ) {
    // base case 
    if ( b == 1 ) return (long)a;
    
    // even & odd
    long sqrt = powerHelper( a, b/2 );
    if ( b % 2 == 0 ) {
      return sqrt*sqrt;
    } else {
      return sqrt*sqrt*a;
    }
  } 
}