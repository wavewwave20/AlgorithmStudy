import java.util.*;
import java.io.*;

class Solution{  
    static int result;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		
        int T= Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){  
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] pairs = new int[M][2];
            result = 0;
            for(int i =0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                pairs[i][0] = Integer.parseInt(st.nextToken()) -1;
                pairs[i][1] = Integer.parseInt(st.nextToken()) -1;
            }
            generateSubset(N, 0, pairs, new boolean[N]);
            sb.append("#" + test_case + " " + result + "\n");
		}
        System.out.println(sb.toString());
	}

    static void generateSubset(int n, int cnt, int[][]pairs, boolean[]isSelected) {
        if(n==cnt) {

            for (int[] pair : pairs) {
                if(isSelected[pair[0]] && isSelected[pair[1]]) {
                    return;
                }
            }
            result++;
            return;
        }

        isSelected[cnt] = true;
        generateSubset(n, cnt+1, pairs, isSelected);
        isSelected[cnt] = false;
        generateSubset(n, cnt+1, pairs, isSelected);
    }
}
