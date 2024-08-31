import java.io.*;
import java.util.*;

public class Solution {
    static class Edge implements Comparable<Edge>{
        int to;
        int w;
        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Solution.Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int T = 1; T<=TC; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<Edge>[] graph = new List[V+1];
            Arrays.setAll(graph, i -> new ArrayList<>());

            for(int i = 0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph[a].add(new Edge(b,w));
                graph[b].add(new Edge(a,w));
            }

            boolean[] visited = new boolean[V+1];
            long sum = 0;

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(1,0));

            while(!pq.isEmpty()) {
                Edge edge = pq.poll();
                if(!visited[edge.to]) {
                    visited[edge.to] = true;
                    sum += edge.w;

                    for(Edge e : graph[edge.to]) {
                        if(!visited[e.to]) {
                            pq.offer(e);
                        }
                    }
                }
            }
            
            sb.append("#").append(T).append(" " + sum + "\n");
        }
        System.out.println(sb.toString());
    }
}
