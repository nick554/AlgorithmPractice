/*
Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.

A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
*/

// solution 1 using maxheap
public class Solution {
  // assumption: array not null/ 0 <= k < length
  public int[] kSmallest(int[] array, int k) {
    // initialize result
    int[] result = new int[k];
    
    PriorityQueue< Integer > MaxHeap = new PriorityQueue< Integer >(k+1,
            new Comparator<Integer>() {
      				  public int compare(Integer a, Integer b) {
                  return -a.compareTo(b);
                }
            });
    for (int i = 0; i < k; i++) {
      MaxHeap.add( array[i] );
    }
    for (int i = k; i < array.length; i++) {
      MaxHeap.add( array[i] );
      MaxHeap.remove();
    }
    
    for (int i = k-1; i >= 0; i--) {
      result[i] = MaxHeap.remove();
    }
    
    return result;
  }
}

