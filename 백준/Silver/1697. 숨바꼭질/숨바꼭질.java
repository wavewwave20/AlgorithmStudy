import java.io.*;
import java.util.*;

class Point {
    int x;
    int d;

    Point(int x, int d) {
        this.x = x;
        this.d = d;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean [200001];
        int[] cal = {-1, 1};

        visited[N] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(N, 0));

        int answer = 0;

        while(!(q.isEmpty())) {
            Point point = q.poll();
            int x = point.x;
            int d = point.d;

            if(x == K) {
                answer = d;
                break;
            }
            
            for(int i= 0; i<3; i++) {
                int nx = 0;
                if(i != 2) {
                    nx = x + cal[i];
                }else {
                    nx = x * 2;
                }

                if(nx <0 || nx > 200000) {
                    continue;
                }

                if(!visited[nx]) {
                    visited[nx] = true;
                    q.add(new Point(nx, d+1));
                    
                }
            }
        }
        System.out.println(answer);


    }
}