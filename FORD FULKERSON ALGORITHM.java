import java.io.*;
import java.util.*;
public class Main {
    static int V;
    static int[][] capacity;
    static int[][] flow;
    static boolean dfs(int u, int sink, boolean[] visited, int[] parent) {
        visited[u] = true;
        if (u == sink) {
            return true;
        }
        for (int v = 0; v < V; v++) {
            if (!visited[v] && capacity[u][v] - flow[u][v] > 0) {
                parent[v] = u;
                if (dfs(v, sink, visited, parent)) {
                    return true;
                }
            }
        }
        return false;
    }
    static long fordFulkerson(int source, int sink) {
        long maxFlow = 0;
        while (true) {
            boolean[] visited = new boolean[V];
            int[] parent = new int[V];
            Arrays.fill(parent, -1);
            if (!dfs(source, sink, visited, parent)) {
                break;
            }
            long pathFlow = Long.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(
                    pathFlow,
                    (long) capacity[u][v] - flow[u][v]
                );
            }
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                flow[u][v] += pathFlow;
                flow[v][u] -= pathFlow;
            }
            maxFlow += pathFlow;
        }
        return maxFlow;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        capacity = new int[V][V];
        flow = new int[V][V];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            capacity[u][v] += c;
        }
        int source = 0;
        int sink = V - 1;
        System.out.println(fordFulkerson(source, sink));
    }
}
