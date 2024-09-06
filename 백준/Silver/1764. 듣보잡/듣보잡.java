import java.util.*;
import java.io.*;

class Main {   
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i<N; i++) {
            set.add(br.readLine().trim());
        }
        for(int i = 0; i<M; i++) {
            String str = br.readLine().trim();
            if(!set.add(str)) {
                list.add(str);
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size() + "\n");
        for(String s : list) {
            sb.append(s + "\n");
        }
        System.out.println(sb.toString());
	}
}
