import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        int[][] map = new int[N+1][N+1];

        for(int i = 0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        boolean [] visited = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        int cnt = 0;
        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next = 1; next<N+1; next++) {
                if(map[now][next] == 1) {
                    if(!visited[next]) {
                        q.add(next);
                        cnt++;
                        visited[next] = true;
                    }
                }
            }
        }
        System.out.println(cnt);
	}
}
