import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] result = new int[n];

        for (int i = 0; i<n; i++) {
            int next = Integer.parseInt(br.readLine().trim());

            if(next % 2 == 0) {
                String str = "-";
                result[i] = Integer.parseInt(str + (next / 2));
            }
            else {
                result[i] = next / 2 + 1;
            }
        }

        for (int i= 0; i<n; i++) {
            System.out.print("#" + (i+1));
            System.out.print(" " + result[i]);
            
            System.out.println();
        }
    }   
}