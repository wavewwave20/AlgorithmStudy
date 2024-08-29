import java.util.*;
import java.io.*;

public class Solution {
    static int []parents;
    static int V, E;

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        
        for(int T = 1; T<=tc ; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Edge> queue = new PriorityQueue<>();

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            
            for(int i = 0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                queue.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken())));
            }
            
            make();

            int cnt = 0; 
            long cost = 0;

            while(!queue.isEmpty()) {
                Edge edge = queue.poll();
                if(union(edge.from, edge.to)) {
                    cost += (long)edge.v;
                    if(++cnt >= V-1) break;
                }
            }

            sb.append("#").append(T + " ").append(cost).append("\n");
        }
        System.out.println(sb.toString());

    }

    static void make() {
        parents = new int[V+1];
        Arrays.fill(parents, -1);
    }

    static int findSet(int a) {
        if(parents[a] < 0) return a;

        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        if(a == b) return false;

        parents[a] += parents[b];
        parents[b] = a;
        return true;
    }

    static class Edge implements Comparable<Edge>{
        int from,to;
        long v;

        public Edge(int from, int to, long v) {
            this.from = from;
            this.to = to;
            this.v = v;
        }

        @Override
        public int compareTo(Solution.Edge o) {
            return Long.compare(this.v, o.v);
        }
    }
}