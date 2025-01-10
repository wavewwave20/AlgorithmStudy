import java.io.*;
import java.util.*;
public class Main {

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        long[] map = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++) {
            map[i] = Long.parseLong(st.nextToken());
        }

        int s = 0;
        int e = N-1;
        
        long min = Long.MAX_VALUE;
        long[] minValue = new long[2];

        while(s<e) {

            long tmp = map[e]+map[s];
            long tmpAbs = Math.abs(tmp);
            
            if(tmpAbs < min) {
                min = tmpAbs;
                minValue[0] = map[s];
                minValue[1] = map[e];
            }

            if(tmp >= 0) {
                e--;
            }else {
                s++;
            }

        }
        System.out.println( minValue[0] + " " +  minValue[1]);
    }
}