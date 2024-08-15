import java.io.*;
import java.util.*;

public class Main{
    static String max;
    static String min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        combination(0, n, m, 0, new int[m]);
    }  

    static void combination(int start,int n, int m, int depth, int[]result) {
        if(depth == m) {
            for (int i : result) {
                System.out.print("" + i+" ");
            }
            System.out.println();
            return;
        }

        for(int i =start; i<n; i++){
            result[depth] = i+1;
            combination(i+1,n, m, depth+1, result);
        }
    }
}