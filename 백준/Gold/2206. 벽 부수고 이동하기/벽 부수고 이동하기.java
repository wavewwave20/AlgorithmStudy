import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;
    int d;
    boolean smashed;
    Node(int x, int y, int d, boolean smashed) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.smashed = smashed;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        int[][] map = new int[n][m];
        int[][][] visited = new int[n][m][2]; // 3차원 배열로 변경

        for (int y = 0; y < n; y++) {
            String line = br.readLine().trim();
            for (int x = 0; x < m; x++) {
                map[y][x] = line.charAt(x) - '0';
                visited[y][x][0] = Integer.MAX_VALUE;
                visited[y][x][1] = Integer.MAX_VALUE;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, false));
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            int d = now.d;
            boolean smashed = now.smashed;

            if(x == m-1 && y == n-1) {
                answer = Math.min(d, answer);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (nx == m - 1 && ny == n - 1) {
                    answer = Math.min(d + 1, answer);
                    continue;
                }

                int smashState = smashed ? 1 : 0;

                if (map[ny][nx] == 0 && visited[ny][nx][smashState] > d + 1) {
                    visited[ny][nx][smashState] = d + 1;
                    
                    queue.add(new Node(nx, ny, d + 1, smashed));
                }

                if (!smashed && map[ny][nx] == 1 && visited[ny][nx][1] > d + 1) {
                    visited[ny][nx][1] = d + 1;
                    queue.add(new Node(nx, ny, d + 1, true));
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
