import java.io.*;
import java.util.*;

public class Main {

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for(int i = 0; i<5; i++) {
            int n = Integer.parseInt(br.readLine());
            sum += n;
        }
        System.out.println(sum);
    }
}