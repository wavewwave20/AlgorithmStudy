import java.io.*;
import java.util.*;

public class Main {

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());

        if(a%4 == 0 && (a%100 != 0 || a%400 == 0)) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
}