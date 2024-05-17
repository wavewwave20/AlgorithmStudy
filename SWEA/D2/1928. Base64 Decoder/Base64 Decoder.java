import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] result = new String[n];

        for (int i = 0; i<n; i++) {
            result[i] = new String(Base64.getDecoder().decode(br.readLine().trim()));
        }

        for (int i= 0; i<n; i++) {
            System.out.print("#" + (i+1));
            System.out.print(" " + result[i]);
            
            System.out.println();
        }
    }   
}