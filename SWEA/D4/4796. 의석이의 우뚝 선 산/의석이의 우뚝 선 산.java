import java.util.*;
import java.io.*;

class Solution{   
    final static int UP = 1;
    final static int DOWN = 0;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        for(int test_case = 1; test_case <= T; test_case++){  
            int N = sc.nextInt();
           
            int flag = UP;
            int upCnt = 0;
            int downCnt = 0;
            int prev = sc.nextInt();
            int sum = 0;

            for(int i = 1; i<N; i++) {
                int now = sc.nextInt();
                if(flag == UP) {
                    if(prev < now) {
                        upCnt++;
                    }
                    else {
                        flag =DOWN;
                        downCnt++;
                    }
                }else {
                    if(prev>now) {
                        downCnt++;
                    }
                    else {
                        flag = UP;
                        sum += upCnt * downCnt;
                        downCnt = 0;
                        upCnt = 0;
                        upCnt++;
                    }
                }
                prev = now;
            }
            sum += upCnt * downCnt;
            sb.append("#" + test_case + " " + sum ).append("\n");
        }
        System.out.print(sb.toString());
    }
}