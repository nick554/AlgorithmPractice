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

// solution 2 using quickselect
public class Solution {
  public int[] kSmallest(int[] array, int k) {
    // assumption: array not null/ 0 <= k < length
    // corner case
    if (array.length == 1) {
      return k == 1? array : new int[0];
    }
    
    quickSelect( array, k, 0, array.length);
    
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = array[i];
    }
    return result;
  }
  private void quickSelect(int[] array, int k, int start, int end) {
    // base case
    if (end <= start + 1) {
      return;
    }
    
    // choose a pivot
    int tmp = (int)(Math.random() * (end - start)) + start;
    swap(array, tmp, start);
    int pivot = array[ start ];
    int left = start + 1;
    
    // partition
    for (int i = left; i < end; i++) {
      int temp = array[i];
      if (temp < pivot) {
        swap(array, left++, i);
      }
    }
    swap(array, left - 1, start);
    
    // recursion
    if (left < k) {
      quickSelect(array, k, left, end);
    }
    quickSelect(array, k, start, left - 1);
  }
  private void swap(int[] a, int i, int j) {
    if (i != j) {
      a[i] ^= a[j];
      a[j] ^= a[i];
      a[i] ^= a[j];
    }
  }
}