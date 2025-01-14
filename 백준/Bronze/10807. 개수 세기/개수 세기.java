import java.io.*;
import java.util.*;
public class Main {

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 0; i<n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp == v) {
                sum++;
            }
        }
        System.out.println(sum);

    }
}