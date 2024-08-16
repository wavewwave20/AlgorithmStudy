import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        permutation(n, m, 0, new int[m], new boolean[n], sb);
        System.out.println(sb.toString());
    }  
    static void permutation(int n, int m, int depth, int[]result, boolean[] visited, StringBuilder sb) {
        if(depth == m) {
            for (int i : result) {
                sb.append("" + i+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i<n; i++) {
            // if(visited[i]) continue;
            // visited[i] = true;
            result[depth] = i+1;
            permutation(n,m,depth+1,result,visited,sb);
            // visited[i] = false;
        }
    }
}