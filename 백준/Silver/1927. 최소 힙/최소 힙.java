import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if(!pq.isEmpty()) {
                    sb.append(pq.poll() + "\n");

                }else {
                    sb.append("0\n");

                }
            }else {
                pq.add(x);
            }
        }
        System.out.println(sb.toString());
    }
}
