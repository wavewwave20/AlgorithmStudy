package Archive;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] result = new int[n][6];

        for (int i = 0; i< n; i++) {
            result[i][0] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i< n; i++) {
            result[i][1] = result[i][0] % 2;
            result[i][0] = result[i][0] / 2;

            result[i][2] = result[i][0] % 3;
            result[i][0] = result[i][0] / 3;

            result[i][3] = result[i][0] % 5;
            result[i][0] = result[i][0] / 5;

            result[i][4] = result[i][0] % 7;
            result[i][0] = result[i][0] / 7;

            result[i][5] = result[i][0] % 11;
            result[i][0] = result[i][0] / 11;
        }

        for (int i= 0; i<n; i++) {
            System.out.print("#" + i);
            for ( int j = 1; j<6; j++) {
                System.out.print(" " + result[i][j]);
            }
            System.out.println();
        }
    }   
}