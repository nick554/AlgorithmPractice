/*
Given a string, find the longest substring without any repeating characters and return the length of it. The input string is guaranteed to be not null.
*/

/*
  Time:  O( n ) 
  Space: O( 1 )
*/

public class Solution {
  // input not null || no upper case letter
  public int longest(String input) {
    int len = input.length();
    // corner case
    if ( len < 2 ) {
      return len;
    }
    // use a hashmap to record the last appearance of the character
    Map< Character, Integer > position = new HashMap< Character, Integer >();
    int head = 0;
    int result = 0;
    for ( int i = 0; i < input.length(); i++ ) {
      Integer current = position.put( input.charAt(i), i );
      if ( current != null && current >= head ) {
        result = result < i - head ? i - head : result;
        head = current + 1;
      } else {
        result = result < i - head + 1 ? i - head + 1 : result;
      }
    }
    
    return result;
  }
}