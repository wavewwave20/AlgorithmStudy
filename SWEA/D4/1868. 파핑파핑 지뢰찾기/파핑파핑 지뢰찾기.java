import java.util.*;
import java.io.*;

class Solution
{   
    static int[]dx = {0,0,-1,1,1,1,-1,-1};
    static int[]dy = {-1,1,0,0,1,-1,1,-1};
    static char[][] map;
    static int N;
    static boolean[][]visited;

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            visited = new boolean[N][N];
            
            for(int y = 0; y<N; y++) {
                String line = br.readLine();
                for (int x = 0; x < N; x++) {
                    map[y][x] = line.charAt(x);
                }
            }

            int click = 0;
            for(int y = 0; y<N; y++) {
                for(int x = 0; x<N; x++) {

                    if(map[y][x] == '.') {
                        boolean flag = true;

                        for(int i = 0; i<8; i++) {
                            int nx = x + dx[i];
                            int ny = y + dy[i];
            
                            if(nx <0|| ny <0 || nx >=N || ny>=N) {
                                continue;
                            }
    
                            if(map[ny][nx] == '*') {
                                flag = false;
                                break;
                            }
                        }

                        if(flag) {
                            click++;
                            dfs(x, y);
                        }
                        // printMap(map);
                    }
                }
            }

            for(int y = 0; y<N; y++) {
                for(int x = 0; x<N; x++) {
                    if(map[y][x] == '.') {
                        click++;
                    }
                }
            }

            sb.append("#" + test_case + " "+ click  + "\n");
		}
        System.out.println(sb.toString());
	}

    static void checkZero(int x, int y) {
        if(map[y][x] != '0') {
            for(int i = 0; i<8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
    
                if(nx <0|| ny <0 || nx >=N || ny>=N) {
                    continue;
                }

                if(map[ny][nx] == '0') {
                    map[y][x] = '$';
                    break;
                }
            }
        }
    }

    static void dfs(int x, int y) {

        int mine = 0;

        for(int i = 0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx <0|| ny <0 || nx >=N || ny>=N) {
                continue;
            }
            if(map[ny][nx] == '*') {
                mine++;
            }
        }

        //주변 mine이 0일때 
        if(mine == 0 && map[y][x] == '.') {
            map[y][x] = '0';

            for(int i = 0; i<8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
    
                if(nx <0|| ny <0 || nx >=N || ny>=N) {
                    continue;
                }

                if(map[ny][nx] == '.') {
                    dfs(nx, ny);
                }
            }
        }

        if(mine != 0 && map[y][x] == '.') {
            map[y][x] = (char)(mine + '0');
        }
    }


    static void printMap(char[][] map) {
        System.out.println("===============");
        for(int y = 0; y<N; y++) {
            for(int x = 0; x<N; x++) {
                System.out.print(map[y][x] + " ");
            }
            System.out.println();
        }
    }
}