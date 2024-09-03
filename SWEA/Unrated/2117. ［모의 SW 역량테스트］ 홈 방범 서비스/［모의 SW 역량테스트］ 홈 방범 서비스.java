import java.util.*;
import java.io.*;

public class Solution {
    static int N,M,K;
    static List<int[]> map;
    static int maxHome;

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        
        for(int T = 1; T<=tc ; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            maxHome = 0;

            map = new ArrayList<>();
           
            for(int y = 0; y<N; y++) {
                st = new StringTokenizer(br.readLine());
                for(int x = 0; x<N; x++) {
                    if(Integer.parseInt(st.nextToken()) == 1) {
                        map.add(new int[]{x,y});
                    }
                }
            }

            // if(N%2 == 0) {
            //     K = N;
            // }else {
            //     K = N+1;
            // }

            for(int k = 1; k<=N+2; k++) {
                int cost = k*k + (k-1)*(k-1);
                for(int y = 0; y<N; y++) {
                    for(int x = 0; x<N; x++) {
                        check(x, y, k, cost);
                    }
                }
            }
            
            sb.append("#").append(T + " ").append(maxHome).append("\n");
        }
        System.out.println(sb.toString());

    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return (int)Math.abs(x1-x2) + (int)Math.abs(y1-y2);
    }

    static void check(int x, int y, int k, int cost) {
        int sum = 0;

        for(int[] home : map) {
            if(getDistance(x, y, home[0], home[1]) <= k-1) {
                sum++;
            }
        }

        if(sum*M >= cost && maxHome < sum) {
            maxHome = sum;
        }
    } 
}
