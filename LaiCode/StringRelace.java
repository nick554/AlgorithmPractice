/*
Given an original string input, and two strings S and T, replace all occurrences of S in input with T.

Examples

input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
input = "dodododo", S = "dod", T = "a", input becomes "aoao"
*/

/*
  Time:  O( n ) 
  Space: O( 1 )
*/

public class Solution {
  // assumption: input not null
  public String replace(String input, String source, String target) {
    // get size
    int I = input.length();
    int S = source.length();
    int T = target.length();
    
    // corner case
    if ( I < S || I < T ) {
      return input;
    }
    
    // find occurrence
    Deque< Integer > heads = occurrence( input, source );  // find all the head of a occurrence, return in a queue
    
    // replacement
    if ( T <= S ) {
      return replace_short( input, source, target, heads );
    } else {
      return replace_long( input, source, target, heads );
    }
  }
  
  private Deque< Integer > occurrence( String input, String source ) {
    Deque< Integer > result = new ArrayDeque< Integer >();
    char head = source.charAt(0);
    for ( int i = 0; i <= input.length() - source.length(); i++ ) {
      if ( input.charAt(i) == head ) {
        int index = 0;
        for ( int j = 0; j < source.length(); j++ ) {
          if ( input.charAt(i+j) != source.charAt(j) ) {
            i += j - 1;
            break;
          }
          if ( j >= source.length() - 1 ) {
            result.offerFirst(i);
            i += j;
          }
        }
      }
    }
    return result;
  }
        
  private String replace_short( String input, String source, String target, Deque< Integer > heads ) {
    int end = 0;      // the last char needed + 1
    int current = 0;  // the next char to be inspected
    int S = source.length();
    int T = target.length();
    int count = heads.size();
    // convert to char array
    char[] result = input.toCharArray();
    // do the replacement
    for ( int i = 0; i < count; i++ ) {
      int next = heads.pollLast();
      while ( current < next ) {
        result[end++] = result[current++];
      }
      for ( int j = 0; j < T; j++ ) {
        result[end++] = target.charAt(j);
      }
      current += S;
    }
    while ( current < input.length() ) {
      result[end++] = result[current++];
    }
    //convertback
    return new String( result, 0, end );
  }
  
  private String replace_long( String input, String source, String target, Deque< Integer > heads ) {
    int count = heads.size();    // # of replacements
    int S = source.length();
    int T = target.length();
    int delta = count * ( T - S );
    int end = 0;      // last char needed + 1
    int current = delta;    // last char inspected + 1
    // create char[]
    int len = delta + input.length();
    char[] result = new char[ len ];
    for ( int i = delta; i < len; i++ ) {
      result[i] = input.charAt( i - delta );
    }
    // replacements
    for ( int i = 0; i < count; i++ ) {
      int next = heads.pollLast() + delta;
      while ( current < next ) {
        result[end++] = result[current++];
      }
      for ( int j = 0; j < T; j++ ) {
        result[end++] = target.charAt(j);
      }
      current += S;
    }
    while ( current < len ) {
      result[end++] = result[current++];
    }
    return new String( result );
  }
}