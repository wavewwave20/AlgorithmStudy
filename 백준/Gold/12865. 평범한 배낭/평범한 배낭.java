import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] boolArr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] things = new int[N+1][2];
        for(int i = 1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            things[i][0] = Integer.parseInt(st.nextToken());
            things[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][K+1];

        for(int i = 1; i<N+1; i++) {
            for(int w = 1; w<K+1; w++) {
                // 이번 물건 무게가 배낭 무게보다 큰경우
                if(things[i][0] > w) {
                    dp[i][w] = dp[i-1][w];
                } else {
                    // 물건 무게가 배낭 무게보다 작은 경우
                    int tmp = 0;
                    if(w-things[i][0] > 0) {
                        tmp = w-things[i][0];
                    }
                    dp[i][w] = Math.max(dp[i-1][w], things[i][1] + dp[i-1][tmp]);
                }

            }
        }
        System.out.println(dp[N][K]);
    }
}