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
  Time:  O( n*m ) 
  Space: O( 1 )
*/

public class Solution {
  // input not null / ""is a substring of any string, return 0 in this case
  public int strstr(String large, String small) {
    int len1 = small.length();
    // corner case
    if ( len1 == 0 ) {
      return 0;
    }
    int len2 = large.length();
    
    // check if small string has duplicate chars same as the first char
    int SpeedUp = checkSmall( small );
    if (SpeedUp != 0) {
      SpeedUp--;
    }
    
    // go through the larger string
    char head = small.charAt(0);
		for (int i = 0; i <= len2 - len1; i++) {
      if (large.charAt(i) == head) {
        if (checkWhole(large, small, i)) {
          return i;
        } else {
          i += SpeedUp;
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
  // return the first appearance of the char at head
  int checkSmall(String a) {
    char head = a.charAt(0);
    for ( int i = 1; i < a.length(); i++) {
    	if ( head == a.charAt(i) ) {
        return i;
      }
    }
    return 0;
  }
}