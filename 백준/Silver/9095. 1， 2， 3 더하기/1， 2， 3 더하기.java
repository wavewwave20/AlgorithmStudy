import java.util.*;
import java.io.*;

class Main {   
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int tc = 1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[]dp = new int[N+5];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int i = 4; i<=N; i++) {
                dp[i] = dp[i-1] + dp[i-2]+ dp[i-3];
            }
            
            sb.append(dp[N] + "\n");    
        }
        System.out.print(sb.toString());
	}
}
