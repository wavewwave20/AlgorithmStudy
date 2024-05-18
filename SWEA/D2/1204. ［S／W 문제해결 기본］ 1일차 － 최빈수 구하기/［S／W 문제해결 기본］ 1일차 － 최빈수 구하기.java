import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<String, Integer> hm = new HashMap<>();
            while (st.hasMoreTokens()) {
                String next = st.nextToken();
                if(hm.get(next) == null) {
                    hm.put(next, 1);
                }else {
                    int tmp = hm.get(next);
                    hm.put(next, tmp+1);
                }
            }
            int max_value = 0;
            String max_key = "";
            for(String s : hm.keySet()) {
                if (max_value < hm.get(s)) {
                    max_key = s;
                    max_value = hm.get(s);

                }else if (max_value == hm.get(s)){
                    if (Integer.parseInt(max_key) < Integer.parseInt(s)) {
                        max_key = s;
                        max_value = hm.get(s);
                    }
                }
            }

            System.out.printf("#%d %s\n", (t+1), max_key);
        }
    }   
}