import java.util.*;
import java.io.*;

public class Solution {
    static int v,e;
   
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc<=10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            
            int[][] graph = new int[v+1][v+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<e; i++) {
                graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            int[] table = new int[v+1];

            for(int y = 1; y<=v; y++) {
                for(int x = 1; x<=v; x++) {
                    if (graph[y][x] == 1) {
                        table[x]++;
                    }
                }
            }
            Queue<Integer> queue = new ArrayDeque<>();

            for(int i = 1; i<=v; i++) {
                if(table[i] == 0) {
                    queue.add(i);
                }
            }

            StringBuilder sb2 = new StringBuilder();
            while(!queue.isEmpty()) {
                int now = queue.poll();
                sb2.append(now + " ");

                for(int j = 1; j<=v; j++) {
                    if (graph[now][j] == 1) {
                        table[j]--;
                        if(table[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
            }

            sb.append("#" + (tc) + " "+ sb2.toString() + "\n");
           
        }
        System.out.println(sb.toString());
    }

}