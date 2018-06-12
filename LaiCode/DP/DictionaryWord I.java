/*
Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.

Examples

Dictionary: {¡°bob¡±, ¡°cat¡±, ¡°rob¡±}

Word: ¡°robob¡± return false

Word: ¡°robcatbob¡± return true since it can be composed by "rob", "cat", "bob"
*/

/*
  Time:  O( <n^2 ) 
  Space: O( n )
*/

public class Solution {
  public boolean canBreak(String input, String[] dict) {
    List< Integer > dp = new ArrayList< Integer >();  // Integer inside means the input before the index return ture;
    // use tri tree or hashset
    Set< String > dictionary = convert( dict );
    if ( dictionary.contains( input ) ) {
      return true;
    }
    
    // dp process
    for ( int i = 0; i < input.length() - 1; i++ ) {
      String sub = input.substring( 0, i + 1 );
      if ( dictionary.contains( sub ) ) {
        dp.add( i );
        continue;
      }
      boolean canBreakPart = false;
      for ( Integer index : dp ) {
        sub = input.substring( index + 1, i + 1 );
        if ( dictionary.contains( sub ) ) {
          canBreakPart = true;
          dp.add( i );
          break;
        }
      }
    }
    for ( Integer index : dp ) {
      String sub = input.substring( index + 1, input.length() );
      if ( dictionary.contains( sub ) ) {
        return true;
      }
    }

    return false;
  }
  
  private Set< String > convert( String[] dict ) {
    Set< String > result = new HashSet< String >();
    for ( String word : dict ) {
      result.add( word );
    }
    return result;
  }
}