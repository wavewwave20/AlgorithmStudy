import java.util.*;
import java.io.*;


class Solution{   
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        for(int test_case = 1; test_case <= T; test_case++){  

            Long N = Long.parseLong(br.readLine());
            int depth = 0;

            while(N != 2) {
                double tmp1 = Math.sqrt(N);
                if(tmp1 - (long)tmp1 == 0) {
                    depth++;
                    N = (long)tmp1;
                }

                else {
                    Long tmp = ((long)tmp1 + 1) * ((long)tmp1 + 1);

                    depth += tmp - N;
                    N = tmp;
                }
            }
            
            sb.append("#" + test_case).append(" " + depth).append("\n");
        }
        System.out.print(sb.toString());
    }
}