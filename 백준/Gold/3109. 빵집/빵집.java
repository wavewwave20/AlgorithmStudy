import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {1, 1, 1};
    static int[] dy = {-1, 0, 1};
    static char[][]map;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        
        map = new char[N][M];

        for (int y = 0; y < N; y++) {
            String line = br.readLine();
            for (int x = 0; x < M; x++) {
                map[y][x] = line.charAt(x);
            }
        }
        int result = 0;
        for(int i = 0; i<N; i++) {
            if(dfs(0, i)) {
                result++;
            }
        }
        System.out.println(result);

        // for (char[] i : map) {
		// 	System.out.println(Arrays.toString(i));
		// }
		// System.out.println();

    }

    static boolean dfs(int x, int y) {
        for(int i = 0; i<3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx <0|| ny<0|| nx>= M || ny >=N) {
                continue;
            }
            if(map[ny][nx] == '.') {
                map[ny][nx] = '=';
                if(nx == M-1) {
                    return true;
                }else if (dfs(nx, ny)) {
                    return true;
                }
            }
        }
        return false;
    }
}
