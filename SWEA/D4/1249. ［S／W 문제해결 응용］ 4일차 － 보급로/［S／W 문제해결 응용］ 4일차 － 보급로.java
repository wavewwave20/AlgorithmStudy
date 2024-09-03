import java.util.*;
import java.io.*;
public class Solution {
    static int N;
    static int [][]map;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int T = 1; T<=tc ; T++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int y = 0; y<N; y++){
                char[] ch = br.readLine().toCharArray();
                for(int x = 0; x<N; x++){
                    map[y][x] = ch[x] - '0';
                }
            }
            System.out.println("#" + T + " " + getMinTime(0,0, N-1, N-1));

        }
    }
    
    static int getMinTime(int sx, int sy, int ex, int ey) {
        final int INF = Integer.MAX_VALUE;
        boolean [][]visited = new boolean[N][N];
        int [][]minTime = new int[N][N];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2],o2[2])); // {x, y, time} 시간기준 최소힙
        for(int y = 0; y<N; y++) {
            Arrays.fill(minTime[y], INF);
        }

        minTime[sy][sx] = 0;
        pq.offer(new int[] {sx, sy, minTime[sy][sx]});

        while(!pq.isEmpty()) {
            int[] stopOver = pq.poll();
            int x = stopOver[0];
            int y = stopOver[1];
            int time = stopOver[2];

            if(visited[y][x]) continue;
            visited[y][x] = true;

            if(x == ex && y == ey) return time; // return minTime[ey][ex];

            for(int d = 0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if(!visited[ny][nx] && minTime[ny][nx] > time + map[ny][nx]) {
                    minTime[ny][nx] = time + map[ny][nx];
                    pq.offer(new int[] {nx, ny, minTime[ny][nx]});
                }
            }
        }
        return -1;
    }
}
