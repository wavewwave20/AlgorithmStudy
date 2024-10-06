import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int T = 1; T<=TC; T++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] dp = new int[N+1][K+1];

            int[][] items = new int[N+1][2];

            for(int i =1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                items[i][0] = Integer.parseInt(st.nextToken());
                items[i][1] = Integer.parseInt(st.nextToken());
            }

            for(int n = 1; n <= N; n++) {
                for(int k = 1; k <= K; k++) {
                    if (k < items[n][0]) {
                        dp[n][k] = dp[n-1][k];
                    } else {
                        dp[n][k] = Math.max(dp[n-1][k], dp[n-1][k-items[n][0]] + items[n][1]);
                    }
                }
            }

            sb.append("#"+T+" "+dp[N][K]+"\n");
            

        }
        System.out.println(sb.toString());
    }
}