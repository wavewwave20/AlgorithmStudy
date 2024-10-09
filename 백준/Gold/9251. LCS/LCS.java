import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 입력: 
        String arr1Str = br.readLine();
        int n = arr1Str.length();
        int[] arr1 = new int[n+1];
        for(int i = 1; i<=n; i++) {
            arr1[i] = arr1Str.charAt(i-1);
        }


        String arr2Str = br.readLine();
        int m = arr2Str.length();
        int[] arr2 = new int[m+1];
        for(int i = 1; i<=m; i++) {
            arr2[i] = arr2Str.charAt(i-1);
        }

        int[][]LCS = new int[n+1][m+1];

        for(int y = 1; y<n+1; y++) {
            for(int x = 1; x<m+1; x++) {
                if(arr1[y] == arr2[x]) {
                    LCS[y][x] = LCS[y-1][x-1] + 1;
                }else {
                    LCS[y][x] = Math.max(LCS[y-1][x],LCS[y][x-1]);
                }
            }
        }

        int max = 0;

        for(int y = 1; y<n+1; y++) {
            for(int x = 1; x<m+1; x++) {
                if(max< LCS[y][x]) {
                    max = LCS[y][x];
                }
            }
        }
        System.out.println(max);
    }
}
