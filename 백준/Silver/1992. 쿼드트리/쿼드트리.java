import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i = 0; i<N; i++) {
            String line = br.readLine();
            for(int j = 0; j<N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        String s = decomposition(N, 0, 0, map);

        System.out.println(s);
    }

    static String decomposition(int l,int x,int y, int[][]map) {
        if(l == 1) {
            return "" +map[0][0];
        }

        if (l == 2) {
            int i1 = map[y][x];
            int i2 = map[y][x+1];
            int i3 = map[y+1][x];
            int i4 = map[y+1][x+1];

            String result = "";
            if(i1 == i2 && i2 == i3 && i3 == i4) {
                result += i1;
            }else {
                result = "(" + i1 + i2 + i3 + i4 + ")";
            }
            return result;
        }
        String s1 = decomposition(l/2, x, y, map);
        String s2 = decomposition(l/2, x+l/2, y, map);
        String s3 = decomposition(l/2, x, y+l/2, map);
        String s4 = decomposition(l/2, x+l/2, y+l/2, map);
        String result = "";

        if(s1.charAt(0) == '(' || s2.charAt(0) == '('|| s3.charAt(0) == '('|| s4.charAt(0) == '(') {
            return "(" + s1 + s2 + s3 + s4 + ")";
        }

        if(s1.equals(s2) && s2.equals(s3) && s3.equals(s4)) {
            result += s1;
        }else {
            result = "(" + s1 + s2 + s3 + s4 + ")";
        }
        return result;
    }
    
}
