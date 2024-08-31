import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2,N);

        dq(size,r,c);

        System.out.println(count);
    }

    static void dq(int size, int r, int c) {
        if(size == 1) {
            return;
        }

        if(r<size/2 && c<size/2) { //좌상단 사분면에 r,c 위치
            //사분면이 조정되어도 count와 r,c의 상대적인 위치는 불변
            dq(size/2, r,c);
        }else if(r<size/2 && c >= size/2) { //우상단 사분면
            //사분면이 조정되어 상대적 위치 변경
            count += (size * size/ 4);
            //x좌표가 새로운 사분면에서 0으로 시작하기위해 size/2를 뺌
            dq(size/2, r, c - size/2);
        }else if(r >= size/2 && c < size/2)  {
            count += (size * size/ 4) * 2;
            dq(size/2, r- size/2, c);
        }else {
            count += (size * size/ 4) * 3;
            dq(size/2, r - size/2, c - size/2);
        }
    }
}
