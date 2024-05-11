import java.util.*;
import java.io.*;

class Main {
    static int n,m,target1,target2,count,answer;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited = new int[100+1];
    static Queue<int[]> que = new LinkedList<>();

    static void bfs() {
        visited[target1] = 1;
        int depth = 0;
        int[] repforq = {target1,depth};
        
        que.offer(repforq);

        while(!que.isEmpty()) {
            int current[] = que.poll();
            int cur = current[0];
            int curDepth = current[1];

            if(cur == target2) {
                answer = curDepth;
                return;
            }

            for (int i : graph.get(cur)) {
                if(visited[i] == 0) {
                    int[] tmp = {i,curDepth+1};
                    que.offer(tmp);
                    visited[i] =1;
                }
            }

        }
        answer = -1;
    }

    static public void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        target1 = Integer.parseInt(st.nextToken());
        target2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());


        for (int i = 0; i<100+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }


        bfs();

        System.out.println(answer);
    

    }
}