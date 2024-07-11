import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] graph = new int[Y][X];
        int[][] difussion = new int[Y][X];
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        ArrayList<Integer> airCleaner = new ArrayList<>();
        

        for (int i = 0; i<Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j =0; j<X; j++) {

                int tmp = Integer.parseInt(st.nextToken());

                graph[i][j] = tmp;

                if(tmp == -1) {
                    //공기청정기 윗부분 먼저 xy 좌표저장
                    airCleaner.add(j);
                    airCleaner.add(i);
                }
            }
        }

        int[] airCleanerU = {airCleaner.get(0), airCleaner.get(1)};
        int[] airCleanerD = {airCleaner.get(2), airCleaner.get(3)};
        
        for (int time = 0; time<T; time++) {
            
            //먼지확산
            for(int y=0; y<Y; y++) {
                for(int x = 0; x<X; x++) {

                    if(x == airCleanerU[0] && y == airCleanerU[1]){
                        continue;
                    }
                    if(x == airCleanerD[0] && y == airCleanerD[1]){
                        continue;
                    }

                    int preDust = graph[y][x];

                    if(preDust < 5) {
                        continue;
                    }

                    int difussingDust = preDust/5;
                    
                    for(int i = 0; i<4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if(nx == airCleanerU[0] && ny == airCleanerU[1]){
                            continue;
                        }
                        if(nx == airCleanerD[0] && ny == airCleanerD[1]){
                            continue;
                        }
                        if(nx < 0 || ny < 0 || nx>=X || ny >= Y) {
                            continue;
                        }

                        difussion[ny][nx] += difussingDust;

                        graph[y][x] -= difussingDust;
                    }
                }
            }

            for(int y=0; y<Y; y++) {
                for(int x = 0; x<X; x++) {
                    graph[y][x] += difussion[y][x];
                    difussion[y][x] = 0;
                }
            }


            //공기청정기
            //위회전
            for (int y = airCleanerU[1]-2; y >=0 ; y--) {
                int x = 0;
                graph[y+1][x] = graph[y][x];
            }

            for (int x = 1; x<X; x++) {
                int y = 0;

                graph[y][x-1] = graph[y][x];
            }

            for (int y = 1; y <= airCleanerU[1] ; y++) {
                int x = X-1;
                graph[y-1][x] = graph[y][x];
            }

            for (int x = X-2; x >= 1 ; x--) {
                int y = airCleanerU[1];
                graph[y][x+1] = graph[y][x];
            }
            graph[airCleanerU[1]][1] = 0;

            //아래회전
            for (int y = airCleanerD[1]+2; y < Y ; y++) {
                int x = 0;
                graph[y-1][x] = graph[y][x];
            }
            for (int x = 1; x<X; x++) {
                int y = Y-1;

                graph[y][x-1] = graph[y][x];
            }
            for (int y = Y-2; y >= airCleanerD[1] ; y--) {
                int x = X-1;
                graph[y+1][x] = graph[y][x];
            }
            for (int x = X-2; x >= 1 ; x--) {
                int y = airCleanerD[1];
                graph[y][x+1] = graph[y][x];
            }
            graph[airCleanerD[1]][1] = 0;

            
        }
        //미세먼지 양 계산
        int count = 0;
        for(int y=0; y<Y; y++) {
            for(int x = 0; x<X; x++) {
                if(graph[y][x] == -1) {
                    continue;
                }
                count += graph[y][x];
            }
        }
        System.out.println(count);
    }       
}