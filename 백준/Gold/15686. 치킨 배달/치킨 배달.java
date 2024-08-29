import java.io.*;
import java.util.*;

public class Main {
    
    static class Point {
        int x;
        int y;
        int pairIndex;
        int d;
        public Point(int x, int y, int pairIndex, int d) {
            this.x = x;
            this.y = y;
            this.pairIndex = pairIndex;
            this.d = d;
        }
    }
    static int N,M,size,cityDistance;
    static ArrayList<Point> homeList, chickenZipList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        homeList = new ArrayList<>();
        chickenZipList = new ArrayList<>();


        for(int y = 0; y<N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x<N; x++) {
                String tmp = st.nextToken();
                if(tmp.equals("1")) {
                    homeList.add(new Point(x, y, 0, 0));
                }else if(tmp.equals("2")) {
                    chickenZipList.add(new Point(x, y, 0, 0));
                }
            }
        }

        size = chickenZipList.size();
        cityDistance = Integer.MAX_VALUE;

        combination(0, 0, new int[M]);


        System.out.println(cityDistance);
    }

    static void combination(int cnt, int start, int[] result) {
        if(cnt == M) {
            
            int chickenDistance = 0;
            for(Point p1 : homeList) {
                if(cityDistance <= chickenDistance) {
                    break;
                }

                int tmp = Integer.MAX_VALUE;
                for(int i : result) {
                    Point p2 = chickenZipList.get(i);
                    tmp = Math.min(tmp, (int)Math.abs(p1.x - p2.x) + (int)Math.abs(p1.y - p2.y));
                }
                chickenDistance += tmp;
            }

            if(cityDistance > chickenDistance) {
                cityDistance = chickenDistance;
            }
            return;
        }

        for(int i = start; i<size; i++) {
            result[cnt] = i;
            combination(cnt+1, i+1, result);
        }
    }
}