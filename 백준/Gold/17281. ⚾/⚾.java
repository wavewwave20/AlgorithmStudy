import java.io.*;
import java.util.*;

public class Main {
    static int N, maxScore;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        maxScore = -1;
        map = new int[N][9];

        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        permutation(0, new int[9], new boolean[9]);

        System.out.println(maxScore);
    }

    // 순서 결정 순열 making 함수
    //game 호출

    static void permutation(int cnt, int[] result, boolean[] visited) {
        if(cnt == 9) {
            int tmp = game(N, result, map);
            if(maxScore < tmp) {
                maxScore = tmp;
            }
            return;
        }


        if(cnt == 3) {
            result[cnt] = 0;
            permutation(cnt+1, result, visited);
        }

        for(int i = 1; i<9; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            result[cnt] = i;
            permutation(cnt+1, result, visited);
            visited[i] = false;
        }
    }


    static int game(int n, int[] order, int[][] map) {
        // 주어진 순서로 게임 시작
        
        //이닝별 리셋 안됨
        int player = 0;
        int score = 0;

        //이닝별 리셋
        int out = 0;
        boolean [] base = new boolean[3];

        for(int inning = 0; inning<n; inning++) {

            while(out < 3) {
                int play = map[inning][order[player++ % 9]];

                switch (play) {
                    case 0:
                        // 아웃: 0
                        out++;
                        break;
                    case 1:
                        // 안타: 1
                        if(base[2]) {
                            score++;
                            base[2] = false;
                        }
                        if(base[1]) {
                            base[1] = false;
                            base[2] = true;
                        }
                        if(base[0]) {
                            base[0] = false;
                            base[1] = true;
                        }
                        base[0] = true;
                        break;  
                    case 2:
                        // 2루타: 2
                        if(base[2]) {
                            score++;
                            base[2] = false;
                        }
                        if(base[1]) {
                            score++;
                            base[1] = false;
                        }
                        if(base[0]) {
                            base[0] = false;
                            base[2] = true;
                        }
                        base[1] = true;
                        break;
                    case 3:
                        // 3루타: 3
                        if(base[2]) {
                            score++;
                            base[2] = false;
                        }
                        if(base[1]) {
                            score++;
                            base[1] = false;
                        }
                        if(base[0]) {
                            score++;
                            base[0] = false;
                        }
                        base[2] = true;
                        break;
                    case 4:
                        // 홈런: 4
                        if(base[2]) {
                            score++;
                            base[2] = false;
                        }
                        if(base[1]) {
                            score++;
                            base[1] = false;
                        }
                        if(base[0]) {
                            score++;
                            base[0] = false;
                        }
                        score++;
                        break;
                }

            }
            out = 0;
            base = new boolean[3];
        }


        return score;
    }
}