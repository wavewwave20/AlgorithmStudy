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

        //N과M 5
        // permutation(0, new int[M], new boolean[N]);

        //N과M 6
        //combination(0,0, new int[M]);

        //N과M 7
        permutationWithRepetition(0, new int[M], new boolean[N]);

        System.out.println(sb.toString());
        
    }

    
    static void combination(int cnt, int start, int [] result) {
        if(cnt == M) {
            for(int i = 0; i<M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i<N; i++) {
            result[cnt] = arr[i];
            combination(cnt+1, i+1, result);
        }
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

    static void permutationWithRepetition(int cnt, int[] result, boolean[]visited) {
        if(cnt == M) {
            for(int i = 0; i<M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i<N; i++) {
            result[cnt] = arr[i];
            permutationWithRepetition(cnt+1, result, visited);
        }
    }
}