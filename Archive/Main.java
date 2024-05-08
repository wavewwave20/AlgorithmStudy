package Archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,V;

    static int[][] graph = new int[1001][1001];

    static boolean[] visited = new boolean[1001];

    static Queue<Integer> q = new LinkedList<>();

    static void dfs(int current) {
        if(visited[current]) {
            return;
        }
        System.out.print("" + current + " ");
        visited[current] = true;

        for (int i = 1; i<1001; i++) {
            if(graph[current][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int current = q.poll();
            System.out.print("" + current + " ");

            for (int i = 1; i<1001; i++) {
                if(graph[current][i] == 1) {
                    if (!visited[i]) {
                        visited[i] = true;
                        q.offer(i);
                    }
                }
            }
        }
    }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        for (int i = 0 ; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(V);

        visited = new boolean[1001];
        System.out.println();
        bfs(V);

    }
}