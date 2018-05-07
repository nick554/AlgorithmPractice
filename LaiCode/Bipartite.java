/*
Determine if an undirected graph is bipartite. A bipartite graph is one in which the nodes can be divided into two groups such that no nodes have direct edges to other nodes in the same group.

Examples

1  --   2

    /   

3  --   4

is bipartite (1, 3 in group 1 and 2, 4 in group 2).

1  --   2

    /   |

3  --   4

is not bipartite.
*/

/*
public class GraphNode {
  public int key;
  public List<GraphNode> neighbors;
  public GraphNode(int key) {
    this.key = key;
    this.neighbors = new ArrayList<GraphNode>();
  }
}
*/

/*
  Time:  O( n ) 
  Space: O( n )
*/

public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    // use the dfs method to go through the graph, divide nodes into two graph
    // use a HashMap to put the visited nodes into two groups
    HashMap<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();
    
    for (GraphNode head : graph) {
      if ( visited.containsKey( head ) ) {
        continue;
      }
      visited.put( head, 1);
      
      if ( ! expand(head, visited, 2) ) {
        return false;
      }
    }
    
    return true;
  }
  private boolean expand(GraphNode head, HashMap<GraphNode, Integer> visited, int group) {
    // group = the group number of head's neighbors
    // expand node head
    for (GraphNode current : head.neighbors) {
      if ( visited.containsKey( current ) ) {
        if ( visited.get( current ) == group ) {
          continue;
        } else {
          return false;
        }
      }
      visited.put(current, group);
      // continue expansion and return if not bipartite
      if ( ! expand(current, visited, 3 - group) ) {
        return false;
      }
    }
    return true;
  }
}