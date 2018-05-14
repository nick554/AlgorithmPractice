/*
Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).

Examples

A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
*/

/*
  Time:  O( n ) 
  Space: O( 1 )
*/

public class Solution {
  // assumption: A,B similiar length/ can use Linkedlist/ if no such number, return {}
  //             can have duplicates/ both list not null
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    // use two pointer to go through both list
    int a = 0;
    int b = 0;
    List<Integer> result = new LinkedList<Integer>();
    
    while (a < A.size() && b < B.size()) {
      if (A.get(a) < B.get(b)) {
        a++;
      } else if (A.get(a) > B.get(b)) {
        b++;
      } else {
        result.add( A.get(a) );
        a++;
        b++;
      }
    }
    return result;
  }
}