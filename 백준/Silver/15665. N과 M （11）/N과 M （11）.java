import java.io.*;
import java.util.*;

/**
 * Main
 */
public class Main {
    static int N,M;
    static int[] arr;
    static HashSet<String> set;
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

        set = new HashSet<>();

        //N과M 5
        // permutation(0, new int[M], new boolean[N]);

        //N과M 6
        //combination(0,0, new int[M]);

        //N과M 7
        //permutationWithRepetition(0, new int[M]);

        //N과M 8
        // combinationWithRepetition(0,0, new int[M]);

        //N과M 9
        //distinctPermutation(0, new int[M], new boolean[N]);
        
        //N과M 10
        // distinctCombination(0,0, new int[M]);
        
        //N과M 11
        distinctPermutationWithRepetition(0, new int[M]);

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

    static void combinationWithRepetition(int cnt, int start, int [] result) {
        if(cnt == M) {
            for(int i = 0; i<M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i<N; i++) {
            result[cnt] = arr[i];
            combinationWithRepetition(cnt+1, i, result);
        }
    }

    static void distinctCombination(int cnt, int start, int[] result) {
        if(cnt == M) {
            if(set.add(Arrays.toString(result))) {
                for(int i = 0; i<M; i++) {
                    sb.append(result[i]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = start; i<N; i++) {
            result[cnt] = arr[i];
            distinctCombination(cnt+1, i+1, result);
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

    static void permutationWithRepetition(int cnt, int[] result) {
        if(cnt == M) {
            for(int i = 0; i<M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i<N; i++) {
            result[cnt] = arr[i];
            permutationWithRepetition(cnt+1, result);
        }
    }
    
    static void distinctPermutation(int cnt, int[] result, boolean[]visited) {
        if(cnt == M) {
            if(set.add(Arrays.toString(result))) {
                for(int i = 0; i<M; i++) {
                    sb.append(result[i]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = 0; i<N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            result[cnt] = arr[i];
            distinctPermutation(cnt+1, result, visited);
            visited[i] = false;
        }
    }

    static void distinctPermutationWithRepetition(int cnt, int[] result) {
        if(cnt == M) {
            if(set.add(Arrays.toString(result))) {
                for(int i = 0; i<M; i++) {
                    sb.append(result[i]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }
    
        for(int i = 0; i<N; i++) {
            result[cnt] = arr[i];
            distinctPermutationWithRepetition(cnt+1, result);
        }
    }
}