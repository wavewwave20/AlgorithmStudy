import java.util.*;
import java.io.*;

class Main
{   
    static class Node {
        int index;
        List<Node> prev;
        List<Node> next;
        Node(int index) {
            this.index = index;
            prev = new ArrayList<>();
            next = new ArrayList<>();
        }
    }

    static StringBuilder sb;

	public static void main(String args[]) throws Exception
	{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Node> nodes = new ArrayList<>();
        int count = 0;

        nodes.add(new Node(0));
        
        for(int i = 1; i<=N; i++) {
            nodes.add(new Node(i));
        }

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken());
            int big = Integer.parseInt(st.nextToken());
            
            nodes.get(small).next.add(nodes.get(big));
            nodes.get(big).prev.add(nodes.get(small));
        }

        for(int i = 1; i<=N; i++) {
            boolean[] visited = new boolean[N+1];
            visited[i] = true;

            //작은쪽으로 확인
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(nodes.get(i));

            while(!queue.isEmpty()) {
                Node now = queue.poll();

                for(Node n : now.prev) {
                    if(!visited[n.index]) {
                        queue.add(nodes.get(n.index));
                        visited[n.index] = true;
                    }
                }
            }


            //큰쪽으로 확인
            queue = new ArrayDeque<>();
            queue.add(nodes.get(i));

            while(!queue.isEmpty()) {
                Node now = queue.poll();

                for(Node n : now.next) {
                    if(!visited[n.index]) {
                        queue.add(nodes.get(n.index));
                        visited[n.index] = true;
                    }
                }
            }

            //visited 전부 true면 알 수 있음

            boolean flag = false;
            for(int j = 1; j<=N; j++) {
                if(visited[j] == false) {
                    flag = true; // visited 안된 것 존재
                    break;
                }
            }

            if(flag == false) {
                count++;
            }

        }
        
            
        System.out.println(count);
	}

    
}
