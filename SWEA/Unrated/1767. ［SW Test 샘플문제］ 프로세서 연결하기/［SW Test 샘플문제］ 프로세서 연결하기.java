import java.util.*;
import java.io.*;

class Core {
    int x;
    int y;
    Core(int x, int y) {
        this.x =x;
        this.y = y;
    }
}
class Result {
    int cores;
    int sum;
    Result(int cores, int sum) {
        this.cores = cores;
        this.sum = sum;
    }
}

class Solution
{   
    static int cores;
    static int summ;
    static ArrayList<Result> resultList;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++){   
            cores = -1;
            summ = Integer.MAX_VALUE;
            int N = Integer.parseInt(br.readLine().trim());
            int[][] map = new int[N][N];
            
            ArrayList<Core> coreList = new ArrayList<>();

            for (int y = 0; y<N; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x= 0; x<N; x++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if(tmp == 1) {
                        if(!(x == 0 || y == 0 || x == N -1 || y == N -1)) { 
                            coreList.add(new Core(x, y));
                        }
                        map[y][x] = 1;
                    }
                }
            }

            resultList  = new ArrayList<>();

            coreCheck(0, map, coreList, 0,0);
            
            sb.append("#"+test_case+" "+summ + "\n");
		}
        System.out.println(sb.toString());
	}

    static void coreCheck(int depth, int[][]visited, ArrayList<Core> coreList, int sum, int connected) {
        
        if (depth == coreList.size()) {
            if (connected > cores || (connected == cores && sum < summ)) {
                cores = connected;
                summ = sum;
            }
            return;
        }

        int x = coreList.get(depth).x;
        int y = coreList.get(depth).y;

        boolean isCoreConnect = false;
        for(int i = 0; i<4; i++) {      
            isCoreConnect = false;
            int tmpSum = 0;
            ArrayList<Core> rollback = new ArrayList<>();
            int ny = y;
            int nx = x;
            while(true) {
                ny = ny + dy[i];
                nx = nx + dx[i];
                if(nx <0 || ny <0 || nx>=visited.length || ny>=visited.length) {
                    isCoreConnect = true;
                    break;
                }
                if(visited[ny][nx] != 0) {
                    isCoreConnect = false;
                    break;
                }
                
                visited[ny][nx] = 2;
                tmpSum++;
                rollback.add(new Core(nx, ny));

            }
            
            if(isCoreConnect) {
                coreCheck(depth + 1, visited, coreList, sum + tmpSum, connected+1);       
            }
            for(Core c : rollback) {
                visited[c.y][c.x] = 0;
            }
        }
        
        
        coreCheck(depth + 1, visited, coreList, sum, connected);
        
    }
}