import java.util.*;
import java.io.*;

class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int N, count;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    static void dfs(int y, int x) {
        count++;
        visited[y][x] = true;

        for (int i = 0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny >= 0 && nx <N && ny < N) {
                if(visited[ny][nx] == false && graph[ny][nx] == 1) {
                    dfs(ny, nx);
                }
            }
        }
    }

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N =Integer.parseInt(st.nextToken());
        int index = 0;
        ArrayList<Integer> result = new ArrayList<>();


        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i<N; i++) {
            String line = br.readLine();
            for (int j = 0; j<N; j++) {
                graph[i][j] = line.charAt(j)-'0';
            }
        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (graph[i][j] == 1 && visited[i][j] == false) {
                    dfs(i,j);
                    index++;
                    result.add(count);
                    count = 0;
                }
            }
        }

        int[] answer = new int[index];
        int n = 0;
        for(int i : result) {
            answer[n++] = i;
        }
        Arrays.sort(answer);

        System.out.println(index);
        
        for (int i = 0; i < index; i++) {
            System.out.println("" + answer[i]);
        }
    }
}
