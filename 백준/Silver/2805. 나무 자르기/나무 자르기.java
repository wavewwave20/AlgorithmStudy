import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static Integer[] trees;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trees = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);
        // Checklist
        // 1. Check(lo) = T, Check(hi) = F를 만족하는가?
        // 2. lo는 정답이 될 수 있는 모든 범위를 나타낼 수 있는가? (정답은 0 ~ max(v) - 1라 가능)

        int hi = trees[trees.length-1];
        int lo = 0;

        while(lo + 1<hi) {
            int mid = (hi + lo)/2;
            
            if(check(mid)) {
                lo = mid;
            }else {
                hi = mid;
            }
        }

        System.out.println(lo);
    }

    // mid 높이에 절단기를 위치했을 때 m 이상의 나무를 얻을 수 있는가?
    static boolean check(int mid) {
        long sum = 0;
        for(int i = 0; i<n; i++) {
            if(trees[i] > mid) {
                sum += trees[i] - mid;
            }
        }
        return sum >= m;
    }
}