import java.util.*;
import java.io.*;

class Solution
{   
    static int[]dx = {1,-1,-1,1};
    static int[]dy = {1,1,-1,-1};
    static int[][] map;
    static int N;
    static int result;

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            
            
            for(int y = 0; y<N; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }
            result = -1;

            for(int y = 0; y<N; y++) {
                for (int x = 0; x < N; x++) {
                    boolean[] visited = new boolean[101];

                    dfs(x, y, 0, 0, visited, x,y);

                }
            }

            sb.append("#" + test_case + " "+ result + "\n");
		}
        System.out.println(sb.toString());
	}

    static void dfs(int x, int y, int d, int cnt, boolean[]visited, int startX, int startY) {
        if(d == 4) {
            if(cnt>=4 &&result < cnt && x == startX && y == startY) {
                result = cnt;
            } 
            return;
        }

        dfs(x, y, d+1, cnt, visited, startX, startY);
        
        int nx = x + dx[d];
        int ny = y + dy[d];

        if(nx <0|| ny <0|| nx>=N|| ny>=N) {
            return;
        }
        if(visited[map[ny][nx]]) {
            return; 
        }   
        visited[map[ny][nx]] = true;

        dfs(nx, ny, d, cnt + 1, visited, startX, startY);
        visited[map[ny][nx]] = false;

    }
    
}