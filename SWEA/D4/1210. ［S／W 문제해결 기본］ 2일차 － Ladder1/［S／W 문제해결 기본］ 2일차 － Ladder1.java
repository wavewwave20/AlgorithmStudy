import java.util.*;
import java.io.*;

class Solution
{   
    static int start;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= 10; test_case++){  
            int T = Integer.parseInt(br.readLine().trim());

            int[][] map = new int[100][100];
            int [] end = new int[2];

            for(int i = 0; i<100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for( int j = 0; j<100; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    map[i][j] = tmp;
                    if(i==99&& tmp == 2) {
                        end[0] = j;
                        end[1] = i;
                    }
                }
            }
            boolean[][]visited = new boolean[100][100];
            start = 0;
            dfs(map, visited, end[0], end[1]);

            sb.append("#"+T+" " + start+"\n");
		}
        System.out.println(sb.toString());
	}

    static void dfs(int[][] map, boolean[][]visited, int x, int y) {
        if(y==0) {
            start = x;
            return;
        }
        visited[y][x] = true;
    
        int r = x + 1;
        int l = x - 1;
    
        if (l >= 0 && map[y][l] == 1 && !visited[y][l]) {
            dfs(map, visited, l, y);
        } else if (r < 100 && map[y][r] == 1 && !visited[y][r]) {
            dfs(map, visited, r, y);
        } else {
            int up = y - 1;
            if(up >= 0) {
                dfs(map, visited, x, up);
            }
        }
    }
    
}

