import java.io.*;
import java.util.*;

public class Main{
    static String max;
    static String min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] sign =new char[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        max = "0";

        min = "9";

        int[] result = new int[N+1];
        boolean[] visited = new boolean[10];
        signCheck(sign, 0, result, visited);
        
        System.out.println(""+max.trim() +"\n" + min.trim());
    }  

    static void signCheck(char[]sign, int depth, int []result, boolean[]visited) {
        if(depth == result.length) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<result.length;i++) {
                sb.append(result[i]);
            }
            String sum = sb.toString();

            if(max.compareTo(sum) < 0) {
                max = sum;
            }
            if(min.compareTo(sum) > 0) {
                min = sum;
            }
            return;
        }

        for(int i = 0; i<10; i++) {
            if(!visited[i]) {
                visited[i] = true;

                if(depth == 0) {
                    // > 일때 첫번째 0 들어갈 수 없음
                    if(!(sign[0] == '>' && i == 0)) {
                        result[depth] = i;
                        signCheck(sign, depth+1, result, visited);
                    }
                }else {
                    if(sign[depth-1] == '<' && (result[depth-1] < i) ) {
                        result[depth] = i;
                        signCheck(sign,  depth+1, result, visited);
                    }
                    if(sign[depth-1] == '>' && (result[depth-1] > i) ) {
                        result[depth] = i;
                        signCheck(sign, depth+1, result, visited);
                    }
                }
                visited[i] = false;
            }
        }
    }
}