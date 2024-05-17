
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] result = new int[n];
        
        for (int i = 0; i<n; i++) {
            int next = Integer.parseInt(br.readLine().trim());
            boolean[] check = new boolean[10];
            int intNum = 0;
            int cnt = 0;
            int lap = 0;

            while(cnt < 10) {
                lap++;
                intNum += next;
                String stringNum = "" + intNum;

                for (int j = 0; j<stringNum.length(); j++) {
                    if(check[stringNum.charAt(j)-'0'] == false) {
                        check[stringNum.charAt(j)-'0'] = true;
                        cnt++;
                    }
                }
            }
            result[i] = lap * next;
        }

        for (int i= 0; i<n; i++) {
            System.out.print("#" + (i+1));
            System.out.print(" " + result[i] + "\n");
        }
    }   
}