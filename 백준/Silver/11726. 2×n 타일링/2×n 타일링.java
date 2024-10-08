import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        int[] dp = new int[n+1];

        for(int i = 1; i<=n; i++) {
            if(i <= 2) {
                dp[i] = i;
                continue;
            }

            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }
        System.out.println(dp[n]);
    }
}