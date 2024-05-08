import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> graph[];
    static boolean visited[];

    static String dfsRoute = "";
    static String bfsRoute = "";

    static Queue<Integer> queue;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[n+1];
        queue = new LinkedList<>();

        for(int i = 0; i<n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
            Collections.sort(graph[a]);
            Collections.sort(graph[b]);
        }
        

        visited = new boolean[n+1];
        DFS(v);
        

        visited = new boolean[n+1];
        BFS(v);
        

        bw.write(dfsRoute + "\n");
        bw.write(bfsRoute + "\n");
        bw.flush();
        bw.close();
    
    }

    static void DFS(int now) {
        if(visited[now] == false) {
            visited[now] = true;
                dfsRoute = dfsRoute + now + " ";
            for(int next : graph[now]) {
                
                DFS(next);
            }
        }
    }

    static void BFS(int start) {
        visited[start] = true;
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            bfsRoute = bfsRoute + now + " ";
            for(int next : graph[now]) {
                if(visited[next] == false) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}