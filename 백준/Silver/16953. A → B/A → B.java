import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[][] segmentTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<long[]> queue = new ArrayDeque<>();

        queue.add(new long[]{a, 0});

        boolean flag = false;
        while(!queue.isEmpty()) {
            long[] now = queue.poll();

            if(now[0] == b) {
                sb.append(now[1]+1);
                flag = true;
                break;
            }

            long next = now[0] * 2;
            if(next <= b) {
                queue.add(new long[] {next, now[1]+1});
            }
            next = now[0] * 10 + 1;
            if(next <= b) {
                queue.add(new long[] {next, now[1]+1});
            }
        }

        if(flag) {
            System.out.println(sb);
        }else {
            System.out.println(-1);
        }

    }

}