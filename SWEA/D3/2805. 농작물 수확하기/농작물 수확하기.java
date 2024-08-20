import java.util.*;
import java.io.*;

class Solution{   

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        for(int test_case = 1; test_case <= T; test_case++){  
            int N = Integer.parseInt(br.readLine().trim());
            int[][]map = new int[N][N];
            for(int x = 0; x<N; x++) {
                String str = br.readLine().trim();
                for(int y = 0; y<N; y++) {
                    map[y][x] = str.charAt(y) - '0';
                }
            }

            int sum = 0;
            //처음부터 가운데까지
            int y = 0;
            int cnt = 1;
            int back = 0;
            while(y<=N/2) {
                for(int x = N/2-back; x<N/2+cnt; x++) {
                    sum += map[y][x];
                }
                cnt++;
                y++;
                back++;
            }

            //가운데 다음줄부터 끝까지
            cnt = 1;    
            back = 0;
            while(y>N/2 && y<N) {
                for(int x =1 + back; x<N-cnt; x++) {
                    sum+=map[y][x];
                }
                cnt++;
                y++;
                back++;
            }
            sb.append("#" + test_case + " " + sum ).append("\n");
        }
        System.out.print(sb.toString());
    }

}