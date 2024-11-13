import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int TC = Integer.parseInt(br.readLine());

        for(int T = 1; T<=TC; T++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i<= n; i++) {
                arr[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i<= n; i++) {
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            dp[0][1] = arr[0][1]; 
            dp[1][1] = arr[1][1]; 

            for(int i = 2; i<= n; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
            }
            
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }

}