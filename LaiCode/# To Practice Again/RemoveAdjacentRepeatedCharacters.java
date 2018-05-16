/*
Repeatedly remove all adjacent, repeated characters in a given string from left to right.

No adjacent characters should be identified in the final string.

Examples

"abbbaaccz" → "aaaccz" → "ccz" → "z"
"aabccdc" → "bccdc" → "bdc"
*/

/*
Time: o( n )
Space: o( 1 )
*/

public class Solution {
  public String deDup(String input) {
    // use left part of array as a stack to store the used item
    // corner case
    if (input == null || input.length() < 2) {
      return input;
    }
    
    // use char array
    char[] stack = input.toCharArray();
    
    int end = 1;	// to the left (exclude) == current result
		for (int i = 1; i < input.length(); i++) {
      if (end == 0 || stack[i] != stack[end - 1]) {
        stack[end++] = stack[i];
      } else {
        char curr = stack[end - 1];
        while (i + 1 < input.length() && stack[i] == stack[i + 1]) {
          i++;
        }
        end--;
      }
    }
    
    // convert char array to string
    return new String(stack, 0, end);
  }
}
