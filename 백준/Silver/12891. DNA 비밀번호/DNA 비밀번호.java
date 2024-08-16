import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        int count = 0;
        int[] ACGT = new int[4];
        int[] countACGT;
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<4; i++) {
            int now = Integer.parseInt(st.nextToken());
            ACGT[i] = now;
        }

        int sIndex = 0;
        int eIndex = p-1;
        countACGT = new int[4];
        // 첫번째 윈도우 초기화
        for(int j = 0; j<p; j++) {
            char now =str.charAt(j);
            if(now == 'A') {
                countACGT[0]++;
            }else if(now == 'C') {
                countACGT[1]++;
            }else if(now == 'G') {
                countACGT[2]++;
            }else if(now == 'T') {
                countACGT[3]++;
            }
        }
        boolean flag = true;
        for(int j = 0; j<4; j++) {
            if(countACGT[j] < ACGT[j]) {
                flag = false;
            }
        }

        if(flag) {
            count++;
        }
        sIndex++;
        eIndex++;

        //두번째 윈도우부터 끝까지
        for(int i = p; i<s; i++) {
            char sChar =str.charAt(sIndex++ -1);
            char eChar =str.charAt(eIndex++);
    
            if(sChar == 'A') {
                countACGT[0]--;
            }else if(sChar == 'C') {
                countACGT[1]--;
            }else if(sChar == 'G') {
                countACGT[2]--;
            }else if(sChar == 'T') {
                countACGT[3]--;
            }
            
            if(eChar == 'A') {
                countACGT[0]++;
            }else if(eChar == 'C') {
                countACGT[1]++;
            }else if(eChar == 'G') {
                countACGT[2]++;
            }else if(eChar == 'T') {
                countACGT[3]++;
            }

            flag = true;
            for(int j = 0; j<4; j++) {
                if(countACGT[j] < ACGT[j]) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                count++;
            }
        }

        System.out.println(count);
    }  
}