import java.io.*;
import java.util.*;

public class Main{
    static int cnt =0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        hanoi(n,1,3,2, sb);
        System.out.println(""+cnt);
        System.out.println(sb.toString());
    } 

    /*  https://mgyo.tistory.com/185
     * 
     *  honoi(N, start, to, via) =
     *   if(N==1)
     *      move(1, start, to)
     *   else
     *      hanoi(N-1, start, via, to) +
     *      move(N-1, start, to) +
     *      hanoi(N-1, via, to, start)
     */
    static void hanoi(int N, int start, int to, int via, StringBuilder sb) {
        if(N == 1) {
            move(1, start, to, sb);
        } else {
            hanoi(N-1, start, via, to, sb);
            move(N-1, start, to, sb);
            hanoi(N-1, via, to, start, sb);
        }
    }

    static void move(int N, int start, int to, StringBuilder sb ) {
        sb.append(""+ start +" "+ to +"\n");
        cnt++;
    }
}

