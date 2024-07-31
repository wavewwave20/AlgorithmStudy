import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    int d;
    Point(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        int []dx = {0,0,-1,1};
        int []dy = {1,-1,0,0};

        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc < testCase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            Queue<Point> fireQ = new LinkedList<>();
            Queue<Point> playerQ = new LinkedList<>();

            char[][] map = new char[Y][X];
            int[][] timeMap = new int[Y][X];
            boolean[][] visited = new boolean[Y][X];
            boolean[][] fVisited = new boolean[Y][X];
            
            for(int y = 0; y<Y; y++) {
                String line = br.readLine();
                for(int x= 0; x<X; x++) {
                    char e = line.charAt(x);

                    if(e == '@') {
                        map[y][x] = '.';
                        playerQ.add(new Point(x, y, 0));
                        visited[y][x] = true;
                    }else if (e == '*') {
                        map[y][x] = e;
                        fireQ.add(new Point(x, y, 0));
                        fVisited[y][x] = true;
                    }else if(e == '.'){
                        map[y][x] = e;
                        timeMap[y][x] = Integer.MAX_VALUE;
                    }else {
                        map[y][x] = e;
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

                    if(nx<0|| ny<0|| nx>=X|| ny>=Y) {
                        continue;
                    }
                    if(fVisited[ny][nx] == false && map[ny][nx] == '.') {
                        fireQ.add(new Point(nx, ny, d+1));
                        timeMap[ny][nx] = d + 1;
                        fVisited[ny][nx] = true;
                    }
                }
            }

            boolean escapeFlag = false;
            int escapeTime = 0;
            while(!(playerQ.isEmpty())) {
                Point point = playerQ.poll();
                int x = point.x;
                int y = point.y;
                int d = point.d;
                
                for(int i = 0; i<4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx<0|| ny<0|| nx>=X|| ny>=Y) {
                        escapeFlag = true;
                        escapeTime = d+1;
                        break;
                    }
                    if(visited[ny][nx] == false && map[ny][nx] == '.' && timeMap[ny][nx] > d+1) {
                        playerQ.add(new Point(nx, ny, d+1));
                        visited[ny][nx] = true;
                    }
                }

                if(escapeFlag) {
                    break;
                }
            }

            if(escapeFlag) {
                sb.append("" + escapeTime+"\n");
            }else {
                sb.append("IMPOSSIBLE\n");
            }
        }

        System.out.println(sb.toString());
        
    }
}