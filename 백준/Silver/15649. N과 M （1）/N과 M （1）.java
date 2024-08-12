import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean [] visited = new boolean[N];
        int[] result = new int[M];
        StringBuilder sb = new StringBuilder();
        permutation(N, M, 0,sb, visited, result);

        System.out.println(sb.toString());
    }


static void permutation(int N, int M, int depth, StringBuilder sb, boolean[] visited, int[] result) {
        if (depth == M) {  // depth가 M에 도달하면 하나의 순열이 완성됨
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i + 1;  // 순열에 현재 숫자 추가
                permutation(N, M, depth + 1, sb, visited, result);
                visited[i] = false;
            }
        }
    }
}