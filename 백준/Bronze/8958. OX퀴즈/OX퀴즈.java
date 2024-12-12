import java.io.*;
import java.util.*;

public class Main {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        
        for(int i = 0; i<n; i++) {
            int sum = 0;
            int streak = 0;
            String str = br.readLine().trim();

            for(int j = 0; j<str.length(); j++) {
                if(str.charAt(j) == 'O') {
                    sum += (++streak);
                }else {
                    streak = 0;
                }
            }
            System.out.println(sum);
        }


        
    }
}