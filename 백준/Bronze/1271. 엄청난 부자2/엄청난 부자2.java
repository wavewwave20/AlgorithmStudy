import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());


        
        System.out.println(a.divide(b));
        System.out.println(a.remainder(b));
        

    }
}