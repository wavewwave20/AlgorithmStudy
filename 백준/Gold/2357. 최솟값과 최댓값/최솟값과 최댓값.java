import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[][] segmentTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int height = (int) Math.ceil(Math.log(N)/Math.log(2));
        int size = 2* (int)Math.pow(2, height)-1;
        segmentTree = new int[size][2];

        buildSegmentTree(0,N-1,0);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int[] result = query(0,N-1,a,b,0);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void buildSegmentTree(int start, int end, int node) {

        if(start == end) {
            segmentTree[node][0] = arr[start];
            segmentTree[node][1] = arr[start];
        }else {
            int mid = (start + end) /2;

            buildSegmentTree(start, mid, 2 *node +1);
            buildSegmentTree(mid+1, end, 2 *node +2);

            segmentTree[node][0] = Math.min(segmentTree[2 * node + 1][0], segmentTree[2 * node + 2][0]);
            segmentTree[node][1] = Math.max(segmentTree[2 * node + 1][1], segmentTree[2 * node + 2][1]);
        }
    }

    static int[] query(int start, int end, int left, int right, int node) {
        if(right<start || end < left) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        if(left <=start && end <= right) {
            return segmentTree[node];
        }

        int mid = (start + end) / 2;
        int[] leftResult = query(start, mid, left, right, 2 * node +1);
        int[] rightResult = query(mid+1, end, left, right, 2 * node +2);

        int min = Math.min(leftResult[0], rightResult[0]);
        int max = Math.max(leftResult[1], rightResult[1]);
        
        return new int[] {min,max};
    }
}