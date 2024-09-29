import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] boolArr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        while(true)  {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int[] num = new int[3];
            num[0] = Integer.parseInt(st.nextToken());
            num[1] = Integer.parseInt(st.nextToken());
            num[2] = Integer.parseInt(st.nextToken());
            if(num[0] == 0 && num[1] ==0 && num[2] == 0) {
                break;
            }

            int max = Math.max(num[0], Math.max(num[1], num[2]));
            int maxIndex = 0;
            for(int i = 0; i<3; i++) {
                if(max == num[i]) {
                    maxIndex = i;
                    break;
                }
            }

            int[] cal = new int[3];
            cal[0] = max;
            int index = 1;
            for(int i = 0; i<3; i++) {
                if(maxIndex == i) {
                    continue;
                }
                cal[index++] = num[i];
            }

            if(Math.pow(cal[0],2) == Math.pow(cal[1],2) + Math.pow(cal[2],2)) {
                answer.append("right\n");
            }else {
                answer.append("wrong\n");
            }
            
            
        }
        System.out.println(answer.toString());
    }

    
}