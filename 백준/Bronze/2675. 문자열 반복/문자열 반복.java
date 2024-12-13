import java.io.*;
import java.util.*;

public class Main {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<n; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            for(int t = 0; t<str.length(); t++) {
                for(int s = 0; s<k; s++) {
                    sb.append(str.charAt(t));
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

        
    }
}