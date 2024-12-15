import java.io.*;
import java.util.*;

public class Main {
    static int[] DX = {-1,1,0,0};
    static int[] DY = {0,0,-1,1};

    static int N;
    
    static class MapMemory {
        int[][] map;
        int max;
        int cnt;

        MapMemory(int[][]map, int max, int cnt) {
            this.map = map;
            this.max = max;
            this.cnt = cnt;
        }
    }
    
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        int [][]map = new int[N][N];

        for(int y = 0; y<N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x = 0; x<N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<MapMemory> queue = new ArrayDeque<>();
        queue.add(new MapMemory(map, findMax(map), 0));

        //bfs
        int max = 0;
        while(!queue.isEmpty()) {
            MapMemory now = queue.poll();

            if(now.cnt == 5) {
                //max 갱신
                if(max < now.max) {
                    max = now.max;
                }
                continue;
            }

            for(int i = 0; i<4; i++) {
                //압축
                int[][]newMap = compression(i, now.map);
                int tmpMax = findMax(newMap);

                
                // for(int y = 0; y<N; y++) {
                //     for(int x = 0; x<N; x++) {
                //         System.out.print(newMap[y][x]);
                //     }
                //     System.out.println();
                // }
                // System.out.println("========");

                // 최댓값을 구해 cnt를 올리고 memory로 저장
                queue.add(new MapMemory(newMap, tmpMax, now.cnt+1));
            }

            
                
            

        }
        System.out.println(max);
    }

    static int[][] compression(int direction, int[][]map) {
        int[][] newMap = new int[N][N];
        int curX, curY;

        for(int i =0; i<N; i++) {
            ArrayDeque<int[]> deque = new ArrayDeque<>();
            for(int j = 0; j<N; j++) {
                if(direction<2) {
                    //아래,위
                    curX = i;
                    curY = (direction == 1) ? j : (N-1-j);
                }else {
                    //오,왼
                    curX = (direction == 3) ? j : (N-1-j);
                    curY = i; 
                }

                if(map[curY][curX] == 0) {
                    continue;
                }                
                if(deque.isEmpty()) {
                    //int[]{값, 0 == 합쳐진적 없음}
                    deque.addFirst(new int[]{map[curY][curX], 0});
                }else {
                    // deque에 합쳐서 넣기
                    if(deque.peekFirst()[1] == 0 && deque.peekFirst()[0] == map[curY][curX]) {
                        deque.pollFirst();
                        deque.addFirst(new int[]{map[curY][curX] * 2, 1});
                    }else {
                        deque.addFirst(new int[]{map[curY][curX], 0});
                    }
                }
            }
            //맵에 배치
            for(int j = 0; j<N; j++) {
                if(direction<2) {
                    //아래,위
                    curX = i;
                    curY = (direction == 1) ? j : (N-1-j);
                }else {
                    //오,왼
                    curX = (direction == 3) ? j : (N-1-j);
                    curY = i; 
                }

                if(deque.isEmpty()) {
                    break;
                } 
                newMap[curY][curX] = deque.pollLast()[0];
            }
        }
        return newMap;
    }

    //map의 최대값을 구하는 메서드
    static int findMax(int[][]map) {
        int max = 0;
        for(int y = 0; y<N; y++) {
            for(int x = 0; x<N; x++) {
                if(max < map[y][x]) {
                    max = map[y][x];
                }
            }
        }
        return max;
    }
}