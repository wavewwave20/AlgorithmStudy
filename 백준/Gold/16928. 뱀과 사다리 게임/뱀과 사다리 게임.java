import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        // nowIndex, diceCnt
        queue.add(new int[] { 1, 0 });
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int nowIndex = now[0];
            int diceCnt = now[1];

            if (nowIndex == 100) {
                System.out.println(diceCnt);
                break;
            }

            for (int i = 6; i > 0; i--) {
                int nextIndex = nowIndex + i;

                if (nextIndex > 100) {
                    continue;
                }
                if (visited[nextIndex]) {
                    continue;
                }
                visited[nextIndex] = true;
                if (map.containsKey(nextIndex)) {
                    int snakeHead = map.get(nextIndex);

                    if (visited[snakeHead]) {
                        continue;
                    }
                    visited[snakeHead] = true;

                    queue.add(new int[] { snakeHead, diceCnt + 1 });
                } else {
                    queue.add(new int[] { nextIndex, diceCnt + 1 });
                }
            }
        }
    }
}