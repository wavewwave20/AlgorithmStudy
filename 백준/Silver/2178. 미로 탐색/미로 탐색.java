import java.util.*;
import java.io.*;

class Main {
    static int N,M;

    static int[] dx = {1,-1, 0, 0};
    static int[] dy = {0,0,1,-1};

    static int bfs(int[][] graph, boolean[][] visited) {
        Queue<Integer[]> q = new LinkedList<>();
        visited[1][1] = true;
        Integer[] start = {1,1,1};
        q.offer(start);

        while (!q.isEmpty()){
            Integer[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int cnt = current[2];

            if(x == M && y == N) {
                return cnt;
            }
            
            for (int i = 0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
    
                if (graph[ny][nx] == 1 && !visited[ny][nx]) {
                    Integer[] next = {nx,ny,cnt+1};
                    
                    q.offer(next);
                    visited[ny][nx] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+2][M+2];
        boolean[][] visited = new boolean[N+2][M+2];

        for (int i = 0; i< N; i++) {
            String line = br.readLine();
            for (int j = 0; j<M; j++) {
                graph[i+1][j+1] = line.charAt(j) -'0';
            }
        }

        System.out.println("" + bfs(graph,visited));
    }
}