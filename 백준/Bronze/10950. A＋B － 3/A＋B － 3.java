import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<n; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(a+b);
        }

        
        

    }
}