/*
Determine if a small string is a substring of another large string.
Return the index of the first occurrence of the small string in the large string.
Return -1 if the small string is not a substring of the large string.

Examples

¡°ab¡± is a substring of ¡°bcabc¡±, return 2
¡°bcd¡± is not a substring of ¡°bcabc¡±, return -1
"" is substring of "abc", return 0
*/

/*
  Time:  O( n ) 
  Space: O( 1 )
*/

public class Solution {
  // input not null / ""is a substring of any string, return 0 in this case
  public int strstr(String large, String small) {
    // corner case
    if ( small.length() == 0 ) {
      return 0;
    }
    
    // go through the larger string
    for ( int i = 0; i <= large.length() - small.length(); i++) {
      if (large.charAt(i) == small.charAt(0)) {
        boolean isSubString = checkWhole(large, small, i); // can be improved: return new starting index
        if ( isSubString ) {
          return i;
        }
      }
    }
    return -1;
  }
  
  // return true if new substring found!
  private boolean checkWhole(String large, String small, int i) {
    for (int j = 0; j < small.length(); j++) {
    	if (large.charAt(i + j) != small.charAt(j)) {
        return false;
      }
    }
    return true;
  }
}