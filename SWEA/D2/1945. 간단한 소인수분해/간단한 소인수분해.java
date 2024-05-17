import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] result = new int[n][6];

        for (int i = 0; i< n; i++) {
            result[i][0] = Integer.parseInt(br.readLine().trim());
        }

        for (int i = 0; i< n; i++) {
            while(result[i][0] % 2 == 0) {
                result[i][0] = result[i][0] / 2;
                result[i][1]++;
            }

            while(result[i][0] % 3 == 0) {
                result[i][0] = result[i][0] / 3;
                result[i][2]++;
            }

            while(result[i][0] % 5 == 0) {
                result[i][0] = result[i][0] / 5;
                result[i][3]++;
            }

            while(result[i][0] % 7 == 0) {
                result[i][0] = result[i][0] / 7;
                result[i][4]++;
            }

            while(result[i][0] % 11 == 0) {
                result[i][0] = result[i][0] / 11;
                result[i][5]++;
            }
        }

        for (int i= 0; i<n; i++) {
            System.out.print("#" + (i+1));
            for ( int j = 1; j<6; j++) {
                System.out.print(" " + result[i][j]);
            }
            System.out.println();
        }
    }   
}
