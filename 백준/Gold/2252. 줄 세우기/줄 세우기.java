import java.io.*;
import java.util.*;

public class Main {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> map = new ArrayList<>();

        for(int i = 0; i<N+1; i++) {
            map.add(new ArrayList<>());
        }

        int[] edgeCount = new int[N+1];

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edgeCount[b]++;
            map.get(a).add(b);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i<edgeCount.length; i++) {
            if(edgeCount[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            int student = queue.poll();

            sb.append(student + " ");

            List<Integer> list = map.get(student);

            for(int i = 0; i<list.size(); i++) {
                int next = list.get(i);
                edgeCount[next]--;

                if(edgeCount[next] == 0) {
                    queue.add(next);
                }
            }
        }
        System.out.println(sb);
    }
        
}