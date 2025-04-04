package graphs;

import java.util.Arrays;
import java.util.List;

public class DFS {

    public static void main(String[] args) {
        List<List<Integer>> adj = Arrays.asList(
                List.of(),
                Arrays.asList(2,3),
                Arrays.asList(1,5,6),
                Arrays.asList(1,4,7),
                Arrays.asList(3,8),
                List.of(),
                List.of(),
                Arrays.asList(3,8),
                Arrays.asList(4,7)
        );
        boolean[] visited = new boolean[adj.size()];
        depthFirstSearch(adj, 3, visited);
    }

    private static void depthFirstSearch(List<List<Integer>> adj, int start, boolean[] visited) {
        if(visited[start]) {
            return;
        }

        System.out.println(start);
        visited[start] = true;
        for(int n : adj.get(start)) {
            depthFirstSearch(adj, n, visited);
        }
    }
}
