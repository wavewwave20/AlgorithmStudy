import java.util.*;
import java.io.*;

public class Solution {
    static int N,M;
    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M  = Integer.parseInt(st.nextToken());
            make();
            for(int i = 0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            for(int i = 1; i<=N; i++) {
                findSet(i);
            }

            HashSet<Integer> set = new HashSet<>();
            for(int i = 1; i<=N; i++) {
                set.add(parents[i]);
            }

            sb.append("#" + tc + " ").append(set.size()).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void make() {
        parents = new int[N+1];
        for(int i = 1; i<=N; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if(parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) {
            return false;
        }
        parents[bRoot] = aRoot;
        return true;
    }
}