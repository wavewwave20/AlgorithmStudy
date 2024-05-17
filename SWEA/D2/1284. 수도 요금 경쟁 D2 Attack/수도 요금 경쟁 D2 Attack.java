import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());
        int[] result = new int[testCase];
        
        for (int T = 0; T<testCase; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int aPrice = P * W;
            int bPrice;

            if (R >= W) {
                bPrice = Q;
            }
            else {
                bPrice = Q + (W-R) * S;
            }
            
            result[T] = aPrice < bPrice ? aPrice : bPrice;
        }

        for (int i= 0; i<testCase; i++) {
            System.out.print("#" + (i+1));
            System.out.print(" " + result[i] + "\n");
        }
    }   
}