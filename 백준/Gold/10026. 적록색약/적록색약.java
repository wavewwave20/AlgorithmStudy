import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
    char c;

    Point(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean [N][N];
        char[][]map = new char[N][N];

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        Queue<Point> q = new LinkedList<>();

        for(int x = 0; x<N; x++) {
            String line = br.readLine().trim();
            for(int y = 0; y<N; y++) {
                map[y][x] = line.charAt(y);
            }
        }

        int colorWeakCnt = 0;
        for(int x = 0; x<N; x++) {
            for(int y = 0; y<N; y++) {

                if(visited[y][x] == false) {
                    q.add(new Point(x, y, map[y][x]));
                    colorWeakCnt++;
                }

                while(!(q.isEmpty())) {
                    Point point = q.poll();
                    int xx = point.x;
                    int yy = point.y;
                    char c = point.c;
                    
                    
                    for(int i= 0; i<4; i++) {
                        int nx = xx + dx[i];
                        int ny = yy + dy[i];

                        if(nx<0|| ny<0|| nx>=N|| ny>=N) {
                            continue;
                        }
                        if(!visited[ny][nx] && c == map[ny][nx]) {
                            q.add(new Point(nx, ny, c));
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
        }


        for(int x = 0; x<N; x++) {
            for(int y = 0; y<N; y++) {
                if(map[y][x] == 'R') {
                    map[y][x] = 'G';
                }
            }
        }
        visited = new boolean[N][N];
        int colorCnt = 0;
        
        for(int x = 0; x<N; x++) {
            for(int y = 0; y<N; y++) {

                if(visited[y][x] == false) {
                    q.add(new Point(x, y, map[y][x]));
                    colorCnt++;
                }

                while(!(q.isEmpty())) {
                    Point point = q.poll();
                    int xx = point.x;
                    int yy = point.y;
                    char c = point.c;
                    
                    
                    for(int i= 0; i<4; i++) {
                        int nx = xx + dx[i];
                        int ny = yy + dy[i];

                        if(nx<0|| ny<0|| nx>=N|| ny>=N) {
                            continue;
                        }
                        if(!visited[ny][nx] && c == map[ny][nx]) {
                            q.add(new Point(nx, ny, c));
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
        }

        System.out.println(""+ colorWeakCnt + " " + colorCnt);


    }
}