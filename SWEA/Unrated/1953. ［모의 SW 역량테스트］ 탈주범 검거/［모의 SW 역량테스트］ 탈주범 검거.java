import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    int d;
    Point(int x, int y,int d) {
        this.x = x;
        this.y = y;
        this.d =d;
    }
}

public class Solution {
    static int []dx = {0,0,-1,1};//상0 하1 좌2 우3
    static int []dy = {-1,1,0,0};

    static int [][]outType = {{},{0,1,2,3},{0,1},{2,3},{0,3},{1,3},{1,2},{0,2}};
    static int [][]inType = {{},{0,1,2,3},{0,1},{2,3},{1,2},{0,2},{0,3},{1,3}};
    static int [][]map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
 
        for(int tc = 0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int Y = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int mY = Integer.parseInt(st.nextToken());
            int mX = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            map = new int[Y][X];

            for(int y = 0; y<Y; y++) {
                st = new StringTokenizer(br.readLine());
                for(int x = 0; x<X; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }
            
            Queue<Point> queue = new ArrayDeque<>();

            boolean[][]visited = new boolean[Y][X];

            queue.add(new Point(mX, mY , 1));
            visited[mY][mX] = true;
            
            while (!(queue.isEmpty())) {
                Point point = queue.poll();
                int x = point.x;
                int y = point.y;
                int d = point.d;

                if(d == L) {
                    continue;
                }

                for(int i : outType[map[y][x]]) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx <0 || ny <0 || nx>=X || ny>=Y) {
                        continue;
                    }


                    for(int j: inType[map[ny][nx]]) {
                        if(i == j && !visited[ny][nx]) {
                            visited[ny][nx] = true;
                            queue.add(new Point(nx, ny, d+1));
                        }
                    }

                    
                }
            }

            int count = 0;
            for(int y = 0; y<Y; y++) {
                for(int x = 0; x<X; x++) {
                    if(visited[y][x]) {
                        count++;
                    }
                }
            }
            sb.append("#" + (tc+1) + " " + count + "\n");

        }
        System.out.println(sb.toString());
    }
}