import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] W;
    static int[][] dp;
    static final int INF = 1_000_000_000;

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[1<<N][N];

        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dp 테이블 초기화
        for(int i = 0; i<(1<<N); i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(tsp(1,0));
    }

    static int tsp(int visited, int current) {
        // 모든 도시를 방문한 경우 출발 도시로 돌아가는 비용 반환
        if(visited == (1<<N)-1) { //비트마스킹 모두 1
            return W[current][0] == 0 ? INF : W[current][0];
        }

        //이미 계산된 경우 값만 반환
        if(dp[visited][current] != -1) {
            return dp[visited][current];
        }

        //초기화
        dp[visited][current] = INF;
    
        //모든 도시를 탐색
        for(int next = 0; next<N; next++) {
            //이미 방문했거나 길이 없는 경우 무시
            if((visited & (1 << next)) != 0 || W[current][next] == 0) {
                continue;
            }

            // 다음 도시를 방문한 상태로 점화식 계산
            dp[visited][current] = 
            Math.min(
                dp[visited][current], 
                tsp(visited | (1 << next), next) + W[current][next]
            );   
        }
        return dp[visited][current];
    }
}