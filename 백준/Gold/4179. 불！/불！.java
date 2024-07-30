import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
    int d;

    Point(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
    Point(int x, int y) {
        this.x = x;
        this.y = y;
        d = 0;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int []dx = {0,0,-1,1};
        int []dy = {1,-1,0,0};

        Queue <Point> fireQ  = new LinkedList<>();
        Queue <Point> jhQ  = new LinkedList<>();

        ArrayList<Integer> escapeList = new ArrayList<>();

        char[][] map = new char[R][C];

        for(int y = 0; y<R; y++) {

            String str = br.readLine().strip();

            for(int x = 0; x<C; x++) {
                char mapData = str.charAt(x);
                
                if(mapData == 'J') {
                    map[y][x] = '.';
                    jhQ.add(new Point(x, y,0));
                }else if(mapData == 'F') {
                    fireQ.add(new Point(x, y, 0));
                    map[y][x] = mapData;
                }else {
                    map[y][x] = mapData;
                }
            }
        }

        int[][] timeMap = new int[R][C];
        boolean[][] visited = new boolean[R][C];

        for(int y = 0; y< R; y++) {
            for(int x = 0; x< C; x++) {
                if(map[y][x] == '#') {
                    timeMap[y][x] = -1;
                }else if(map[y][x] == 'F'){
                    timeMap[y][x] = 0;
                }else {
                    timeMap[y][x] = Integer.MAX_VALUE;
                }
                
            }
        }

        while(!(fireQ.isEmpty())) {
            Point point = fireQ.poll();
            int x = point.x;
            int y = point.y;
            int d = point.d;

            for(int i = 0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0 || ny<0 || nx>=C|| ny>=R) {
                    continue;
                }

                if(map[ny][nx] == '.' && visited[ny][nx] == false) {
                    fireQ.add(new Point(nx, ny, d + 1));
                    timeMap[ny][nx] = d + 1;
                    visited[ny][nx] = true;
                }
            }
        }

        visited = new boolean[R][C];

        while(!(jhQ.isEmpty())) {
            Point point = jhQ.poll();
            int x = point.x;
            int y = point.y;
            int d = point.d;

            for(int i = 0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0 || ny<0 || nx>=C|| ny>=R) {
                    escapeList.add(d+1);
                    continue;
                }

                if(timeMap[ny][nx] > d + 1 && visited[ny][nx] == false) {
                    jhQ.add(new Point(nx, ny, d + 1));
                    visited[ny][nx] = true;
                }
            }
        }



        if(escapeList.isEmpty()) {
            System.out.println("IMPOSSIBLE");
        }else {
            Collections.sort(escapeList);
            System.out.println(escapeList.get(0));
        }

    }
}