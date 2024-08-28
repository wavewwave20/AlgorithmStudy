import java.util.*;
import java.io.*;

public class Solution {
    static int n,m;
    static int [] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            make();

            StringBuilder sb2 = new StringBuilder();
            for(int i = 0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                int e1 = Integer.parseInt(st.nextToken());
                int e2 = Integer.parseInt(st.nextToken());

                if(type == 0) {
                    union(e1, e2);
                }
                else if(type == 1) {
                    if(!unionCheck(e1, e2)) {
                        sb2.append(1);
                    }else {
                        sb2.append(0);
                    }
                }
            }
            sb.append("#" + (tc+1) + " "+ sb2.toString()  + "\n");
           
        }
        System.out.println(sb.toString());
    }

    static void make() {
        parents = new int[n+1];
        for(int i = 1; i<=n; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if(a == parents[a]) return a;

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

    static boolean unionCheck(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) {
            return false;
        }
        return true;
    }
}