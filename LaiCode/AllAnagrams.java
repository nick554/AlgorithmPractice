/*
Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.
*/

/*
  Time:  O( n ) 
  Space: O( 1 )
*/

public class Solution {
  // assumption: s, l not null || can use linkedlist
  public List<Integer> allAnagrams(String s, String l) {
    int ls = s.length();
    int ll = l.length();
    List< Integer > result = new LinkedList< Integer >();
    // corner case:
    if ( ls > ll ) {
      return result;
    }
    // build a map about the frequence of char in s
    Map < Character, Integer > freq = countChar( s );  // use addChar
    
    // form a sliding window
    for ( int i = 0; i < ls; i++ ) {
      removeChar( freq, l.charAt(i) );  // value - 1
    }
    if ( freq.size() == 0 ) {
      result.add( 0 );
    }
    
    // move the sliding window
    int index = ls;
    while ( index < ll ) {
      addChar( freq, l.charAt( index - ls ) );
      removeChar( freq, l.charAt( index ) );
      if ( freq.size() == 0 ) {
        result.add( index - ls + 1 );
      }
      index++;
    }
    
    return result;
  }
  
  private Map < Character, Integer > countChar( String s ) {
    Map < Character, Integer > result = new HashMap<>();
    for ( int i = 0; i < s.length(); i++ ) {
      addChar( result, s.charAt(i) );
    }
    return result;
  }
  
  private void addChar( Map < Character, Integer > map, Character c ) {
    Integer cnt = map.put( c, 1);
    if ( cnt != null) {
      if ( cnt == -1 ) {
        map.remove( c );
      } else {
        map.put( c, cnt + 1 );
      }
    }
  }
  
  private void removeChar( Map < Character, Integer > map, Character c ) {
    Integer cnt = map.put( c, -1 );
    if ( cnt != null) {
      if ( cnt == 1 ) {
        map.remove( c );
      } else {
        map.put( c, cnt - 1 );
      }
    }
  }
}