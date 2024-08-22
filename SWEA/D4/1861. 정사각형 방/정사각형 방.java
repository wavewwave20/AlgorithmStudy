import java.util.*;
import java.io.*;

class Solution{   
    static int[]dx = {0,0,-1,1};
    static int[]dy = {1,-1,0,0};
    static int[][]map;
    static int N, step, start;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        for(int test_case = 1; test_case <= T; test_case++){  
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            step = 0;
            start = 0;

            for(int y = 0; y<N; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int x = 0; x<N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            for(int y = 0; y<N; y++) {
                for(int x = 0; x<N; x++) {

                    long NN = N*N;

                    int startPoint = map[y][x];

                    if(NN - startPoint +1 >= step) {
                        move(x, y, startPoint, 1);
                    }

                }
            }


            sb.append("#" + test_case).append(" " + start +" " + step).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void move(int x, int y,int s, int d) {

        for(int i = 0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=N || ny >=N) {
                continue;
            }

            if(map[ny][nx] == map[y][x] +1) {
                if(step < d+1) {
                    step = d+1;
                    start = s;
                }else if (step == d+1 && start > s) {
                    start = s;
                }
                move(nx, ny,s, d+1);
            }
        }
    }
}