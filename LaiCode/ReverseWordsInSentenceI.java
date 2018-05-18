/*
Reverse the words in a sentence.

Examples

¡°I love Google¡± ¡ú ¡°Google love I¡±
*/

/*
  Time:  O( n ) 
  Space: O( 1 )
*/

public class Solution {
  // input can be null / use char[] to make it in place / word separate by single space / no heading/tailing white space
  public String reverseWords(String input) {
    // base case
    if (input == null || input.length() < 2) {
      return input;
    }
    
    char[] result = input.toCharArray();
    reverseSubString(result, 0, input.length());
    
    int head = 0;
    for (int i = 0; i <= input.length(); i++) {
      if (i == input.length() || result[i] == ' ') {
    		reverseSubString(result, head, i);
        head = i + 1;
      }
    }
    
    return new String( result );
  }
  private void reverseSubString(char[] result, int start, int end) {
    int mid = (end - start) / 2;
    for ( int i = 0; i < mid; i++) {
      swap(result, start + i, end - 1 - i);
    }
  }
  private void swap(char[] a, int i, int j) {
    a[i] ^= a[j];
    a[j] ^= a[i];
    a[i] ^= a[j];
  }
}