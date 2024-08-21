import java.io.*;
import java.util.*;

//좌표와 방향을 저장하는 클래스
class Point2 {
    int x;
    int y;
    int d;
    public Point2(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main {
    static int[]dx = {0,1,0,-1};
    static int[]dy = {1,0,-1,0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int y = 0; y<N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x<M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = rotateRtimes(R, map);

        for(int y = 0; y<N; y++) {
            for(int x = 0; x<M; x++) {
                System.out.print(result[y][x] + " ");
            }
            System.out.println();
        }

    }

    //회전을 R번 반복시키는 메서드
    static int[][] rotateRtimes(int R, int[][]map) {
        int N = map.length;
        int M = map[0].length;

        //1번 반복
        int[][] newMap = rotate(map, new int[N][M], N, M);

        //2번이상시
        for(int i = 1; i<R; i++) {
            newMap = rotate(newMap, new int[N][M], N, M);

        }
        return newMap;
    }

    //배열 전체에 회전을 적용하는 메서드
    static int[][] rotate(int[][]map, int[][]newMap, int N, int M) {
        //시작점, 회전 전 위치, 회전 후 위치의 저장부
        Point2 now = new Point2(0, 0, 0);
        Point2 start = new Point2(1, 0, 0);
        Point2 prev = new Point2(1, 0, 0);

        while(true) {
            //한 겹에 대해서 회전
            nextMap(start, now, prev, map, newMap, N, M);
            //안쪽 겹에 대한 회전
            now.x = now.x + 1;
            now.y = now.y + 1;
            prev.x = now.x+1;
            prev.y = now.y;
            start.x = now.x+1;
            start.y = now.y;
            //모든 회전을 마친경우 리턴
            if(newMap[now.y][now.x] != 0) {
                return newMap;
            }
        }
    }

    //한칸 회전을 담당하는 재귀함수
    static void nextMap(Point2 start, Point2 now, Point2 prev, int[][]map, int[][]newMap, int N, int M) {
        //먼저 회전하고 시작
        newMap[now.y][now.x] = map[prev.y][prev.x];
        
        //기저 조건, start위치에 도달할 경우
        if(now.x == start.x && now.y == start.y) {
            return;
        }
        
        int nx = now.x + dx[now.d];
        int ny = now.y + dy[now.d];
        int nd = now.d;
        
        //바깥으로 나가려고 할경우 방향바꾸기
        if(nx<0 || ny<0 || nx>=M || ny >= N) {
            nd = (nd+1)%4;
            nx = now.x + dx[nd];
            ny = now.y + dy[nd];
        }
        
        //이미 값이 들어있는 경우 방향 바꾸기
        if(newMap[ny][nx] != 0) {
            nd = (nd+1)%4;
            nx = now.x + dx[nd];
            ny = now.y + dy[nd];
        }
        //재귀
        Point2 next = new Point2(nx, ny, nd);
        nextMap(start, next, now, map, newMap, N, M);
    }
}