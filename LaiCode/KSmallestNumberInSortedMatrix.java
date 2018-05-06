/*
Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.

Examples

{ {1,  3,   5,  7},

  {2,  4,   8,   9},

  {3,  5, 11, 15},

  {6,  8, 13, 18} }

the 5th smallest number is 4
the 8th smallest number is 6
*/

public class Solution {
  // assumption: N > 0; M > 0; / 0 < k <= M*N
  public int kthSmallest(int[][] matrix, int k) {
    // do best first search for candidates, using a heap to store the candidates
    // using a matrix to store the visited information
    
    int M = matrix.length;
    int N = matrix[0].length;
    boolean[][] visited = new boolean[M][N];
    PriorityQueue< Cell > minHeap = new PriorityQueue<>(2 * k);
    minHeap.offer( new Cell(matrix[0][0],0,0) );
    
    for (int i = 0; i < k - 1; i++) {
      Cell current = minHeap.poll();
      addNew(minHeap, matrix, current, visited);
    }
    return minHeap.poll().getKey();
  }
  private void addNew(PriorityQueue< Cell > pq, int[][] matrix, 
                      Cell current, boolean[][] visited) {
    int m = current.getM();
    int n = current.getN();
    if (visited.length > m + 1 && ! visited[m + 1][n]) {
      pq.offer(new Cell(matrix[m + 1][n], m + 1, n));
      visited[m + 1][n] = true;
    }
    if (visited[0].length > n + 1 && ! visited[m][n + 1]) {
      pq.offer(new Cell(matrix[m][n + 1], m, n + 1));
      visited[m][n + 1] = true;
    }
  }
  class Cell implements Comparable< Cell >{
    private int key;
    private int m;
    private int n;
    public Cell(int key, int m, int n) {
      this.key = key;
      this.m = m;
      this.n = n;
    }
    public int getKey() {
      return key;
    }
    public int getM() {
      return m;
    }
    public int getN() {
      return n;
    }
    @Override
    public int compareTo(Cell b) {
      Integer A = this.key;
      Integer B = b.key;
      return A.compareTo(B);
    }
  }
}