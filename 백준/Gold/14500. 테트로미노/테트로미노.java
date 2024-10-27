import java.io.*;
import java.util.*;

public class Main {
    static int[]dx = {0,0,-1,1};
    static int[]dy = {-1,1,0,0};
    static int X,Y;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[Y][X];
        int [][]map = new int[Y][X];
        for(int y = 0; y<Y; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x<X; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        max = -1;
        for(int y = 0; y<Y; y++) {
            for(int x = 0; x<X; x++) {
                dfs(0, x, y, 0, visited, map);
            }
        }
        System.out.println(max);
    }

    static void dfs(int cnt, int x, int y, int depth, boolean[][] visited, int[][]map) {
        if(depth == 4) {
            if(max < cnt) {
                max = cnt;
            }
            return;
        }




        for(int i = 0; i<4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx >= X || ny >= Y) {
                continue;
            }

            if(visited[ny][nx] == true) {
                continue;
            }

            if(depth==2) {
                visited[ny][nx] = true;
                dfs(cnt+ map[ny][nx], x, y, depth+1, visited, map);
                visited[ny][nx] = false;
            }

            visited[ny][nx] = true;
            dfs(cnt+ map[ny][nx], nx, ny, depth+1, visited, map);
            visited[ny][nx] = false;
        }
    }
}