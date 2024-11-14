import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int index;
        int cost;
        List<Integer> path;
        Node(int index, int cost, List<Integer> path) {
            this.index = index;
            this.cost = cost;
            this.path = new ArrayList<>(path);
            this.path.add(index);
        }
        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Node>> map = new ArrayList<>();
        for(int i = 0; i<=n; i++) {
            map.add(new ArrayList<>());
        }

        for(int i = 0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map.get(s).add(new Node(e, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(start, 0, new ArrayList<>()));
        dist[start] = 0;

        PriorityQueue<Node> shortestPath = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(dist[now.index] < now.cost) {
                continue;
            }

            if(now.index == end) {
                shortestPath.add(now);
            }

            for(Node next : map.get(now.index)) {

                if(dist[next.index] > next.cost + dist[now.index]) {
                    dist[next.index] = next.cost + dist[now.index];
                    pq.add(new Node(next.index, dist[next.index], now.path));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append("\n");
        sb.append(shortestPath.peek().path.size()).append("\n");
        
        for(int i : shortestPath.peek().path) {
            sb.append(i + " ");
        }
        System.out.println(sb.toString());

    }
}