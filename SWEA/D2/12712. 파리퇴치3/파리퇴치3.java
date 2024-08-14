import java.util.*;
import java.io.*;

class Solution{   
    static int max;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
		
        for(int test_case = 1; test_case <= T; test_case++){  
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N= Integer.parseInt(st.nextToken());
            int M= Integer.parseInt(st.nextToken());
            max = 0;

            int[][]map = new int[N][N];
            
            for(int y = 0; y<N; y++) {
                st = new StringTokenizer(br.readLine());
                for(int x = 0; x<N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            for(int y = 0; y<N; y++) {
                for(int x = 0; x<N; x++) {
                    spray(x, y, M, map);
                }
            }
            sb.append("#" + test_case + " " + max + "\n");
		}
        System.out.println(sb.toString());
	}

    //십자와 엑스 스프레이를 호출
    static void spray(int x, int y,int m, int[][]map) {
        sprayCross(x, y, m, map);
        sprayX(x, y, m, map);

    }
    //십자로 맵을 확인
    static void sprayCross(int x, int y,int m, int[][]map) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int sum = map[y][x];
        //방향은 4개
        for(int i = 0; i<4; i++) {
            // 범위 변수만큼 반복
            for(int j = 1; j<m;j++) {
                int nx = x + j*dx[i];
                int ny = y + j*dy[i];

                if(nx <0|| ny<0|| nx>=map.length || ny >= map.length) {
                    continue;
                }
                sum += map[ny][nx];
            }
        }
        if(max < sum) {
            max = sum;
        }
    }
    //엑스로 맵을 확인
    static void sprayX(int x, int y,int m, int[][]map) {
        int[] dx = {1,-1, 1,-1};
        int[] dy = {1,-1,-1,1};
        int sum = map[y][x];
        //4방향으로 확인
        for(int i = 0; i<4; i++) {
            //M만큼 반복
            for(int j = 1; j<m;j++) {
                int nx = x + j*dx[i];
                int ny = y + j*dy[i];

                if(nx <0|| ny<0|| nx>=map.length || ny >= map.length) {
                    continue;
                }
                sum += map[ny][nx];
            }
        }
        if(max < sum) {
            max = sum;
        }
    }
}
