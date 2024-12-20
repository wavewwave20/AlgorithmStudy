import java.io.*;
import java.util.*;

public class Main {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i<n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp > max) {
                max = tmp;
            }

            if(tmp < min) {
                min = tmp;
            }
        }
        System.out.println(min + " " + max);
    }
        
}