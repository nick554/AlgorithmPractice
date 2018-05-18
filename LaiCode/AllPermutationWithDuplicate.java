/*
Given a string with possible duplicate characters, return a list with all permutations of the characters.

Examples

Set = ¡°abc¡±, all permutations are [¡°abc¡±, ¡°acb¡±, ¡°bac¡±, ¡°bca¡±, ¡°cab¡±, ¡°cba¡±]
Set = "aba", all permutations are ["aab", "aba", "baa"]
Set = "", all permutations are [""]
Set = null, all permutations are []
*/

/*
  Time:  O( n! ) 
  Space: O( n^2 )
*/

public class Solution {
  // use linkedlist / set can be null
  public List<String> permutations(String set) {
    // init result
    List< String > result = new LinkedList< String >();
    
    // corner case
    if (set == null) {
      return result;
    } else if (set == "") {
      result.add( set );
      return result;
    }
    
    // convert set to char[], to make the following process in place
    char[] instance = set.toCharArray();
    int index = 0;
    // start DFS
    permutationHelper(instance, index, result);
    
    return result;
  }
  private void permutationHelper(char[] instance, int index, List< String > result) {
  	// base case
    if (index == instance.length) {
      result.add( new String( instance ) );
      return;
    }
    
    // recursion rule
    Set< Character > used = new HashSet< Character >();
    for (int i = index; i < instance.length; i++) {
      char current = instance[ i ];
      if ( !used.contains( current ) ) {
        swap(instance, i, index);
    		permutationHelper(instance, index + 1, result);
				used.add( current );
        swap(instance, i, index);
      }
    }
  }
  private void swap(char[] a, int i, int j) {
    if (i == j) {
      return;
    }
    a[i] ^= a[j];
    a[j] ^= a[i];
    a[i] ^= a[j];
  }
}