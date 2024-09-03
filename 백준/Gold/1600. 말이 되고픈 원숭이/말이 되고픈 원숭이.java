import java.io.*;
import java.util.*;

public class Main {
    static int []dx = {1,-1,0,0};
    static int []dy = {0,0,-1,1};
    static int []hdx = {1,1,2,2,-1,-1,-2,-2};
    static int []hdy = {-2,2,-1,1,-2,2,1,-1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        
        int [][][]visited = new int[k+1][Y][X];
        int [][] map = new int[Y][X];

        for(int y = 0; y<Y; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < X; x++) {
                int n = Integer.parseInt(st.nextToken());
                map[y][x] = n;
            }
        }

        for(int i = 0; i<visited.length; i++) {
            for(int j = 0; j<visited[0].length; j++) {
                for(int t = 0; t<visited[0][0].length; t++) {
                    visited[i][j][t] = Integer.MAX_VALUE;
                }
            }
        }


        Queue<Point> queue = new ArrayDeque<>();

        queue.offer(new Point(0, 0, 0));

        int minMove = Integer.MAX_VALUE;
        visited[0][0][0] =1;

        while(!queue.isEmpty()) {

            Point now = queue.poll();

            int x = now.x;
            int y = now.y;
            int jumped = now.jumped;
            int dist = visited[jumped][y][x];

            if(x == X-1 && y== Y-1) {
                if(dist< minMove) {
                    minMove = dist;
                }
                break;
            }

            for(int i = 0; i<4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || ny<0|| nx>=X||ny>=Y) {
                    continue;
                }

                if(visited[jumped][ny][nx] > dist+1 && map[ny][nx] == 0 ) {
                    visited[jumped][ny][nx] = dist+1;
                    queue.offer(new Point(nx, ny, jumped));
                }
            }

            if(jumped<k) {
                for(int i = 0; i<8 ; i++) {
                    int nx = x + hdx[i];
                    int ny = y + hdy[i];
                    if(nx<0 || ny<0|| nx>=X||ny>=Y) {
                        continue;
                    }
    
                    if(visited[jumped+1][ny][nx] > dist+1 && map[ny][nx] == 0 ) {
                        visited[jumped+1][ny][nx] = dist+1;
                        queue.offer(new Point(nx, ny, jumped+1));
                    }
                }
            }
        }
        if(minMove == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(minMove-1);
        }
    }
    
    static class Point {
        int x;
        int y;
        int jumped;

        public Point(int x, int y, int jumped) {
            this.x = x;
            this.y = y;
            this.jumped = jumped;
        }    
    }

}