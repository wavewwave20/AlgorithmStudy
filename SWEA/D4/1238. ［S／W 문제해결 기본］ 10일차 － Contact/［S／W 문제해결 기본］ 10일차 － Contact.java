import java.util.*;
import java.io.*;

class Solution
{   
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int [][] map = new int[N][2];
            Queue<Integer> queue = new LinkedList<>();
            boolean []visited = new boolean[101];
            for(int i = 0; i<N/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                map[i][0] = from;
                map[i][1] = to;

                if(from == start) {
                    queue.add(from);
                }
            }

            visited[start] = true;
            int lastVisitedMax = 0;

            while(!queue.isEmpty()) {
                
                int size = queue.size();

                int tmpMax = -1;
                while(--size >= 0) {
                    int from = queue.poll();
                    
                    for(int i = 0; i<map.length; i++) {
                        if(map[i][0] == from && !visited[map[i][1]]) {
                            queue.add(map[i][1]);
                            visited[map[i][1]] = true;
                        }
                    }

                    if(tmpMax < from) {
                        tmpMax = from;
                    }
                }
                if(queue.isEmpty()) {
                    lastVisitedMax = tmpMax;
                }
            }

            sb.append("#" + test_case + " "+ lastVisitedMax + "\n");
		}
        System.out.println(sb.toString());
	}
}