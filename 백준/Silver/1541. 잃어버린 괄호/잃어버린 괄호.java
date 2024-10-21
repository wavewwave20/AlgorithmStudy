import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int white,blue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int result = 0;
        boolean isPlus = true;
        for(int i = 0; i<str.length()+1; i++) {
            char now;
            if(i == str.length()) {
                now = '+';
            }else {
                now = str.charAt(i);
            }

            
            if(now != '+' && now != '-') {
                sb.append(now);
            }else {
                int num = Integer.parseInt(sb.toString());
                sb = new StringBuilder();

                if(isPlus) {
                    result += num;
                }else {
                    result -= num;
                }
            }

            if(now == '-') {
                isPlus = false;
            }
        }
        System.out.println(result);
    }
}