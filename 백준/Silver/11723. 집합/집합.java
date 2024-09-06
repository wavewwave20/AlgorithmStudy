import java.util.*;
import java.io.*;

class Main {   

    static StringBuilder sb;

	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            if("add".equals(type)) {
                int num = Integer.parseInt(st.nextToken());
                set.add(num);
            }else if("remove".equals(type)) {
                int num = Integer.parseInt(st.nextToken());
                set.remove(num);
            }else if("check".equals(type)) {
                int num = Integer.parseInt(st.nextToken());
                if(set.contains(num)) {
                    sb.append(1 + "\n");
                }else {
                    sb.append(0 + "\n");
                }
                
            }else if("toggle".equals(type)) {
                int num = Integer.parseInt(st.nextToken());
                if(!set.remove(num)) {
                    set.add(num);
                }
            }else if("all".equals(type)) {
                set = new HashSet<>();
                for(int j = 1; j<=20; j++) {
                    set.add(j);
                }
                
            }else if("empty".equals(type)) {
                set = new HashSet<>();
            }
        }
        System.out.println(sb.toString());
	}
}
