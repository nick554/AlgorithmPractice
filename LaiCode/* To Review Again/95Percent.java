/*
Given a list of integers representing the lengths of urls, find the 95 percentile of all lengths (95% of the urls have lengths <= returned length).

Examples

[1, 2, 3, ..., 95, 96, 97, 98, 99, 100], 95 percentile of all lengths is 95.
*/

/*
  Time:  O( n ) 
  Space: O( 1 )
*/

public class Solution {
  // lengths not null
  public int percentile95(List<Integer> lengths) {
    // bucket sort: # of bucket = 4096+1
    // preprocessing
    int[] buckets = new int[ 4096 + 1];
    for ( int i : lengths ) {
      buckets[i] += 1;
    }
    
    // find the 95%
    int size = lengths.size();
    int cnt = 0;
    for ( int i = 0; i < 4097; i++ ) {
      cnt += buckets[i];
      if ( cnt >= 0.95 * size ) {
        return i;
      }
    }
    return 4096;
  }
}