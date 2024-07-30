
import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int []dx = {1,-1,0,0};
        int []dy = {0,0,1,-1};
        StringBuilder sb = new StringBuilder();

        for(int testCase = 0; testCase < tc; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
        
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][M];
            Queue<Point> q = new LinkedList<>();

            for(int i = 0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            boolean[][] visited = new boolean[N][M];
            int wormCnt = 0;

            for(int y = 0; y<N; y++) {
                for(int x = 0; x<M; x++) {
                    if(!visited[y][x] && map[y][x] == 1) {
                        wormCnt++;
                        q.add(new Point(x, y));
                        visited[y][x] = true;
                        while(!(q.isEmpty())) {
                            Point point = q.poll();

                            int xx = point.x;
                            int yy = point.y;

                            for(int i = 0; i<4; i++) {
                                int nx = xx + dx[i];
                                int ny = yy + dy[i];

                                if(nx <0 || ny<0|| nx>=M || ny >=N) {
                                    continue;
                                }

                                if(!visited[ny][nx] && map[ny][nx] == 1) {
                                    q.add(new Point(nx, ny));
                                    visited[ny][nx] = true;
                                }
                            }

                        }
                    }
                }
            }

            sb.append(wormCnt + "\n");
        }
        System.out.println(sb.toString());

    }   
}