import java.util.*;
import java.io.*;


class Point {
    int x;
    int y;
    int z;
    int d;
    Point(int x, int y, int z, int d) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.d = d;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        int[] dx = {0,0,1,-1,0,0};
        int[] dy = {1,-1,0,0,0,0};
        int[] dz = {0,0,0,0,1,-1};

        int[][][] map = new int[Z][Y][X];
        boolean[][][] visited = new boolean[Z][Y][X];
        Queue<Point> q = new LinkedList<>();
        
        for(int z = 0; z<Z; z++){
            for(int y = 0; y<Y; y++){
                st = new StringTokenizer(br.readLine());
                for(int x = 0; x<X; x++){
                    map[z][y][x] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int days = 0;
        for(int z = 0; z<Z; z++){
            for(int y = 0; y<Y; y++){
                for(int x = 0; x<X; x++){
                    if(visited[z][y][x] == false && map[z][y][x] == 1) {
                        q.add(new Point(x, y, z, 0));
                        visited[z][y][x] = true;
                    }
                }
            }
        }

        while(!(q.isEmpty())) {
            Point point = q.poll();
            int xx = point.x;
            int yy = point.y;
            int zz = point.z;
            int d = point.d;

            for(int i = 0; i<6; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];
                int nz = zz + dz[i];

                if(nx<0|| ny<0||nz<0||nx>=X||ny>=Y||nz>=Z) {
                    continue;
                }

                if(visited[nz][ny][nx] == false && map[nz][ny][nx] == 0) {
                    q.add(new Point(nx, ny, nz, d + 1));
                    visited[nz][ny][nx] = true;
                    map[nz][ny][nx] = 1;
                    days = d+1 > days ? d+1:days;
                }
            }
        }


        boolean flag = true;
        for(int z = 0; z<Z; z++){
            for(int y = 0; y<Y; y++){
                for(int x = 0; x<X; x++){
                    if(map[z][y][x] == 0) {
                        flag = false;
                        break;
                    }
                }
            }
        }
        if(flag) {
            System.out.println(days);
        }else {
            System.out.println(-1);
        }
    }
}