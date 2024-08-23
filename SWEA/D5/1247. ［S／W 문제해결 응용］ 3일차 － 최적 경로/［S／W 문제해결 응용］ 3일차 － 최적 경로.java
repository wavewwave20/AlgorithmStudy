import java.util.*;
import java.io.*;

public class Solution {
    static Point work, home;
    static List<Point> customers;
    static int N;
    static int minD;
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc<T; tc++) {
            minD = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            work = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            customers = new ArrayList<>();
            for(int i = 0; i<N; i++) {
                customers.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            dfs(new boolean[N+1], 0, 0, work);
            sb.append("#" + (tc+1) + " "+minD  + "\n");
        }
        System.out.println(sb.toString());
    }

    static int getDistance(Point p1, Point p2) {
        return (int)Math.abs(p1.x-p2.x) + (int)Math.abs(p1.y-p2.y);
    }

    //cnt == 방문한 고객수
    //i== 고객의 index
    static void dfs(boolean[] visited, int cnt, int sum, Point current) {
        if(cnt == N) {
            //마지막 집으로 돌아오는 거리 더함
            if(minD > sum + getDistance(current, home)) {
                minD = sum + getDistance(current, home);
            }
            return;
        }

        for(int i = 0; i<N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            // 거리합이 현재 최소값보다 커지는 경우 재귀하지 않음
            if(minD > sum + getDistance(current, customers.get(i))) {
                dfs(visited, cnt+1, sum + getDistance(current, customers.get(i)), customers.get(i));
            }
            visited[i] = false;
        }
    }
}