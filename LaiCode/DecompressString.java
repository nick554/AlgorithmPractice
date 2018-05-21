/*
Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.

Examples

¡°a1c0b2c4¡± ¡ú ¡°abbcccc¡±
*/

/*
  Time:  O( n ) 
  Space: O( 1 )
*/

public class Solution {
  // assumptions: input not null || number >=0;<=9
  public String decompress(String input) {
    // calculate the total number of char in decompressed string
    int delta = findLen( input );    // return the total number
    // create char[]
    char[] result = null;
    if ( delta <= 0 ) {
      result = input.toCharArray();
    } else {
      int len = input.length();
      result = new char[ len + delta ];
      for ( int i = len - 1; i >= 0; i-- ) {
        result[ delta + i ] = input.charAt(i);
      }
    }
    // deal with num <= 2
    int head = delta > 0 ? delta : 0;
    int end = decompressLess( result, head );    // useful part: [0, end)
    // deal with num > 2
    head = decompressMore( result, end ) + 1;  // useful part: [head,length())
    // convert back
    return new String( result, head, result.length - head );
  }
  
  private int findLen( String input ) {
    int len = input.length();
    int result = 0;
    for ( int i = 0; i < len; i++) {
      char current = input.charAt(i);
      int tmp = current - '0';
      if ( tmp >=0 && tmp <= 9 ) {
        result += tmp - 2;
      }
    }
    return result;
  }
  
  private int decompressLess( char[] result, int head ) {
    int end = 0;
    for ( int i = head; i < result.length; i++ ) {
      char current = result[i];
      int tmp = current - '0';
      if ( tmp == 0 ) {
        end--;
      } else if ( tmp != 1 ) {
        result[end++] = result[i];
      }
    }
    return end;
  }
  
  private int decompressMore( char[] result, int end ) {
    int head = result.length - 1;
    for ( int i = end - 1; i >= 0; i-- ) {
      char current = result[i];
      int tmp = current - '0';
      if ( tmp >= 0 && tmp <= 9 ) {
        while ( tmp > 0 ) {
          result[head--] = result[i - 1];
          tmp--;
        }
        i--;
      } else {
        result[head--] = result[i];
      }
    }
    return head;
  }
}