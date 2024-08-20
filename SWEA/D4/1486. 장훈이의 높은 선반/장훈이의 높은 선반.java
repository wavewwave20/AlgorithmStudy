import java.util.*;
import java.io.*;

class Solution{   
    static int result;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        for(int test_case = 1; test_case <= T; test_case++){  
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] heights = new int[N];
            result = Integer.MAX_VALUE;
            for(int i = 0; i<N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }
            //모든 부분집합을 구하여 리스트에 저장
            ArrayList<Integer> statList = new ArrayList<>();
            dfs(N, 0, 0, statList, heights);
            
            //모든 부분집합에 대해 높이 비교
            for(int stat : statList) {
                int sum = 0;
                for(int i = 0; i<N; i++) {
                    if((stat & 1<<i) != 0) {
                        sum+=heights[i];
                    }
                }

                if(B<=sum) {
                    int divided = Math.abs(sum-B);
                    if(result>divided) {
                        result = divided;
                    }
                }
            }

            sb.append("#" + test_case + " " + result).append("\n");
        }

        System.out.print(sb.toString());
    }

    //부분집합 dfs로 구하기 + 비트마스크 사용
    static void dfs(int N,int depth,int stat, List<Integer> statList, int[]heights) {
        if(depth == N) {
            // System.out.println(Integer.toBinaryString(stat));
            statList.add(stat);
            return;
        }

        dfs(N, depth+1, stat | 1<<depth, statList, heights);
        dfs(N, depth+1, stat, statList, heights);
    }
}