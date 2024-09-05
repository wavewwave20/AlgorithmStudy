import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        
        int[]dp = new int[n+1];
        final int INF = 10000;
        Arrays.fill(dp, INF);

        if(n>= 3) {
            dp[3] = 1;
        }
        if(n>=5) {
            dp[5] = 1;
        }

        for(int i = 6; i<=n; i++) {
            int min = INF;
            if(dp[i-3] != INF) min = dp[i-3]+1;
            if(dp[i-5] != INF) min = Math.min(min, dp[i-5]+1);
            dp[i] = min;
        }
        
        if(dp[n] != INF) {
            System.out.println(dp[n]);
        }else {
            System.out.println(-1);
        }

    }
}