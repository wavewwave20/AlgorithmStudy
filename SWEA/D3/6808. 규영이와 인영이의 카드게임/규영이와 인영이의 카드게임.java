import java.util.*;
import java.io.*;

class Solution
{   
    static int win;
    static int lose;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++){  
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean[] cards = new boolean[19];

            int[]gCard = new int[9];
            int[]iCard = new int [9];

            for(int i = 0; i<9; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                cards[tmp] = true;
                gCard[i] = tmp;
            }
            int index = 0;
            for(int i = 1; i<19; i++) {
                if(cards[i] != true) {
                    iCard[index++] = i;
                }
            }
            win = 0;
            lose = 0;
            boolean[] visited = new boolean[18];
            int[]result = new int[9];
            permutation(gCard, iCard, visited, result, 0);

            sb.append("#"+test_case+" "+win + " "+lose + "\n");
		}
        System.out.println(sb.toString());
	}

    static void permutation(int[]gCard, int[]iCard, boolean[]visited, int[]result, int depth) {
        if(depth == 9) {
            int gSum = 0;
            int iSum = 0;
            for(int i = 0; i<9; i++) {
                if(gCard[i] > result[i]) {
                    gSum += gCard[i] + result[i];
                }else {
                    iSum += gCard[i] + result[i];
                }
            }
            if(gSum>iSum) {
                win++;
            } else {
                lose++;
            }
            return;
        }

        for(int i = 0; i<9; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                result[depth] = iCard[i];
                permutation(gCard, iCard, visited, result, depth+1);
                visited[i] = false;
            }
        }
    }
}
