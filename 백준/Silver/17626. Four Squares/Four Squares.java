import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        List<Integer> list = new ArrayList<>();

        int index = 0;
        list.add(0);
        while(Math.pow(++index,2) <= 50000) {
            list.add((int)Math.pow(index,2));
        }

        int[] dp = new int[n+1];
        
        for(int i=1; i<=n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j=1; j<list.size(); j++) {
                if(i < list.get(j)) break;
                dp[i] = Math.min(dp[i], dp[i-list.get(j)]+1);
            }
        }
        System.out.println(dp[n]);
    }
}
