import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer>[] tree;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        parents = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        bfs(1); // 루트를 1로 설정하고 탐색 시작

        // 2번 노드부터 부모를 출력
        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : tree[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parents[next] = current;
                    queue.add(next);
                }
            }
        }
    }
}
