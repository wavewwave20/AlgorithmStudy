import java.io.*;
import java.util.*;

public class Main{
    static int SDB;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] ingredients = new int[n][2];

        for(int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }

        SDB = Integer.MAX_VALUE;
        generateSubset(0, 0, n, new boolean[n], ingredients);

        System.out.println(SDB);
    }  

    static void generateSubset(int cnt, int sCnt, int n, boolean[]isSelected, int[][]ingredients) {
        if(cnt == n) {
            if(sCnt == 0) {
                return;
            }
            
            int s = 1;
            int b = 0;
            for (int i = 0; i < ingredients.length; i++) {
                if(isSelected[i]) {
                    s *= ingredients[i][0];
                    b += ingredients[i][1];
                }
            }

            if(SDB > Math.abs(s-b)) {
                SDB = Math.abs(s-b);
            }
            return;
        }

        isSelected[cnt] = true;
        generateSubset(cnt+1,sCnt+1, n, isSelected, ingredients);
        isSelected[cnt] = false;
        generateSubset(cnt+1,sCnt, n, isSelected, ingredients);
    }
}