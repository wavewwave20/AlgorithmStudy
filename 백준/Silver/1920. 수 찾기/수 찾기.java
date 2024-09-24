import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nArr = new int[n];
        for(int i = 0; i<n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] mArr = new int[m];
        for(int i = 0; i<m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);
        StringBuilder sb =  new StringBuilder();

        for(int i = 0; i<m; i++) {
            int find = mArr[i];
            int lo = 0;
            int hi = n-1;
            boolean found = false;
            while(lo <= hi) {
                int mid = (lo + hi) /2;

                if(nArr[mid] < find) {
                    lo = mid+1;
                }else if(nArr[mid] > find){
                    hi = mid-1;
                }else {
                    found = true;
                    break;
                }
            }

            if(found) {
                sb.append("1\n");
            }else {
                sb.append("0\n");
            }
        }
        
        System.out.println(sb.toString());
    }
}
