/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    
    Map<GraphNode, Integer> visited = new HashMap<>();

    for (GraphNode node : graph) {
      if (!BFS(node, visited)) {
        return false;
      }
    }
    return true;
  }

  private boolean BFS(GraphNode node, Map<GraphNode, Integer> visited) {
    if (visited.containsKey(node)) {
      return true;
    }

    Queue<GraphNode> queue = new LinkedList<>();
    queue.offer(node);
    visited.put(node, 0);

    while (!queue.isEmpty()) {
      GraphNode cur = queue.poll();

      int curGroup = visited.get(cur);
      int neiGroup = curGroup == 0 ? 1 : 0;

      for (GraphNode nei : cur.neighbors) {
        if (!visited.containsKey(nei)) {
          visited.put(nei, neiGroup);
          queue.offer(nei);
        } else if (visited.get(nei) != neiGroup) {
          return false;
        }
      }
    }

    return true;
  }
}

/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    if (graph == null || graph.length == 0) {
      return true;
    }
    
    Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < graph.length; i++) {
      if (graph[i].length == 0) {
        continue;
      }
      
      if (visited.contains(i)) {
        continue;
      }
      
      if (!bfs(i, visited, graph)) {
        return false;
      }
    }
    
    return true;
  }

  private boolean bfs(int index, Set<Integer> visited, int[][] graph) {
    Queue<Integer> q = new LinkedList<>();
    Set<Integer> groupA = new HashSet<>();
    Set<Integer> groupB = new HashSet<>();
    
    q.offer(index);
    visited.add(index);
    groupA.add(index);
    boolean isGroupA = false;
    
    while (!q.isEmpty()) {
      int size = q.size();
      
      for (int i = 0; i < size; i++) {
        int node = q.poll();
        
        int len = graph[node].length;
        for (int j = 0; j < len; j++) {
          int neighbor = graph[node][j];
          
          if (!isGroupA) {
            if (groupA.contains(neighbor)) {
              return false;
            }
            
            groupB.add(neighbor);
          } else {
            if (groupB.contains(neighbor)) {
              return false;
            }
            
            groupA.add(neighbor);
          }
          
          if (visited.contains(neighbor)) {
            continue;
          }
          
          q.offer(neighbor);
          visited.add(neighbor);
        } 
      }
      
      isGroupA = !isGroupA;
    }
    
    return true;
  }
}
