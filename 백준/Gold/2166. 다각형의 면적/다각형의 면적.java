import java.io.*;
import java.util.*;

public class Main {

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] x = new int[N+1];
        int[] y = new int[N+1];
        
        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        x[N] = x[0];
        y[N] = y[0];

        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i<N; i++) {
            sum1 += (long)x[i] * (long)y[i+1];
            sum2 += (long)y[i] * (long)x[i+1];
        }
        
        System.out.printf("%.1f", Math.abs(sum1-sum2)/2D);
    }
}