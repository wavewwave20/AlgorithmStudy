import java.util.*;
import java.io.*;

class Solution{   
    static int maxScore;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        for(int test_case = 1; test_case <= T; test_case++){  
            maxScore = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[] scores = new int[N];
            int[] cals = new int[N];
            
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                scores[i] = Integer.parseInt(st.nextToken());
                cals[i] = Integer.parseInt(st.nextToken());
            }
            
            // combination(0, N, L, scores, cals, 0, 0);

            burgerCombination(N, scores, cals, L);
            sb.append("#" + test_case + " " + maxScore).append("\n");
        }

        System.out.print(sb.toString());
    }

    // static void combination(int start, int N, int L, int[] scores, int[] cals, int calSum, int scoreSum) {
    //     for (int i = start; i < N; i++) {
    //         int tmpCalSum = calSum + cals[i];
    //         if (tmpCalSum <= L) {
    //             int tmpScoreSum = scoreSum + scores[i];

    //             if (maxScore < tmpScoreSum) {
    //                 maxScore = tmpScoreSum;
    //             }
    //             combination(i + 1, N, L, scores, cals, tmpCalSum, tmpScoreSum);
    //         }
    //     }
    // }

    static void burgerCombination(int N, int[]scores, int[]cals, int maxCal) {
        for(int i = 0; i<N; i++) {
            int[] ingStat = new int[N];
            for(int j = 0; j<=i; j++) {
                ingStat[N-j-1] = 1;
            }
            do{
                int calSum = 0;
                int scoreSum = 0;
    
                for (int k = 0; k < N; k++) {
                    if (ingStat[k] == 1) {
                        calSum += cals[k];
                        scoreSum += scores[k];
                    }
                }
    
                if (calSum <= maxCal) {
                    maxScore = Math.max(maxScore, scoreSum);
                }
            }while(nextPermutation(ingStat));
        }
    }

    static boolean nextPermutation(int[]p) {
        int N = p.length;
        int i = N-1;
        while(i>0 && p[i-1] >=p[i]) {
            i--;
        }

        if(i==0) {
            return false;
        }

        int j = N-1;
        while(p[i-1] >= p[j]) {
            j--;
        }
        swap(p, i-1, j);

        int k = N-1;
        while(i<k) {
            swap(p, i++, k--);
        }
        return true;
    }

    static void swap(int[]p, int i, int j) {
        int tmp = p[i];
        p[i]=p[j];
        p[j]=tmp;
    }
}