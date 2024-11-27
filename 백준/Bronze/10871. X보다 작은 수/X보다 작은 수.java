import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(x>tmp) {
                System.out.print(tmp + " ");
            }
        }


      
        
        

    }
}