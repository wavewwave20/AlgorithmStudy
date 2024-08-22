import java.io.*;
import java.util.*;

public class Main {
    static int[][] result;

    static int[][] match = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {3, 4}, {3, 5}, {4, 5}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int T = 0; T<4 ; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
                result = new int[6][3];

            for(int i = 0; i< 6; i++ ) {
                for(int j = 0; j<3; j++) {
                    result[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if(check(new int[6][3], 0)) {
                sb.append(1 + " ");
            }else {
                sb.append(0 + " ");
            }

        }
        System.out.println(sb.toString());
    }

    static boolean check( int[][]map, int matchIdx) {
        if(matchIdx == 15) {
            for(int i = 0; i< 6; i++ ) {
                for(int j = 0; j<3; j++) {
                    if(map[i][j] != result[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
        int team1 = match[matchIdx][0];
        int team2 = match[matchIdx][1];

        //team1 승리 team2 패배
        map[team1][0]++;
        map[team2][2]++;
        if(result[team1][0] >= map[team1][0] && result[team2][2] >= map[team2][2]) {
            if(check( map, matchIdx+1)) {
                return true;
            }
        }
        map[team1][0]--;
        map[team2][2]--;

        //team1 패배 team2 승리
        map[team1][2]++;
        map[team2][0]++;
        if(result[team1][2] >= map[team1][2] && result[team2][0] >= map[team2][0]) {
            if(check( map, matchIdx+1)) {
                return true;
            }
        }
        map[team1][2]--;
        map[team2][0]--;


        //무승부
        map[team1][1]++;
        map[team2][1]++;
        if(result[team1][1] >= map[team1][1] && result[team2][1] >= map[team2][1]) {
            if(check(map, matchIdx+1)) {
                return true;
            }
        }
        map[team1][1]--;
        map[team2][1]--;

        return false;
    }


}
