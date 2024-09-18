import java.io.*;
import java.util.*;

/**
 * Main
 */
public class Main {
    static int N,M;
    static int[] arr;
    // static ArrayList<String> list;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        permutation(0, new int[M], new boolean[N]);

        System.out.println(sb.toString());
        
    }

    static void permutation(int cnt, int[] result, boolean[]visited) {
        if(cnt == M) {
            for(int i = 0; i<M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i<N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            result[cnt] = arr[i];
            permutation(cnt+1, result, visited);
            visited[i] = false;
        }
    }
}